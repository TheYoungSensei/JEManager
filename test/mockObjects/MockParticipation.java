package mockObjects;

import java.util.Collection;

import biz.Company;
import biz.Event;
import biz.Participation;
import exceptions.WrongStateException;
import util.SetValidator;

/**
 * This is the MockParticipation class. See the MockUser class documentation for more info on how
 * Mock Objects are used.
 * 
 * @author Maniet.Alexandre
 */
public class MockParticipation extends SetValidator implements Participation {

  private Company company = new MockCompany();
  private Event event = new MockEvent();

  /**
   * Empty constructor.
   * 
   * @author alexandre.maniet
   */
  public MockParticipation() {
    super();
  }

  /**
   * @param expectedMethodsCalls expected methods.
   * @author alexandre.maniet
   */
  public MockParticipation(Collection<String> expectedMethodsCalls) {
    super(expectedMethodsCalls);
  }

  @Override
  public void checkState() throws WrongStateException {
    addCurrentMethodToSet();
  }

  @Override
  public Company getCompany() {
    addCurrentMethodToSet();
    return company;
  }

  @Override
  public int getCompanyId() {
    addCurrentMethodToSet();
    return company.getCompanyId();
  }

  @Override
  public Event getEvent() {
    addCurrentMethodToSet();
    return event;
  }

  @Override
  public int getEventId() {
    addCurrentMethodToSet();
    return event.getEventId();
  }

  @Override
  public String getId() {
    addCurrentMethodToSet();
    return null;
  }

  @Override
  public int getParticipationId() {
    addCurrentMethodToSet();
    return 1;
  }

  @Override
  public String getState() {
    addCurrentMethodToSet();
    return "sampleState";
  }

  @Override
  public int getVersion() {
    addCurrentMethodToSet();
    return 0;
  }

  @Override
  public void setCompany(Company company) {
    addCurrentMethodToSet();
  }

  @Override
  public void setCompanyId(int companyId) {
    addCurrentMethodToSet();
  }

  @Override
  public void setEvent(Event event) {
    addCurrentMethodToSet();
  }

  @Override
  public void setEventId(int eventId) {
    addCurrentMethodToSet();
  }

  @Override
  public void setParticipationId(int participationId) {
    addCurrentMethodToSet();
  }

  @Override
  public void setState(String state) {
    addCurrentMethodToSet();
  }

  @Override
  public void setVersion(int version) {
    addCurrentMethodToSet();
  }
}
