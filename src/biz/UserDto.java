package biz;

import java.time.LocalDateTime;

/**
 * This is the User class's interface as seen from the servlet. The factory instantiates User
 * objects with this interface as type, then hands the object over to the servlet. A UCC may then
 * cast said object into a fully functionnal "User" interface type, granting him access to all
 * business-related methods.
 * 
 * @author Maniet
 */
public interface UserDto extends Dto {

  /**
   * @return The user's username as chosen during the registration.
   */
  String getUsername();

  /**
   * @return The user's first name (AKA "given name"). "Alexandre" is the first name in "Alexandre
   *         Maniet".
   */
  String getFirstName();

  /**
   * @return The user's last name (A.K.A. "family name" or "surname"). "Alexandre" is the last name
   *         in "Alexandre Maniet".
   */
  String getLastName();

  /**
   * @return The user's inherently unique email.
   */
  String getEmail();

  /**
   * @return The date and time at which the user was created.
   */
  LocalDateTime getRegistrationDate();

  /**
   * @return The user's encrypted password.
   */
  String getPassword();

  /**
   * @return Whether or not the user is a manager.
   */
  boolean isManager();

  /**
   * @return The user's id as assigned in the database during the insertion.
   */
  int getUserId();

  /**
   * @author Maniet.Alexandre
   * @param userId The integer to set the field userId to
   * @exception IllegalArgumentException thrown if the userId is a negative integer
   */
  void setUserId(int userId);

  /**
   * @author Maniet.Alexandre
   * @param username The string to set the user's username to
   * @exception IllegalArgumentException thrown if username is null or empty
   */
  void setUsername(String username);

  /**
   * @author Maniet.Alexandre
   * @param firstName The string to set the user's first name to
   * @exception IllegalArgumentException thrown if firstName is either null or empty
   */
  void setFirstName(String firstName);

  /**
   * @author Maniet.Alexandre
   * @param lastName The string to set the user's last name to
   * @exception IllegalArgumentException thrown if lastName is either null or empty
   */
  void setLastName(String lastName);

  /**
   * @author Maniet.Alexandre
   * @param email The string to set the user's email to
   * @exception IllegalArgumentException thrown if email is either null or empty
   */
  void setEmail(String email);

  /**
   * @author Maniet.Alexandre
   * @param registrationDate The date and time to set the user's registration date to
   * @exception IllegalArgumentException thrown if registrationDate is null or in the future
   */
  void setRegistrationDate(LocalDateTime registrationDate);

  /**
   * @author Maniet.Alexandre
   * @param password The string to set the user's password to
   * @exception IllegalArgumentException thrown if password is either null or empty
   */
  void setPassword(String password);

  /**
   * @author Maniet.Alexandre
   * @param manager The new boolean value to set the field manager to.
   */
  void setManager(boolean manager);
}
