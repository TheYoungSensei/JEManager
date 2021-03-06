package persistence.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import biz.Contact;
import biz.ContactFactory;
import biz.Dto;
import exceptions.FatalException;
import exceptions.OptimisticException;
import persistence.DalBackEndServices;

public class ContactDaoImpl implements ContactDao {

  private DalBackEndServices dalBackendService;
  private ContactFactory contactFactory;

  public ContactDaoImpl(DalBackEndServices dalServices, ContactFactory contactFactory) {
    this.dalBackendService = dalServices;
    this.contactFactory = contactFactory;
  }

  @Override
  public List<Contact> getAllContacts() {
    List<Contact> contacts = new ArrayList<Contact>();
    try (PreparedStatement prepare = dalBackendService.prepareStatement("query.getAllContacts")) {
      try (ResultSet result = prepare.executeQuery()) {
        while (result.next()) {
          Contact contact = (Contact) contactFactory.getContact();
          contact.setContactId(result.getInt(1));
          contact.setCompanyId(result.getInt(2));
          contact.setFirstName(result.getString(3));
          contact.setLastName(result.getString(4));
          contact.setEmail(result.getString(5));
          contact.setPhoneNumber(result.getString(6));
          contact.setActive(result.getBoolean(7));
          contact.setVersion(result.getInt(8));
          contacts.add(contact);
        }
      } catch (SQLException sqle) {
        throw new FatalException(sqle);
      }
    } catch (SQLException sqle2) {
      throw new FatalException(sqle2);
    }
    return contacts;
  }

  @Override
  public Contact getContactById(int idContact) {
    Contact contact = (Contact) contactFactory.getContact();
    try (PreparedStatement prepare = dalBackendService.prepareStatement("query.getContactById")) {
      prepare.setInt(1, idContact);
      try (ResultSet result = prepare.executeQuery()) {
        while (result.next()) {
          contact.setContactId(result.getInt(1));
          contact.setCompanyId(result.getInt(2));
          contact.setFirstName(result.getString(3));
          contact.setLastName(result.getString(4));
          contact.setEmail(result.getString(5));
          contact.setPhoneNumber(result.getString(6));
          contact.setActive(result.getBoolean(7));
          contact.setVersion(result.getInt(8));
          return contact;
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
  public int update(Dto dto) {
    Contact contact = (Contact) dto;
    // int contactId;
    // int compteur = 0;
    try (PreparedStatement prepare = dalBackendService.prepareStatement("query.update")) {
      prepare.setString(1, contact.getFirstName());
      prepare.setString(2, contact.getLastName());
      prepare.setString(3, contact.getEmail());
      prepare.setString(4, contact.getPhoneNumber());
      prepare.setBoolean(5, contact.isActive());
      prepare.setInt(6, contact.getContactId());
      prepare.setInt(7, contact.getVersion());
      try (ResultSet result = prepare.executeQuery()) {
        while (result.next()) {
          // compteur++;
          // contactId = result.getInt(1);
          return result.getInt(1);
        }
      } catch (SQLException sqle) {
        throw new FatalException(sqle);
      }
    } catch (SQLException sqle2) {
      throw new FatalException(sqle2);
    }
    // if (compteur == 0) {
    throw new OptimisticException();
    // }
    // return -1;
  }

  @Override
  public int insert(Dto dto) {
    Contact contact = (Contact) dto;
    int id = -1;
    try (PreparedStatement prepare = dalBackendService.prepareStatement("query.addContact")) {
      prepare.setInt(1, contact.getCompanyId());
      prepare.setString(2, contact.getFirstName());
      prepare.setString(3, contact.getLastName());
      prepare.setString(4, contact.getEmail());
      prepare.setString(5, contact.getPhoneNumber());
      prepare.setBoolean(6, contact.isActive());
      try (ResultSet result = prepare.executeQuery()) {
        while (result.next()) {
          id = result.getInt(1);
          return id;
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
    throw new UnsupportedOperationException();
  }

}


