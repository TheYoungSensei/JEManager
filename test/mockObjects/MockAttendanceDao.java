package mockObjects;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import biz.Attendance;
import biz.AttendanceDto;
import biz.Dto;
import biz.ParticipationDto;
import persistence.dao.AttendanceDao;
import util.SetValidator;

public class MockAttendanceDao extends SetValidator implements AttendanceDao {

  /**
   * Empty constructor.
   * 
   * @author alexandre.maniet
   */
  public MockAttendanceDao() {
    super();
  }

  /**
   * @param expectedMethodsCalls expected methods.
   * @author alexandre.maniet
   */
  public MockAttendanceDao(Collection<String> expectedMethodsCalls) {
    super(expectedMethodsCalls);
  }

  @Override
  public List<Integer> addAllForCompany(Attendance attendance, int idCompany) {
    addCurrentMethodToSet();
    return Arrays.asList(0);
  }

  @Override
  public int delete(Dto dto) {
    addCurrentMethodToSet();
    return 0;
  }

  @Override
  public List<AttendanceDto> findAttendanceContactByParticipation(ParticipationDto participation) {
    addCurrentMethodToSet();
    return Arrays.asList(new MockAttendance());
  }

  @Override
  public int insert(Dto dto) {
    addCurrentMethodToSet();
    return 0;
  }

  @Override
  public Attendance setAttendanceConfirmation(Attendance attendance) {
    addCurrentMethodToSet();
    return attendance;
  }

  @Override
  public int update(Dto dto) {
    addCurrentMethodToSet();
    return 0;
  }

}
