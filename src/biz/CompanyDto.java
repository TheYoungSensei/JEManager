package biz;

import java.time.LocalDateTime;

/**
 * This is the Company class's interface as seen from the servlet. The factory instanciates Company
 * objects with this interface as type, then hands the object over to the servlet. A UCC may then
 * cast said object into a fully functionnal "Company" interface type, granting him access to all
 * business-related methods.
 * 
 * @author Antoine.Maniet
 */
public interface CompanyDto extends Dto {

  /**
   * @return The company's id as assigned in the database during the insertion.
   */
  int getCompanyId();

  /**
   * Retrives the User from the DB with the ID contained in the Creator field of the company.
   * 
   * @return The company's Creator as assigned in the database during the insertion.
   */
  User getCreator();

  /**
   * @author Maniet.alexandre
   * @return The company's creator's id.
   */
  int getCreatorId();

  /**
   * @return The company's name as assigned in the database during the insertion.
   */
  String getName();

  /**
   * @return The company's date of first contact as assigned in the database during the insertion.
   */
  LocalDateTime getDateFirstContact();

  /**
   * @return The company's street as assigned in the database during the insertion.
   */
  String getStreet();

  /**
   * @return The company's street number as assigned in the database during the insertion.
   */
  int getNumber();

  /**
   * @return The company's box as assigned in the database during the insertion. Null if box isn't
   *         set.
   */
  String getBox();

  /**
   * @return The company's postal code as assigned in the database during the insertion.
   */
  int getPostalCode();

  /**
   * @return The company's municipality as assigned in the database during the insertion.
   */
  String getMunicipality();

  /**
   * @author Antoine.Maniet
   * @param companyId The int to set the field CompanyId to
   * @exception IllegalArgumentException thrown if the companyId is a negative int
   */
  void setCompanyId(int companyId);

  /**
   * @author Maniet.Alexandre
   * @param id The creator's id
   * @exception IllegalArgumentException thrown if the id is negative
   */
  void setCreatorId(int id);

  /**
   * @author Antoine.Maniet
   * @param creator The user to set the field Creator to
   * @exception IllegalArgumentException thrown if the creator is null
   */
  void setCreator(User creator);

  /**
   * @author Antoine.Maniet
   * @param name The string to set the field Name to
   * @exception IllegalArgumentException thrown if the name is null or empty
   */
  void setName(String name);

  /**
   * @author Antoine.Maniet
   * @param dateFirstContact The localDateTime to set the field DateFirstContact to
   * @exception IllegalArgumentException thrown if the dateFirstContact is null, in the futur or
   *            before 1000.
   */
  void setDateFirstContact(LocalDateTime dateFirstContact);

  /**
   * @author Antoine.Maniet
   * @param street The string to set the field Street to
   * @exception IllegalArgumentException thrown if the street is null or empty
   */
  void setStreet(String street);

  /**
   * @author Antoine.Maniet
   * @param number The int to set the field Number to
   * @exception IllegalArgumentException thrown if the number is ≤ 0
   */
  void setNumber(int number);

  /**
   * @author Antoine.Maniet
   * @param box The string to set the field Box to
   * @exception IllegalArgumentException thrown if the box isn't a String
   */
  void setBox(String box);

  /**
   * @author Antoine.Maniet
   * @param postalCode The int to set the field PostalCode to
   * @exception IllegalArgumentException thrown if the postalCode is ≤ 0
   */
  void setPostalCode(int postalCode);

  /**
   * @author Antoine.Maniet
   * @param municipality The string to set the field Municipality to
   * @exception IllegalArgumentException thrown if the municipality is null or empty
   */
  void setMunicipality(String municipality);
}
