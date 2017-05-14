package mockObjects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import biz.Company;
import biz.Contact;
import biz.Dto;
import biz.Event;
import persistence.dao.EventDao;
import util.SetValidator;

public class MockEventDao extends SetValidator implements EventDao {

  /**
   * Empty constructor.
   * 
   * @author alexandre.maniet
   */
  public MockEventDao() {
    super();
  }

  /**
   * @param expectedMethodsCalls expected methods.
   * @author alexandre.maniet
   */
  public MockEventDao(Collection<String> expectedMethodsCalls) {
    super(expectedMethodsCalls);
  }

  @Override
  public int delete(Dto dto) {
    addCurrentMethodToSet();
    return 0;
  }

  @Override
  public Event findEventById(int idEvent) {
    addCurrentMethodToSet();
    return new MockEvent();
  }

  @Override
  public Event getCurrentEvent() {
    addCurrentMethodToSet();
    return new MockEvent();
  }

  @Override
  public HashMap<Company, ArrayList<Contact>> getMyParticipants(int eventId) {
    addCurrentMethodToSet();
    return new HashMap<Company, ArrayList<Contact>>();
  }

  @Override
  public HashMap<Company, ArrayList<Contact>> getParticipationDatas(int participationId) {
    addCurrentMethodToSet();
    return new HashMap<Company, ArrayList<Contact>>();
  }

  @Override
  public int insert(Dto dto) {
    addCurrentMethodToSet();
    return 0;
  }

  @Override
  public List<Event> selectAll() {
    addCurrentMethodToSet();
    return Arrays.asList(new MockEvent());
  }

  @Override
  public int update(Dto dto) {
    addCurrentMethodToSet();
    return 0;
  }

}
