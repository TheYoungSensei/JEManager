package ucc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import biz.Company;
import biz.Contact;
import biz.Event;
import biz.EventDto;
import persistence.DalServices;
import persistence.UnitOfWork;
import persistence.dao.EventDao;

public class EventUccImpl implements EventUcc {

  private EventDao eventDao;
  private UnitOfWork unit;
  private DalServices dal;

  /**
   * @param eventDao the ucc's dao
   * @param unit the ucc's unit of work
   * @param dal the ucc's instance of dalservices
   * @author alexandre.maniet
   */
  public EventUccImpl(EventDao eventDao, UnitOfWork unit, DalServices dal) {
    this.eventDao = eventDao;
    this.unit = unit;
    this.dal = dal;
  }

  @Override
  public HashMap<String, Object> generateFullCsv(EventDto event) {
    dal.startTransaction();
    HashMap<String, Object> toReturn = new HashMap<String, Object>();
    HashMap<Company, ArrayList<Contact>> myCompanyAndContacts =
        eventDao.getMyParticipants(event.getEventId());
    dal.commit();
    int order = 0;
    for (Entry<Company, ArrayList<Contact>> company : myCompanyAndContacts.entrySet()) {
      for (Contact contact : company.getValue()) {
        String row =
            company.getKey().getName() + ";" + contact.getLastName() + ";" + contact.getFirstName()
                + ";" + contact.getEmail() + ";" + contact.getPhoneNumber() + ";";
        toReturn.put(order + "", row);
        order++;
      }
    }
    return toReturn;
  }

  @Override
  public EventDto getCurrentEvent() {
    dal.startTransaction();
    EventDto event = eventDao.getCurrentEvent();
    dal.commit();
    return event;
  }

  @Override
  public List<EventDto> getAllEvents() {
    dal.startTransaction();
    List<EventDto> list =
        eventDao.selectAll().stream().map(e -> (EventDto) e).collect(Collectors.toList());
    dal.commit();
    return list;
  }

  @Override
  public EventDto addNewEvent(EventDto eventDto) {
    unit.startTransaction();
    if (eventDto != null) {
      Event toCreate = (Event) eventDto;
      Event current = (Event) this.getCurrentEvent();
      if (!toCreate.isAfter(current)) {
        unit.rollBack();
        return null;
      } else {
        unit.addInsert(toCreate);
        unit.commit();
        return eventDto;
      }
    }
    return null;
  }

  @Override
  public HashMap<String, Object> generateCsvRows(int idParticipation) {
    dal.startTransaction();
    HashMap<String, Object> toReturn = new HashMap<String, Object>();
    HashMap<Company, ArrayList<Contact>> theCompanyAndContacts =
        eventDao.getParticipationDatas(idParticipation);
    dal.commit();
    int order = 0;
    for (Entry<Company, ArrayList<Contact>> company : theCompanyAndContacts.entrySet()) {
      for (Contact contact : company.getValue()) {
        String row =
            company.getKey().getName() + ";" + contact.getLastName() + ";" + contact.getFirstName()
                + ";" + contact.getEmail() + ";" + contact.getPhoneNumber() + ";";
        toReturn.put(order + "", row);
        order++;
      }
    }
    return toReturn;
  }

  @Override
  public EventDto getEventById(int id) {
    dal.startTransaction();
    EventDto event = this.eventDao.findEventById(id);
    dal.commit();
    return event;
  }
}
