package persistence.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import biz.Company;
import biz.CompanyFactory;
import biz.Contact;
import biz.ContactFactory;
import biz.Dto;
import biz.Event;
import biz.EventFactory;
import biz.objects.CompanyImpl;
import biz.objects.ContactImpl;
import biz.objects.EventImpl;
import exceptions.FatalException;
import persistence.DalBackEndServices;
import util.Util;

public class EventDaoImpl implements EventDao {

  private DalBackEndServices dalBackendService;
  private EventFactory eventFactory;
  private ContactFactory contactFactory;
  private CompanyFactory companyFactory;

  /**
   * The constructor of this class.
   * 
   * @param dalServices the dalServices linking us to the DB
   * @param contactFactory the factory for contacts
   * @param companyFactory the factory for companies
   * @param eventFactory the factory for events
   */
  public EventDaoImpl(DalBackEndServices dalServices, EventFactory eventFactory,
      ContactFactory contactFactory, CompanyFactory companyFactory) {
    this.dalBackendService = dalServices;
    this.eventFactory = eventFactory;
    this.contactFactory = contactFactory;
    this.companyFactory = companyFactory;
  }

  /**
   * {@inheritDoc}.
   */
  public HashMap<Company, ArrayList<Contact>> getMyParticipants(int eventId) {
    HashMap<Company, ArrayList<Contact>> toReturn = new HashMap<Company, ArrayList<Contact>>();
    ArrayList<Contact> companysContacts = new ArrayList<Contact>();
    int currentCompanyId = -1;
    CompanyImpl currentCompany = null;
    try (PreparedStatement getCompaniesParticipating =
        dalBackendService.prepareStatement("query.getCompaniesAndContactParticipating")) {
      getCompaniesParticipating.setInt(1, eventId);
      try (ResultSet result = getCompaniesParticipating.executeQuery()) {
        while (result.next()) {
          if (result.getInt(1) != currentCompanyId) {
            if (currentCompany != null) {
              toReturn.put(currentCompany, companysContacts);
            }
            currentCompany = (CompanyImpl) companyFactory.getCompany();
            companysContacts = new ArrayList<Contact>();
            currentCompanyId = result.getInt(1);
            currentCompany.setName(result.getString(2));
          }
          ContactImpl contact = (ContactImpl) contactFactory.getContact();
          contact.setFirstName(result.getString(3));
          contact.setLastName(result.getString(4));
          contact.setEmail(result.getString(5));
          contact.setPhoneNumber(result.getString(6));
          companysContacts.add(contact);
        }
        toReturn.put(currentCompany, companysContacts);
      }
    } catch (SQLException sqle) {
      throw new FatalException(sqle);
    }
    return toReturn;
  }

  @Override
  public Event getCurrentEvent() {
    boolean anEventWasFound = false; // whether or not we have an result from our query
    EventImpl toReturn = (EventImpl) eventFactory.getEvent();
    try (PreparedStatement getCurrentEvent =
        dalBackendService.prepareStatement("query.getCurrentEvent")) {
      try (ResultSet result = getCurrentEvent.executeQuery()) {
        while (result.next()) {
          anEventWasFound = true; // signaling we have a result
          toReturn.setEventId(result.getInt(1));
          toReturn.setDate(Util.stringToLocalDateTime(result.getString(2)));
          toReturn.setClosed(false);
        }
      }
    } catch (SQLException sqle) {
      throw new FatalException(sqle);
    }
    if (!anEventWasFound) { // returning null if no event was found
      return null;
    }
    return toReturn;
  }

  @Override
  public List<Event> selectAll() {
    List<Event> events = new ArrayList<Event>();
    try (PreparedStatement prepare = dalBackendService.prepareStatement("query.getAllEvents")) {
      try (ResultSet result = prepare.executeQuery()) {
        while (result.next()) {
          Event event = (Event) eventFactory.getEvent();
          event.setEventId(result.getInt(1));
          event.setDate(Util.stringToLocalDateTime(result.getString(2)));
          event.setClosed(result.getBoolean(3));
          events.add(event);
        }
      } catch (SQLException sqle) {
        throw new FatalException(sqle);
      }
    } catch (SQLException sqle2) {
      throw new FatalException(sqle2);
    }
    return events;
  }

  @Override
  public Event findEventById(int idEvent) {
    try (PreparedStatement prepare = dalBackendService.prepareStatement("query.getEventById")) {
      prepare.setInt(1, idEvent);
      try (ResultSet result = prepare.executeQuery()) {
        while (result.next()) {
          Event event = (Event) eventFactory.getEvent();
          event.setEventId(result.getInt(1));
          event.setDate(Util.stringToLocalDateTime(result.getString(2)));
          event.setClosed(result.getBoolean(3));
          return event;
        }
      } catch (SQLException sqle) {
        throw new FatalException(sqle);
      }
    } catch (SQLException sqle2) {
      throw new FatalException(sqle2);
    }
    return null;
  }

  @Override
  public HashMap<Company, ArrayList<Contact>> getParticipationDatas(int participationId) {
    HashMap<Company, ArrayList<Contact>> toReturn = new HashMap<Company, ArrayList<Contact>>();
    ArrayList<Contact> companysContacts = new ArrayList<Contact>();
    int currentCompanyId = -1;
    CompanyImpl currentCompany = null;
    try (PreparedStatement getCompanyAndContacts =
        dalBackendService.prepareStatement("query.getCompanyAndContacts")) {
      getCompanyAndContacts.setInt(1, participationId);
      try (ResultSet result = getCompanyAndContacts.executeQuery()) {
        while (result.next()) {
          if (result.getInt(1) != currentCompanyId) {
            if (currentCompany != null) {
              toReturn.put(currentCompany, companysContacts);
            }
            currentCompany = (CompanyImpl) companyFactory.getCompany();
            companysContacts = new ArrayList<Contact>();
            currentCompany.setName(result.getString(2));
            currentCompanyId = result.getInt(1);
          }
          ContactImpl contact = (ContactImpl) contactFactory.getContact();
          contact.setPhoneNumber(result.getString(6));
          contact.setFirstName(result.getString(3));
          contact.setLastName(result.getString(4));
          contact.setEmail(result.getString(5));
          companysContacts.add(contact);
        }
        toReturn.put(currentCompany, companysContacts);
      }
    } catch (SQLException sqle) {
      throw new FatalException(sqle);
    }
    return toReturn;
  }

  @Override
  public int update(Dto dto) {
    throw new UnsupportedOperationException();
  }

  @Override
  public int insert(Dto dto) {
    Event event = (Event) dto;
    int id = -1;
    // Close past events
    PreparedStatement prepareClose = dalBackendService.prepareStatement("query.closeEvent");
    try {
      prepareClose.executeQuery().close();
    } catch (SQLException sqle2) {
      throw new FatalException(sqle2);
    }

    // Add new event
    try (PreparedStatement prepare = dalBackendService.prepareStatement("query.addEvent")) {
      prepare.setString(1, Util.localDateTimeToString(event.getDate()));
      try (ResultSet result = prepare.executeQuery()) {
        while (result.next()) {
          id = result.getInt(1);
        }
      } catch (SQLException sqle) {
        throw new FatalException(sqle);
      }
    } catch (SQLException sqle2) {
      throw new FatalException(sqle2);
    }
    return id;
  }

  @Override
  public int delete(Dto dto) {
    return 0;
  }
}
