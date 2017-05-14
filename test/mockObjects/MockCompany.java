package mockObjects;

import java.time.LocalDateTime;
import java.util.Collection;

import biz.Company;
import biz.User;
import util.SetValidator;

/**
 * This is the MockCompany class. See the MockUser class documentation for more info on how Mock
 * Objects are used.
 * 
 * @author Maniet.Alexandre
 */
public class MockCompany extends SetValidator implements Company {

  private MockUser creator = new MockUser();

  /**
   * Empty constructor.
   * 
   * @author alexandre.maniet
   */
  public MockCompany() {
    super();
  }

  /**
   * @param expectedMethodsCalls expected methods.
   * @author alexandre.maniet
   */
  public MockCompany(Collection<String> expectedMethodsCalls) {
    super(expectedMethodsCalls);
  }

  @Override
  public String getBox() {
    addCurrentMethodToSet();
    return "sampleBox";
  }

  @Override
  public int getCompanyId() {
    addCurrentMethodToSet();
    return 1;
  }

  @Override
  public User getCreator() {
    addCurrentMethodToSet();
    return creator;
  }

  @Override
  public int getCreatorId() {
    addCurrentMethodToSet();
    return creator.getUserId();
  }

  @Override
  public LocalDateTime getDateFirstContact() {
    addCurrentMethodToSet();
    return LocalDateTime.now().minusHours(1);
  }

  @Override
  public String getId() {
    addCurrentMethodToSet();
    return null;
  }

  @Override
  public String getMunicipality() {
    addCurrentMethodToSet();
    return "sampleMunicipality";
  }

  @Override
  public String getName() {
    addCurrentMethodToSet();
    return "sampleCompany";
  }

  @Override
  public int getNumber() {
    addCurrentMethodToSet();
    return 1;
  }

  @Override
  public int getPostalCode() {
    addCurrentMethodToSet();
    return 1;
  }

  @Override
  public String getStreet() {
    addCurrentMethodToSet();
    return "sampleStreet";
  }

  @Override
  public int getVersion() {
    addCurrentMethodToSet();
    return 1;
  }

  @Override
  public void setBox(String box) {
    addCurrentMethodToSet();
  }

  @Override
  public void setCompanyId(int companyId) {
    addCurrentMethodToSet();
  }

  @Override
  public void setCreator(User creator) {
    addCurrentMethodToSet();
  }

  @Override
  public void setCreatorId(int id) {
    addCurrentMethodToSet();
  }

  @Override
  public void setDateFirstContact(LocalDateTime dateFirstContact) {
    addCurrentMethodToSet();
  }

  @Override
  public void setMunicipality(String municipality) {
    addCurrentMethodToSet();
  }

  @Override
  public void setName(String name) {
    addCurrentMethodToSet();
  }

  @Override
  public void setNumber(int number) {
    addCurrentMethodToSet();
  }

  @Override
  public void setPostalCode(int postalCode) {
    addCurrentMethodToSet();
  }

  @Override
  public void setStreet(String street) {
    addCurrentMethodToSet();
  }

  @Override
  public void setVersion(int version) {
    addCurrentMethodToSet();
  }

}
