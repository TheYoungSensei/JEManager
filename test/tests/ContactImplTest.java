package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import biz.Company;
import biz.Contact;
import biz.objects.ContactImpl;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import exceptions.InvalidInformationException;
import mockObjects.MockCompany;

public class ContactImplTest {

  private Contact contact1;
  private Contact contact2;
  private Company mockCompany = new MockCompany();

  /**
   * @throws Exception if one is thrown during initialisation.
   */
  @Before
  public void setUp() throws Exception {
    contact1 = new ContactImpl();
    contact2 = new ContactImpl();
    contact2.setActive(true);
    contact2.setCompany(mockCompany);
    contact2.setCompanyId(1);
    contact2.setContactId(1);
    contact2.setEmail("sampleEmail@service.domain");
    contact2.setFirstName("sampleFirstName");
    contact2.setLastName("sampleLastName");
    contact2.setPhoneNumber("0000000000");
  }

  /**
   * Testing all getters on a sample contact.
   */
  @Test
  public void testGetters() {
    assertEquals("Contact should be active", true, contact2.isActive());
    assertEquals("Company should be " + mockCompany, mockCompany, contact2.getCompany());
    assertEquals("Company id should be 1", 1, contact2.getCompanyId());
    assertEquals("Contact id should be 1", 1, contact2.getContactId());
    assertEquals("Email should be sampleEmail@service.domain", "sampleEmail@service.domain",
        contact2.getEmail());
    assertEquals("First name should be sampleFirstName", "sampleFirstName",
        contact2.getFirstName());
    assertEquals("Last name should be sampleLastName", "sampleLastName", contact2.getLastName());
    assertEquals("Phone number should be 0000000000", "0000000000", contact2.getPhoneNumber());
  }

  /**
   * SetActive with correct value.
   */
  @Test
  public void testSetActive() {
    contact1.setActive(true);
    assertEquals("Contact should be Active", true, contact1.isActive());
  }

  /**
   * SetCompany with correct value.
   */
  @Test
  public void testSetCompany1() {
    contact1.setCompany(mockCompany);
    assertEquals("Contact's Company should be " + mockCompany, mockCompany, contact1.getCompany());
  }

  /**
   * SetCompany with incorrect value (null).
   */
  @Test(expected = IllegalArgumentException.class)
  @SuppressFBWarnings("")
  public void testSetCompany2() {
    contact1.setCompany(null);
  }

  /**
   * SetCompanyId with correct value.
   */
  @Test
  public void testSetCompanyId1() {
    contact1.setCompanyId(1);
    assertEquals("Company id should be 1", 1, contact1.getCompanyId());
  }

  /**
   * SetCompanyId with incorrect value (negative integer).
   */
  @Test(expected = IllegalArgumentException.class)
  public void testSetCompanyId2() {
    contact1.setCompanyId(-1);
  }


  /**
   * SetEmail with correct value.
   */
  @Test
  public void testSetEmail1() {
    contact1.setEmail("sampleEmail@service.domain");
    assertEquals("Email should be sampleEmail@service.domain", "sampleEmail@service.domain",
        contact1.getEmail());
  }

  /**
   * SetFirstName with correct value.
   */
  @Test
  public void testSetFirstName1() {
    contact1.setFirstName("sampleFirstName");
    assertEquals("FirstName should be sampleFirstName", "sampleFirstName", contact1.getFirstName());
  }

  /**
   * SetFirstName with incorrect value (null).
   */
  @Test(expected = IllegalArgumentException.class)
  @SuppressFBWarnings("")
  public void testSetFirstName2() {
    contact1.setFirstName(null);
  }

  /**
   * SetFirstName with incorrect value (empty).
   */
  @Test(expected = IllegalArgumentException.class)
  public void testSetFirstName3() {
    contact1.setFirstName("");
  }


  /**
   * SetLastName with correct value.
   */
  @Test
  public void testSetLastName1() {
    contact1.setLastName("sampleLastName");
    assertEquals("LastName should be sampleLastName", "sampleLastName", contact1.getLastName());
  }

  /**
   * SetLastName with incorrect value (null).
   */
  @Test(expected = IllegalArgumentException.class)
  @SuppressFBWarnings("")
  public void testSetLastName2() {
    contact1.setLastName(null);
  }

  /**
   * SetLastName with incorrect value (empty).
   */
  @Test(expected = IllegalArgumentException.class)
  public void testSetLastName3() {
    contact1.setLastName("");
  }


  /**
   * SetPhoneNumber with correct value.
   */
  @Test
  public void testSetPhoneNumber1() {
    contact1.setPhoneNumber("0000000000");
    assertEquals("PhoneNumber should be 0000000000", "0000000000", contact1.getPhoneNumber());
  }

  /**
   * CheckNewContactInformation.
   * 
   * @throws InvalidInformationException
   */
  @Test(expected = InvalidInformationException.class)
  public void testCheckNewContactInformation1() throws InvalidInformationException {
    contact1.setCompanyId(0);
    contact1.checkNewContactInformation();
  }

  /**
   * CheckNewContactInformation.
   * 
   * @throws InvalidInformationException
   */
  @Test(expected = InvalidInformationException.class)
  public void testCheckNewContactInformation2() throws InvalidInformationException {
    contact1.setEmail("blabla");
    contact1.checkNewContactInformation();
  }

  /**
   * CheckNewContactInformation.
   * 
   * @throws InvalidInformationException
   */
  @Test(expected = InvalidInformationException.class)
  public void testCheckNewContactInformation3() throws InvalidInformationException {
    contact1.setPhoneNumber("1234567991234567");
    contact1.checkNewContactInformation();
  }

  /**
   * CheckNewContactInformation.
   * 
   * @throws InvalidInformationException
   */
  @Test(expected = InvalidInformationException.class)
  public void testCheckNewContactInformation4() throws InvalidInformationException {
    contact1.checkNewContactInformation();
  }

  /**
   * CheckNewContactInformation.
   * 
   * @throws InvalidInformationException
   */
  @Test(expected = InvalidInformationException.class)
  public void testCheckNewContactInformation5() throws InvalidInformationException {
    contact1.checkNewContactInformation();
  }

  /**
   * CheckNewContactInformation.
   * 
   * @throws InvalidInformationException
   */
  @Test(expected = InvalidInformationException.class)
  public void testCheckNewContactInformation6() throws InvalidInformationException {
    contact1.checkNewContactInformation();
  }

  /**
   * CheckNewContactInformation.
   * 
   * @throws InvalidInformationException
   */
  @Test(expected = InvalidInformationException.class)
  public void testCheckNewContactInformation7() throws InvalidInformationException {
    contact1.checkNewContactInformation();
  }

  /**
   * CheckNewContactInformation.
   * 
   * @throws InvalidInformationException
   */
  @Test(expected = InvalidInformationException.class)
  public void testCheckNewContactInformation9() throws InvalidInformationException {
    contact1.checkNewContactInformation();
  }


  /**
   * CheckModifyContactInformation.
   * 
   * @throws InvalidInformationException
   */
  @Test(expected = InvalidInformationException.class)
  public void testCheckModifyContactInformation1() throws InvalidInformationException {
    contact1.setCompanyId(0);
    contact1.checkModifyContactInformation();
  }

  /**
   * CheckModifyContactInformation.
   * 
   * @throws InvalidInformationException
   */
  @Test(expected = InvalidInformationException.class)
  public void testCheckModifyContactInformation2() throws InvalidInformationException {
    contact1.setEmail("blabla");
    contact1.checkModifyContactInformation();
  }

  /**
   * CheckModifyContactInformation.
   * 
   * @throws InvalidInformationException
   */
  @Test(expected = InvalidInformationException.class)
  public void testCheckModifyContactInformation3() throws InvalidInformationException {
    contact1.setPhoneNumber("1234567991234567");
    contact1.checkModifyContactInformation();
  }

  /**
   * CheckModifyContactInformation.
   * 
   * @throws InvalidInformationException
   */
  @Test(expected = InvalidInformationException.class)
  public void testCheckModifyContactInformation4() throws InvalidInformationException {
    contact1.checkModifyContactInformation();
  }

  /**
   * CheckModifyContactInformation.
   * 
   * @throws InvalidInformationException
   */
  @Test(expected = InvalidInformationException.class)
  public void testCheckModifyContactInformation5() throws InvalidInformationException {
    contact1.checkModifyContactInformation();
  }

  /**
   * CheckModifyContactInformation.
   * 
   * @throws InvalidInformationException
   */
  @Test(expected = InvalidInformationException.class)
  public void testCheckModifyContactInformation6() throws InvalidInformationException {
    contact1.checkModifyContactInformation();
  }

  /**
   * CheckModifyContactInformation.
   * 
   * @throws InvalidInformationException
   */
  @Test(expected = InvalidInformationException.class)
  public void testCheckModifyContactInformation7() throws InvalidInformationException {
    contact1.setPhoneNumber(null);
    contact1.checkModifyContactInformation();
  }

}
