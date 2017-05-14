package tests;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import biz.CompanyDto;
import mockObjects.MockCompany;
import mockObjects.MockCompanyDao;
import mockObjects.MockDalServices;
import mockObjects.MockUnitOfWork;
import ucc.CompanyUccImpl;

public class CompanyUccImplTest {

  private MockDalServices mockDal;
  private MockUnitOfWork mockUnitOfWork1, mockUnitOfWork2;
  private CompanyUccImpl ucc1, ucc2, ucc3, ucc4, ucc5;
  private MockCompanyDao mockCompanyDao1, mockCompanyDao2, mockCompanyDao3, mockCompanyDao4,
      mockCompanyDao5;
  private CompanyDto mockCompanyDto;

  /**
   * @throws Exception If one is thrown during initialisation.
   */
  @Before
  public void setUp() throws Exception {
    mockDal = new MockDalServices();
    // for test 1
    mockUnitOfWork1 = new MockUnitOfWork();
    mockCompanyDao1 = new MockCompanyDao(Arrays.asList("selectAll"));
    ucc1 = new CompanyUccImpl(mockCompanyDao1, mockUnitOfWork1, mockDal);
    // for test 2
    mockCompanyDao2 = new MockCompanyDao(Arrays.asList("getCompanyById"));
    ucc2 = new CompanyUccImpl(mockCompanyDao2, mockUnitOfWork1, mockDal);
    // for test 3
    mockCompanyDao3 = new MockCompanyDao(Arrays.asList("getCompaniesToInvite"));
    ucc3 = new CompanyUccImpl(mockCompanyDao3, mockUnitOfWork1, mockDal);
    // for test 4
    mockCompanyDto = new MockCompany();
    mockCompanyDao4 = new MockCompanyDao();
    mockUnitOfWork2 = new MockUnitOfWork(Arrays.asList("addInsert"));
    ucc4 = new CompanyUccImpl(mockCompanyDao4, mockUnitOfWork2, mockDal);
    // for test 5
    mockCompanyDao5 = new MockCompanyDao(Arrays.asList("getMyContacts"));
    ucc5 = new CompanyUccImpl(mockCompanyDao5, mockUnitOfWork1, mockDal);
  }

  /**
   * Checking that getAllCompanies calls the selectAll method on the company dao.
   */
  @Test
  public void testGetAllCompanies() {
    ucc1.getAllCompanies();
    assertEquals("selectAll should have been called on the dao", true, mockCompanyDao1.validate());
  }

  /**
   * Checking that getCompanyById calls the getCompanyById method on the company dao.
   */
  @Test
  public void testGetCompanyById() {
    ucc2.getCompanyById(0);
    assertEquals("getCompanyById should have been called on the dao", true,
        mockCompanyDao2.validate());
  }

  /**
   * Checking that getCompaniesToInvite calls the getCompaniesToInvite method on the company dao
   * atleast once.
   */
  @Test
  public void testGetCompaniesToInvite() {
    ucc3.getCompaniesToInvite();
    assertEquals("getCompaniesToInvite should have been called on the dao atleast once", true,
        mockCompanyDao3.validate());
  }

  /**
   * Checking that addCompany calls the addInsert method on the unit.
   */
  @Test
  public void testAddCompany() {
    ucc4.addCompany(mockCompanyDto);
    assertEquals("addInsert should have been called on the unit of work", true,
        mockUnitOfWork2.validate());
  }

  /**
   * Checking that getMyContacts calls the getMyContacts method on the dao.
   */
  @Test
  public void testGetMyContacts() {
    ucc5.getMyContacts(mockCompanyDto);
    assertEquals("getMyContacts should have been called on the company dao", true,
        mockCompanyDao5.validate());
  }

}
