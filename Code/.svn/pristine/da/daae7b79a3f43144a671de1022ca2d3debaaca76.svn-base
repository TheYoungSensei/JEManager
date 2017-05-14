package ucc;

import java.util.List;

import biz.CompanyDto;
import biz.ContactDto;

public interface CompanyUcc {

  /**
   * @author Sacre.Christopher
   * @return The list about the companies found in the database.
   */
  List<CompanyDto> getAllCompanies();

  /**
   * @author Antoine.Maniet
   * @param idCompany The id of the company we're looking for in the DB
   * @return The informations of the company associated to the idCompany, in a CompanyDto
   */
  CompanyDto getCompanyById(int idCompany);

  /**
   * @author Antoine.Maniet
   * @return All the companies who could still be invited
   */
  List<CompanyDto> getCompaniesToInvite();

  /**
   * @author Maniet.Alexandre
   * @param companyDto The company to register.
   * @return A completed version of the Dto object passed as argument.
   * @throws IllegalArgumentException if the dto passed as argument is null
   */
  CompanyDto addCompany(CompanyDto companyDto);

  /**
   * @author Sacre.Christopher
   * @param companyDto to search the contacts.
   * @return the contacts list of the companyDto passed in argument.
   */
  List<ContactDto> getMyContacts(CompanyDto companyDto);
}
