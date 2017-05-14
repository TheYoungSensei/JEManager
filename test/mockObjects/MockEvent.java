package mockObjects;

import java.time.LocalDateTime;
import java.util.Collection;

import biz.Event;
import biz.EventDto;
import util.SetValidator;

/**
 * This is the MockEvent class. See the MockUser class documentation for more info on how Mock
 * Objects are used.
 * 
 * @author Maniet.Alexandre
 */
public class MockEvent extends SetValidator implements Event {

  /**
   * Empty constructor.
   * 
   * @author alexandre.maniet
   */
  public MockEvent() {
    super();
  }

  /**
   * @param expectedMethodsCalls expected methods.
   * @author alexandre.maniet
   */
  public MockEvent(Collection<String> expectedMethodsCalls) {
    super(expectedMethodsCalls);
  }

  @Override
  public LocalDateTime getDate() {
    addCurrentMethodToSet();
    return LocalDateTime.now().plusHours(1);
  }

  @Override
  public int getEventId() {
    addCurrentMethodToSet();
    return 1;
  }

  @Override
  public String getId() {
    addCurrentMethodToSet();
    return null;
  }

  @Override
  public int getVersion() {
    addCurrentMethodToSet();
    return 1;
  }

  @Override
  public boolean isAfter(EventDto current) {
    addCurrentMethodToSet();
    return true;
  }

  @Override
  public boolean isClosed() {
    addCurrentMethodToSet();
    return false;
  }

  @Override
  public void setClosed(boolean closed) {
    addCurrentMethodToSet();
  }

  @Override
  public void setDate(LocalDateTime date) {
    addCurrentMethodToSet();
  }

  @Override
  public void setEventId(int userId) {
    addCurrentMethodToSet();
  }

  @Override
  public void setVersion(int version) {
    addCurrentMethodToSet();
  }

}
