package tests;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import biz.Company;
import biz.Event;
import biz.Participation;
import biz.objects.ParticipationImpl;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import mockObjects.MockCompany;
import mockObjects.MockEvent;

public class ParticipationImplTest {

  private Participation participation1;
  private Participation participation2;
  private Company mockCompany = new MockCompany();
  private Event mockEvent = new MockEvent();

  /**
   * @throws Exception if one is thrown during initialisation.
   */
  @Before
  public void setUp() throws Exception {
    participation1 = new ParticipationImpl();

    participation2 = new ParticipationImpl();
    participation2.setCompany(mockCompany);
    participation2.setCompanyId(1);
    participation2.setEvent(mockEvent);
    participation2.setEventId(1);
    participation2.setParticipationId(1);
    participation2.setState("sampleState");
  }

  /**
   * Testing all getters on a sample event.
   */
  @Test
  public void testGetters() {
    assertEquals("Company should be " + mockCompany, mockCompany, participation2.getCompany());
    assertEquals("Company id should be 1", 1, participation2.getCompanyId());
    assertEquals("Event should be " + mockEvent, mockEvent, participation2.getEvent());
    assertEquals("Event id should be 1", 1, participation2.getEventId());
    assertEquals("Participation id should be 1", 1, participation2.getParticipationId());
    assertEquals("State should be sampleState", "sampleState", participation2.getState());
  }


  /**
   * SetCompanyId with correct value.
   */
  @Test
  public void testSetCompanyId1() {
    participation1.setCompanyId(1);
    assertEquals("Company id should be 1", 1, participation1.getCompanyId());
  }

  /**
   * SetCompanyId with incorrect value (negative integer).
   */
  @Test(expected = IllegalArgumentException.class)
  public void testSetCompanyId2() {
    participation1.setCompanyId(-1);
  }


  /**
   * SetEventId with correct value.
   */
  @Test
  public void testSetEventId1() {
    participation1.setEventId(1);
    assertEquals("Event id should be 1", 1, participation1.getEventId());
  }

  /**
   * SetEventId with incorrect value (negative integer).
   */
  @Test(expected = IllegalArgumentException.class)
  public void testSetEventId2() {
    participation1.setEventId(-1);
  }


  /**
   * SetParticipationId with correct value.
   */
  @Test
  public void testSetParticipationId1() {
    participation1.setParticipationId(1);
    assertEquals("Participation id should be 1", 1, participation1.getParticipationId());
  }

  /**
   * SetParticipationId with incorrect value (negative integer).
   */
  @Test(expected = IllegalArgumentException.class)
  public void testSetParticipationId2() {
    participation1.setParticipationId(-1);
  }

  /**
   * SetEvent with correct value.
   */
  @Test
  public void testSetEvent1() {
    participation1.setEvent(mockEvent);
    assertEquals("Contact's Event should be " + mockEvent, mockEvent, participation1.getEvent());
  }

  /**
   * SetEvent with incorrect value (null).
   */
  @Test(expected = IllegalArgumentException.class)
  @SuppressFBWarnings("")
  public void testSetEvent2() {
    participation1.setEvent(null);
  }

  /**
   * SetCompany with correct value.
   */
  @Test
  public void testSetCompany1() {
    participation1.setCompany(mockCompany);
    assertEquals("Contact's Company should be " + mockCompany, mockCompany,
        participation1.getCompany());
  }

  /**
   * SetCompany with incorrect value (null).
   */
  @Test(expected = IllegalArgumentException.class)
  @SuppressFBWarnings("")
  public void testSetCompany2() {
    participation1.setCompany(null);
  }

  /**
   * SetState with correct value.
   */
  @Test
  public void testSetState1() {
    participation1.setState("invited");
    assertEquals("LastName should be invited", "invited", participation1.getState());
  }

  /**
   * SetState with incorrect value (null).
   */
  @Test(expected = IllegalArgumentException.class)
  @SuppressFBWarnings("")
  public void testSetState2() {
    participation1.setState(null);
  }

}
