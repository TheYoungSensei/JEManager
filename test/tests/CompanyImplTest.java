package tests;
import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;

import org.junit.Before;
import org.junit.Test;

import biz.Company;
import biz.User;
import biz.objects.CompanyImpl;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import mockObjects.MockUser;

public class CompanyImplTest {

  private Company company1;
  private Company company2;
  private User mockUser = new MockUser();
  private LocalDateTime sampleDateInThePast = LocalDateTime.now().minusHours(1);

  /**
   * @throws Exception if one is thrown during initialisation.
   */
  @Before
  public void setUp() throws Exception {
    company1 = new CompanyImpl();

    company2 = new CompanyImpl();
    company2.setBox("sampleBox");
    company2.setCompanyId(1);
    company2.setCreator(mockUser);
    company2.setCreatorId(1);
    company2.setDateFirstContact(sampleDateInThePast);
    company2.setMunicipality("sampleMunicipality");
    company2.setName("sampleName");
    company2.setNumber(1);
    company2.setPostalCode(1);
    company2.setStreet("sampleStreet");
  }

  /**
   * Testing all getters on a sample company.
   */
  @Test
  public void testGetters() {
    assertEquals("Box should be ", "sampleBox", company2.getBox());
    assertEquals("Company id should be 1", 1, company2.getCompanyId());
    assertEquals("Creator should be " + mockUser, mockUser, company2.getCreator());
    assertEquals("Creator id should be 1", 1, company2.getCreatorId());
    assertEquals("Date of first contact should be " + sampleDateInThePast, sampleDateInThePast,
        company2.getDateFirstContact());
    assertEquals("Municipality should be sampleMunicipality", "sampleMunicipality",
        company2.getMunicipality());
    assertEquals("Name should be sampleName", "sampleName", company2.getName());
    assertEquals("Number should be 1", 1, company2.getNumber());
    assertEquals("Postal code should be 1", 1, company2.getPostalCode());
    assertEquals("Street should be sampleStreet", "sampleStreet", company2.getStreet());
  }

  /**
   * SetBox with correct value.
   */
  @Test
  public void testSetBox1() {
    company1.setBox("sampleBox");
    assertEquals("Box should be ", "sampleBox", company1.getBox());
  }

  /**
   * SetBox with incorrect value (null).
   */
  @Test(expected = IllegalArgumentException.class)
  @SuppressFBWarnings("")
  public void testSetBox2() {
    company1.setBox(null);
  }

  /**
   * SetCompanyId with correct value.
   */
  @Test
  public void testSetCompanyId1() {
    company1.setCompanyId(1);
    assertEquals("Company id should be 1", 1, company1.getCompanyId());
  }

  /**
   * SetCompanyId with incorrect value (negative int).
   */
  @Test(expected = IllegalArgumentException.class)
  public void testSetCompanyId2() {
    company1.setCompanyId(-1);
  }

  /**
   * SetCreator with correct value.
   */
  @Test
  public void testSetCreator1() {
    company1.setCreator(mockUser);
    assertEquals("Creator should be " + mockUser, mockUser, company1.getCreator());
  }

  /**
   * SetCreator with incorrect value (null).
   */
  @Test(expected = IllegalArgumentException.class)
  @SuppressFBWarnings("")
  public void testSetCreator2() {
    company1.setCreator(null);
  }

  /**
   * SetCreatorId with correct value.
   */
  @Test
  public void testSetCreatorId1() {
    company1.setCreatorId(1);
    assertEquals("Creator id should be 1", 1, company1.getCreatorId());
  }

  /**
   * SetCreatorId with incorrect value (negative int).
   */
  @Test(expected = IllegalArgumentException.class)
  public void testSetCreatorId2() {
    company1.setCreatorId(-1);
  }

  /**
   * SetDateFirstContact with correct value.
   */
  @Test
  public void testSetDateFirstContact1() {
    company1.setDateFirstContact(sampleDateInThePast);
    assertEquals("Date of first contact should be " + sampleDateInThePast, sampleDateInThePast,
        company1.getDateFirstContact());
  }

  /**
   * SetDateFirstContact with incorrect value (null).
   */
  @Test(expected = IllegalArgumentException.class)
  @SuppressFBWarnings("")
  public void testSetDateFirstContact2() {
    company1.setDateFirstContact(null);
  }

  /**
   * SetDateFirstContact with incorrect value (in the future).
   */
  @Test(expected = IllegalArgumentException.class)
  public void testSetDateFirstContact3() {
    company1.setDateFirstContact(LocalDateTime.now().plusHours(1));
  }

  /**
   * SetDateFirstContact with incorrect value (before year 1000).
   */
  @Test(expected = IllegalArgumentException.class)
  public void testSetDateFirstContact4() {
    company1.setDateFirstContact(LocalDateTime.of(990, 1, 1, 1, 1));
  }

  /**
   * SetMunicipality with correct value.
   */
  @Test
  public void testSetMunicipality1() {
    company1.setMunicipality("sampleMunicipality");
    assertEquals("Municipality should be sampleMunicipality", "sampleMunicipality",
        company1.getMunicipality());
  }

  /**
   * SetMunicipality with incorrect value (null).
   */
  @Test(expected = IllegalArgumentException.class)
  @SuppressFBWarnings("")
  public void testSetMunicipality2() {
    company1.setMunicipality(null);
  }

  /**
   * SetMunicipality with incorrect value (empty).
   */
  @Test(expected = IllegalArgumentException.class)
  public void testSetMunicipality3() {
    company1.setMunicipality("");
  }

  /**
   * SetName with correct value.
   */
  @Test
  public void testSetName1() {
    company1.setName("sampleName");
    assertEquals("Name should be sampleName", "sampleName", company1.getName());
  }

  /**
   * SetName with incorrect value (null).
   */
  @Test(expected = IllegalArgumentException.class)
  @SuppressFBWarnings("")
  public void testSetName2() {
    company1.setName(null);
  }

  /**
   * SetName with incorrect value (empty).
   */
  @Test(expected = IllegalArgumentException.class)
  public void testSetName3() {
    company1.setName("");
  }

  /**
   * SetNumber with correct value.
   */
  @Test
  public void testSetNumber1() {
    company1.setNumber(1);
    assertEquals("Number should be 1", 1, company1.getNumber());
  }

  /**
   * SetNumber with incorrect value (negative integer).
   */
  @Test(expected = IllegalArgumentException.class)
  public void testSetNumber2() {
    company1.setNumber(-1);
  }

  /**
   * SetPostalCode with correct value.
   */
  @Test
  public void testSetPostalCode1() {
    company1.setPostalCode(1);
    assertEquals("PostalCode should be 1", 1, company1.getPostalCode());
  }

  /**
   * SetPostalCode with incorrect value (negative integer).
   */
  @Test(expected = IllegalArgumentException.class)
  public void testSetPostalCode2() {
    company1.setPostalCode(-1);
  }

  /**
   * SetStreet with correct value.
   */
  @Test
  public void testSetStreet1() {
    company1.setStreet("sampleStreet");
    assertEquals("Street should be sampleStreet", "sampleStreet", company1.getStreet());
  }

  /**
   * SetStreet with incorrect value (null).
   */
  @Test(expected = IllegalArgumentException.class)
  @SuppressFBWarnings("")
  public void testSetStreet2() {
    company1.setStreet(null);
  }

  /**
   * SetStreet with incorrect value (empty).
   */
  @Test(expected = IllegalArgumentException.class)
  public void testSetStreet3() {
    company1.setStreet("");
  }

}
