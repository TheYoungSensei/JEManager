package biz;

import exceptions.InvalidInformationException;

/**
 * This is the User class's interface as seen from a UCC. Once a UCC has been given a DTO, he may
 * cast said object into this type in order to access all business-related methods in addition to
 * the DTO's accessors.
 * 
 * @author Maniet.Alexandre
 */
public interface User extends UserDto, OptimisticLock {

  /**
   * Encryption password procedure.
   */
  void encryptPassword();

  /**
   * Checks that the password in plainText is equal to the one in the database (after encryption).
   * 
   * @param plainText the password in plain text.
   * @return true if the password is equal, false otherwise.
   */
  boolean checkPassword(String plainText); // User has the encrypted password as an attribute

  /**
   * Checks that the registrationDate, email, firstName, lastName, email+phoneNumber are not null or
   * 0/"". Checks that the registrationDate is in the future. Checks that the email matches
   * "".+@.+\\.[a-z]+"" if he isn't empty. Checks that the password contains more than 6 characters,
   * with numbers, upper and lower cases.
   * 
   * @throws InvalidInformationException if the information aren't valid.
   */
  void checkNewUserInformation() throws InvalidInformationException;
}
