package persistence.dao;

import java.util.List;

import biz.Company;
import biz.Contact;

public interface CompanyDao extends Dao {

  /**
   * @author Sacre.Christopher
   * @return All the companies found in the database.
   */
  List<Company> selectAll();

  /**
   * @author Antoine.Maniet
   * @return A List of all the companies who could still be invited
   */
  List<Company> getCompaniesToInvite();

  /**
   * get a company from its id.
   * 
   * @param idCompany the id of the company
   * @return null if the company isn't found, the Company otherwise.
   */
  Company getCompanyById(int idCompany);

  /**
   * @author Sacre.Christopher
   * @param company to search the contacts.
   * @return the contacts list of the company passed in argument.
   */
  List<Contact> getMyContacts(Company company);
}
