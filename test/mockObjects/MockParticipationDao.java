package mockObjects;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import biz.Dto;
import biz.Event;
import biz.Participation;
import persistence.dao.ParticipationDao;
import util.SetValidator;

public class MockParticipationDao extends SetValidator implements ParticipationDao {

  /**
   * Empty constructor.
   * 
   * @author alexandre.maniet
   */
  public MockParticipationDao() {
    super();
  }

  /**
   * @param expectedMethodsCalls expected methods.
   * @author alexandre.maniet
   */
  public MockParticipationDao(Collection<String> expectedMethodsCalls) {
    super(expectedMethodsCalls);
  }

  @Override
  public int countParticipations(Event event, String type) {
    addCurrentMethodToSet();
    return 0;
  }

  @Override
  public int delete(Dto dto) {
    addCurrentMethodToSet();
    return 0;
  }

  @Override
  public List<Participation> getCurrentParticipations() {
    addCurrentMethodToSet();
    return Arrays.asList(new MockParticipation());
  }

  @Override
  public List<Participation> getParticipationForState(Event event, String type) {
    addCurrentMethodToSet();
    return Arrays.asList(new MockParticipation());
  }

  @Override
  public int insert(Dto dto) {
    addCurrentMethodToSet();
    return 0;
  }

  @Override
  public int update(Dto dto) {
    addCurrentMethodToSet();
    return 0;
  }

  @Override
  public List<Participation> getAllParticipations() {
    addCurrentMethodToSet();
    return Arrays.asList(new MockParticipation());
  }

}
