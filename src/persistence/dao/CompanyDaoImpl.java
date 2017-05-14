package persistence.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import biz.Company;
import biz.CompanyFactory;
import biz.Contact;
import biz.ContactFactory;
import biz.Dto;
import exceptions.FatalException;
import persistence.DalBackEndServices;
import util.Util;

public class CompanyDaoImpl implements CompanyDao {

  private DalBackEndServices dalBackendService;
  private CompanyFactory companyFactory;
  private ContactFactory contactFactory;

  /**
   * The constructor of this class.
   * 
   * @param dalServices the dalServices linking us to the DB
   * @param contactFactory the factory for contacts
   * @param companyFactory the factory for companies
   */
  public CompanyDaoImpl(DalBackEndServices dalServices, CompanyFactory companyFactory,
      ContactFactory contactFactory) {
    this.dalBackendService = dalServices;
    this.companyFactory = companyFactory;
    this.contactFactory = contactFactory;
  }

  @Override
  public List<Company> selectAll() {
    List<Company> companies = new ArrayList<Company>();
    try (PreparedStatement prepare = dalBackendService.prepareStatement("query.getAllCompanies")) {
      try (ResultSet result = prepare.executeQuery()) {
        while (result.next()) {
          Company company = (Company) companyFactory.getCompany();
          company.setName(result.getString(3));
          company.setCompanyId(result.getInt(1));
          company.setCreatorId(result.getInt(2));
          company.setBox(result.getString(7));
          company.setDateFirstContact(Util.stringToLocalDateTime(result.getString(4)));
          company.setStreet(result.getString(5));
          company.setMunicipality(result.getString(9));
          company.setNumber(result.getInt(6));
          company.setPostalCode(result.getInt(8));
          companies.add(company);
        }
      } catch (SQLException sqle) {
        throw new FatalException(sqle);
      }
    } catch (SQLException sqle2) {
      throw new FatalException(sqle2);
    }
    return companies;
  }

  @Override
  public List<Company> getCompaniesToInvite() {
    List<Company> companies = new ArrayList<Company>();
    try (PreparedStatement prepare =
        dalBackendService.prepareStatement("query.getCompaniesToInvite")) {
      try (ResultSet result = prepare.executeQuery()) {
        while (result.next()) {
          Company company = (Company) companyFactory.getCompany();
          company.setCompanyId(result.getInt(1));
          company.setName(result.getString(3));
          company.setDateFirstContact(Util.stringToLocalDateTime(result.getString(4)));
          company.setCreatorId(result.getInt(2));
          company.setStreet(result.getString(5));
          company.setNumber(result.getInt(6));
          company.setPostalCode(result.getInt(8));
          company.setMunicipality(result.getString(9));
          company.setBox(result.getString(7));
          companies.add(company);
        }
      } catch (SQLException sqle) {
        throw new FatalException(sqle);
      }
    } catch (SQLException sqle2) {
      throw new FatalException(sqle2);
    }
    return companies;
  }

  @Override
  public Company getCompanyById(int idCompany) {
    Company company = (Company) companyFactory.getCompany();
    try (PreparedStatement prepare = dalBackendService.prepareStatement("query.getCompanyById")) {
      prepare.setInt(1, idCompany);
      try (ResultSet result = prepare.executeQuery()) {
        while (result.next()) {
          company.setCompanyId(result.getInt(1));
          company.setCreatorId(result.getInt(2));
          company.setName(result.getString(3));
          company.setDateFirstContact(Util.stringToLocalDateTime(result.getString(4)));
          company.setStreet(result.getString(5));
          company.setNumber(result.getInt(6));
          company.setBox(result.getString(7));
          company.setPostalCode(result.getInt(8));
          company.setMunicipality(result.getString(9));
        }
      } catch (SQLException sqle) {
        throw new FatalException(sqle);
      }
    } catch (SQLException sqle2) {
      throw new FatalException(sqle2);
    }
    return company;
  }

  @Override
  public List<Contact> getMyContacts(Company company) {
    Util.checkNull(company);
    List<Contact> contacts = new ArrayList<Contact>();
    try (PreparedStatement preparedStatement =
        dalBackendService.prepareStatement("query.getContactsPerCompany")) {
      preparedStatement.setInt(1, company.getCompanyId());
      try (ResultSet result = preparedStatement.executeQuery()) {
        while (result.next()) {
          Contact contact = (Contact) contactFactory.getContact();
          contact.setContactId(result.getInt(1));
          contact.setFirstName(result.getString(2));
          contact.setLastName(result.getString(3));
          contact.setEmail(result.getString(4));
          contact.setPhoneNumber(result.getString(5));
          contact.setActive(result.getBoolean(6));
          contact.setVersion(result.getInt(7));
          contacts.add(contact);
        }
      } catch (SQLException sqle) {
        throw new FatalException(sqle);
      }
    } catch (SQLException sqle) {
      throw new FatalException(sqle);
    }
    return contacts;
  }

  @Override
  public int update(Dto dto) {
    throw new UnsupportedOperationException();
  }

  @Override
  public int insert(Dto dto) {
    Company company = (Company) dto;
    // Will be used to gather the inserted company's id
    int id = -1;
    // checking argument
    if (company == null) {
      throw new IllegalArgumentException();
    }
    // Creating the prepared statement
    try (PreparedStatement preparedStatement =
        dalBackendService.prepareStatement("query.insertCompany")) {
      // setting the prepared statement's values
      preparedStatement.setInt(1, company.getCreator().getUserId());
      preparedStatement.setString(2, company.getName());
      preparedStatement.setString(3, Util.localDateTimeToString(company.getDateFirstContact()));
      preparedStatement.setString(4, company.getStreet());
      preparedStatement.setInt(5, company.getNumber());
      preparedStatement.setString(6, company.getBox());
      preparedStatement.setInt(7, company.getPostalCode());
      preparedStatement.setString(8, company.getMunicipality());
      // Executing the prepared statement
      try (ResultSet result = preparedStatement.executeQuery()) {
        while (result.next()) {
          // Getting the inserted company's generated id
          id = result.getInt(1);
        }
      } catch (SQLException sqle) {
        throw new FatalException(sqle);
      }
    } catch (SQLException sqle2) {
      throw new FatalException(sqle2);
    }
    // Throwing exception if the insertion was unsuccessful
    if (id == -1) {
      throw new RuntimeException();
    }
    // Getting full company from the returned id
    Company insertedCompany = getCompanyById(id);
    return insertedCompany.getCompanyId();
  }

  @Override
  public int delete(Dto dto) {
    throw new UnsupportedOperationException();
  }
}


