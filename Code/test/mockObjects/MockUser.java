package mockObjects;

import java.time.LocalDateTime;
import java.util.Collection;

import biz.User;
import exceptions.InvalidInformationException;
import util.SetValidator;

/**
 * This is the Mock user class. The point of a Mock object is only to help during tests. They act as
 * a way to narrow the lines of code read during a test. In a debug scenario, the line
 * "realObject.businessMethod()" may call a large number of methods, possibly even accessing the
 * persistence layer, which makes finding the source of an error incredibly hard. The line
 * "mockObject.businessMethod()" would have a behavior as small as possible, having little to no
 * code dependencies. Most of the methods below return either a sample value or have no behavior at
 * all. No attributes are present either as they would serve no use in a mock environment (all
 * setters have an empty behavior).
 * 
 * @author Maniet.Alexandre
 */
public class MockUser extends SetValidator implements User {

  /**
   * This constructor creates a MockUser instance which may then be used for testing purposes.
   * 
   * @author Maniet.Alexandre
   */
  public MockUser() {
    super();
  }

  /**
   * @param expectedMethodsCalls expected methods.
   * @author Maniet.Alexandre
   */
  public MockUser(Collection<String> expectedMethodsCalls) {
    super(expectedMethodsCalls);
  }

  @Override
  public void checkNewUserInformation() throws InvalidInformationException {
    addCurrentMethodToSet();
  }

  public boolean checkPassword(String plainText) {
    addCurrentMethodToSet();
    return true;
  }

  @Override
  public void encryptPassword() {
    addCurrentMethodToSet();
  }

  public String getEmail() {
    addCurrentMethodToSet();
    return "john@doe";
  }

  public String getFirstName() {
    addCurrentMethodToSet();
    return "john";
  }

  @Override
  public String getId() {
    addCurrentMethodToSet();
    return null;
  }

  public String getLastName() {
    addCurrentMethodToSet();
    return "doe";
  }

  public String getPassword() {
    addCurrentMethodToSet();
    return "johnpass";
  }

  public LocalDateTime getRegistrationDate() {
    addCurrentMethodToSet();
    return LocalDateTime.now();
  }

  public int getUserId() {
    addCurrentMethodToSet();
    return 1;
  }

  public String getUsername() {
    addCurrentMethodToSet();
    return "john.doe";
  }

  @Override
  public int getVersion() {
    addCurrentMethodToSet();
    return 1;
  }

  public boolean isManager() {
    addCurrentMethodToSet();
    return true;
  }

  public void setEmail(String email) {
    addCurrentMethodToSet();
  }

  public void setFirstName(String firstName) {
    addCurrentMethodToSet();
  }

  public void setLastName(String lastName) {
    addCurrentMethodToSet();
  }

  public void setManager(boolean manager) {
    addCurrentMethodToSet();
  }

  public void setPassword(String password) {
    addCurrentMethodToSet();
  }

  public void setRegistrationDate(LocalDateTime registrationDate) {
    addCurrentMethodToSet();
  }

  public void setResponsable(boolean manager) {
    addCurrentMethodToSet();
  }

  public void setUserId(int userId) {
    addCurrentMethodToSet();
  }

  public void setUsername(String username) {
    addCurrentMethodToSet();
  }

  @Override
  public void setVersion(int version) {
    addCurrentMethodToSet();
  }

  public String toString() {
    addCurrentMethodToSet();
    return "toString";
  }

}
