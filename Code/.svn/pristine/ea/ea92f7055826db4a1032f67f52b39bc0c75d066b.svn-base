package tests;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import biz.EventDto;
import biz.ParticipationDto;
import exceptions.WrongStateException;
import mockObjects.MockDalServices;
import mockObjects.MockEvent;
import mockObjects.MockParticipation;
import mockObjects.MockParticipationDao;
import mockObjects.MockUnitOfWork;
import ucc.ParticipationUccImpl;
import util.Helper;

public class ParticipationUccImplTest {

  private MockDalServices mockDal, mockDal2;
  private MockUnitOfWork mockUnitOfWork1, mockUnitOfWork2, mockUnitOfWork3;
  private ParticipationUccImpl ucc1, ucc2, ucc3, ucc4, ucc5, ucc6;
  private MockParticipationDao mockParticipationDao1, mockParticipationDao2, mockParticipationDao3,
      mockParticipationDao4, mockParticipationDao5;
  private ParticipationDto mockParticipationDto;
  private EventDto mockEventDto;
  private Helper helper;

  /**
   * @throws Exception If one is thrown during initialisation.
   */
  @Before
  public void setUp() throws Exception {
    helper = new Helper();
    mockDal = new MockDalServices();
    // for test 1
    mockParticipationDto = new MockParticipation();
    mockParticipationDao1 = new MockParticipationDao();
    mockUnitOfWork1 = new MockUnitOfWork(Arrays.asList("addInsert"));
    ucc1 = new ParticipationUccImpl(mockParticipationDao1, mockUnitOfWork1, mockDal);
    // for test 2
    mockUnitOfWork2 = new MockUnitOfWork();
    mockParticipationDao2 = new MockParticipationDao(Arrays.asList("getCurrentParticipations"));
    ucc2 = new ParticipationUccImpl(mockParticipationDao2, mockUnitOfWork2, mockDal);
    // for test 3->8
    mockParticipationDao3 = new MockParticipationDao(Arrays.asList("countParticipations"));
    ucc3 = new ParticipationUccImpl(mockParticipationDao3, mockUnitOfWork2, mockDal);
    mockEventDto = new MockEvent();
    // for test 9
    mockParticipationDto = new MockParticipation();
    mockParticipationDao1 = new MockParticipationDao();
    mockUnitOfWork3 = new MockUnitOfWork(Arrays.asList("addUpdate"));
    ucc4 = new ParticipationUccImpl(mockParticipationDao1, mockUnitOfWork3, mockDal);
    // for test 10
    mockParticipationDao4 = new MockParticipationDao(Arrays.asList("getParticipationForState"));
    ucc5 = new ParticipationUccImpl(mockParticipationDao4, mockUnitOfWork2, mockDal);
    mockEventDto = new MockEvent();
    // for getAllParticipations test
    mockDal2 = new MockDalServices(Arrays.asList("startTransaction", "commit"));
    mockParticipationDao5 = new MockParticipationDao(Arrays.asList("getAllParticipations"));
    ucc6 = new ParticipationUccImpl(mockParticipationDao5, mockUnitOfWork2, mockDal2);

  }

  /**
   * Checking that addParticipation calls the addInsert method on the unit.
   */
  @Test
  public void testAddParticipation() {
    ucc1.addParticipation(mockParticipationDto);
    assertEquals("addInsert should have been called on the unit of work", true,
        mockUnitOfWork1.validate());
  }

  /**
   * Checking that getCurrentParticipations calls the getCurrentParticipations method on the dao.
   */
  @Test
  public void testGetCurrentParticipations() {
    ucc2.getCurrentParticipations();
    assertEquals("getCurrentParticipations should have been called on the dao", true,
        mockParticipationDao2.validate());
  }

  /**
   * Checking that countInvitedParticipation calls the countParticipations method on the dao.
   */
  @Test
  public void testCountInvitedParticipation() {
    ucc3.countInvitedParticipation(mockEventDto);
    assertEquals("countParticipations should have been called on the dao", true,
        mockParticipationDao3.validate());
  }

  /**
   * Checking that countConfirmedParticipation calls the countParticipations method on the dao.
   */
  @Test
  public void testCountConfirmedParticipation() {
    ucc3.countConfirmedParticipation(mockEventDto);
    assertEquals("countParticipations should have been called on the dao", true,
        mockParticipationDao3.validate());
  }

  /**
   * Checking that countRefusedParticipation calls the countParticipations method on the dao.
   */
  @Test
  public void testCountRefusedParticipation() {
    ucc3.countRefusedParticipation(mockEventDto);
    assertEquals("countParticipations should have been called on the dao", true,
        mockParticipationDao3.validate());
  }

  /**
   * Checking that countCancelledParticipation calls the countParticipations method on the dao.
   */
  @Test
  public void testCountCancelledParticipation() {
    ucc3.countCancelledParticipation(mockEventDto);
    assertEquals("countParticipations should have been called on the dao", true,
        mockParticipationDao3.validate());
  }

  /**
   * Checking that countInvoicedParticipation calls the countParticipations method on the dao.
   */
  @Test
  public void testCountInvoicedParticipation() {
    ucc3.countInvoicedParticipation(mockEventDto);
    assertEquals("countParticipations should have been called on the dao", true,
        mockParticipationDao3.validate());
  }

  /**
   * Checking that countPaidParticipation calls the countParticipations method on the dao.
   */
  @Test
  public void testCountPaidParticipation() {
    ucc3.countPaidParticipation(mockEventDto);
    assertEquals("countParticipations should have been called on the dao", true,
        mockParticipationDao3.validate());
  }

  /**
   * Checking that editStates calls the addUpdate method on the unit of work.
   * 
   * @throws WrongStateException if thrown by method under test
   */
  @Test
  public void testEditStates() throws WrongStateException {
    ucc4.editStates(Arrays.asList(mockParticipationDto));
    assertEquals("addUpdate should have been called on the unit of work", true,
        mockUnitOfWork3.validate());
  }

  /**
   * Checking that getAllPartcipationFor calls the getParticipationForState method on the dao.
   */
  @Test
  public void testGetAllPartcipationFor() {
    ucc5.getAllPartcipationFor(mockEventDto);
    assertEquals("getParticipationForState should have been called on the dao", true,
        mockParticipationDao4.validate());
  }

  /**
   * Checking that getInvitedParticipationsFor calls the getParticipationForState method on the dao.
   */
  @Test
  public void testGetInvitedParticipationsFor() {
    ucc5.getInvitedParticipationsFor(mockEventDto);
    assertEquals("getParticipationForState should have been called on the dao", true,
        mockParticipationDao4.validate());
  }

  /**
   * Checking that getConfirmedParticipationsFor calls the getParticipationForState method on the
   * dao.
   */
  @Test
  public void testGetConfirmedParticipationsFor() {
    ucc5.getConfirmedParticipationsFor(mockEventDto);
    assertEquals("getParticipationForState should have been called on the dao", true,
        mockParticipationDao4.validate());
  }

  /**
   * Checking that getRefusedParticipationsFor calls the getParticipationForState method on the dao.
   */
  @Test
  public void testGetRefusedParticipationsFor() {
    ucc5.getRefusedParticipationsFor(mockEventDto);
    assertEquals("getParticipationForState should have been called on the dao", true,
        mockParticipationDao4.validate());
  }

  /**
   * Checking that getCancelledParticipationsFor calls the getParticipationForState method on the
   * dao.
   */
  @Test
  public void testGetCancelledParticipationsFor() {
    ucc5.getCancelledParticipationsFor(mockEventDto);
    assertEquals("getParticipationForState should have been called on the dao", true,
        mockParticipationDao4.validate());
  }

  /**
   * Checking that getInvoicedParticipationsFor calls the getParticipationForState method on the
   * dao.
   */
  @Test
  public void testGetInvoicedParticipationsFor() {
    ucc5.getInvoicedParticipationsFor(mockEventDto);
    assertEquals("getParticipationForState should have been called on the dao", true,
        mockParticipationDao4.validate());
  }

  /**
   * Checking that getPaidParticipationsFor calls the getParticipationForState method on the dao.
   */
  @Test
  public void testGetPaidParticipationsFor() {
    ucc5.getPaidParticipationsFor(mockEventDto);
    assertEquals("getParticipationForState should have been called on the dao", true,
        mockParticipationDao4.validate());
  }

  /**
   * Checking that getAllParticipations calls the getAllParticipations method on the dao as well as
   * startTransaction+commit on the dal.
   */
  @Test
  public void testGetAllParticipations() {
    ucc6.getAllParticipations();
    assertEquals("getParticipationForState should have been called on the dao", true,
        mockParticipationDao5.validate());
    helper.testDal(mockDal2);
    helper.testParticipationDao(mockParticipationDao5);
  }

}
