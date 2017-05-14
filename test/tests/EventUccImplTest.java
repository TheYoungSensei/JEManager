package tests;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import biz.EventDto;
import mockObjects.MockDalServices;
import mockObjects.MockEvent;
import mockObjects.MockEventDao;
import mockObjects.MockUnitOfWork;
import ucc.EventUccImpl;

public class EventUccImplTest {

  private MockDalServices mockDal;
  private MockUnitOfWork mockUnifOfWork1, mockUnifOfWork2;
  private EventUccImpl ucc1, ucc2, ucc3, ucc4, ucc5, ucc6;
  private MockEventDao mockEventDao1, mockEventDao2, mockEventDao3, mockEventDao4, mockEventDao5;
  private EventDto mockEventDto;

  /**
   * @throws Exception If one is thrown during initialisation.
   */
  @Before
  public void setUp() throws Exception {
    // for test 1
    mockUnifOfWork1 = new MockUnitOfWork();
    mockEventDto = new MockEvent();
    mockDal = new MockDalServices();
    mockEventDao1 = new MockEventDao(Arrays.asList("getMyParticipants"));
    ucc1 = new EventUccImpl(mockEventDao1, mockUnifOfWork1, mockDal);
    // for test 2
    mockEventDao2 = new MockEventDao(Arrays.asList("getCurrentEvent"));
    ucc2 = new EventUccImpl(mockEventDao2, mockUnifOfWork1, mockDal);
    // for test 3
    mockEventDao3 = new MockEventDao(Arrays.asList("selectAll"));
    ucc3 = new EventUccImpl(mockEventDao3, mockUnifOfWork1, mockDal);
    // for test 4
    mockUnifOfWork2 = new MockUnitOfWork(Arrays.asList("addInsert"));
    ucc4 = new EventUccImpl(mockEventDao1, mockUnifOfWork2, mockDal);
    // for test 5
    mockEventDao4 = new MockEventDao(Arrays.asList("getParticipationDatas"));
    ucc5 = new EventUccImpl(mockEventDao4, mockUnifOfWork1, mockDal);
    // for test 6
    mockEventDao5 = new MockEventDao(Arrays.asList("findEventById"));
    ucc6 = new EventUccImpl(mockEventDao5, mockUnifOfWork1, mockDal);
  }

  /**
   * Checks that getMyParticipants is called on the event dao.
   */
  @Test
  public void testGenerateFullCsv() {
    ucc1.generateFullCsv(mockEventDto);
    assertEquals("getMyParticipants should have been called on the dao", true,
        mockEventDao1.validate());
  }

  /**
   * Checks that getCurrentEvent is called on the event dao.
   */
  @Test
  public void testGetCurrentEvent() {
    ucc2.getCurrentEvent();
    assertEquals("getCurrentEvent should have been called on the dao", true,
        mockEventDao2.validate());
  }

  /**
   * Checks that selectAll is called on the event dao.
   */
  @Test
  public void testGetAllEvents() {
    ucc3.getAllEvents();
    assertEquals("selectAll should have been called on the dao", true, mockEventDao3.validate());
  }

  /**
   * Checks that addInsert is called on the unit of work.
   */
  @Test
  public void testAddNewEvent() {
    ucc4.addNewEvent(mockEventDto);
    assertEquals("addInsert should have been called on the unit of work", true,
        mockUnifOfWork2.validate());
  }

  /**
   * Checks that getParticipationDatas is called on the dao.
   */
  @Test
  public void testGenerateCsvRows() {
    ucc5.generateCsvRows(0);
    assertEquals("getParticipationDatas should have been called on the dao", true,
        mockEventDao4.validate());
  }

  /**
   * Checks that findEventById is called on the dao.
   */
  @Test
  public void testGetEventById() {
    ucc6.getEventById(0);
    assertEquals("findEventById should have been called on the dao", true,
        mockEventDao5.validate());
  }


}
