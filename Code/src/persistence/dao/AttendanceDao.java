package persistence.dao;

import java.util.List;

import biz.Attendance;
import biz.AttendanceDto;
import biz.ParticipationDto;

public interface AttendanceDao extends Dao {

  /**
   * Confirm attendance in the database.
   * 
   * @param attendance the attendance which must be confirmed.
   * @return updated attendance, null otherwise.
   **/
  Attendance setAttendanceConfirmation(Attendance attendance);

  /**
   * Add an attendance in the database.
   * 
   * @param attendance the attendance to add.
   * @return The list of ids per attendance, empty if an error occurred.
   **/
  List<Integer> addAllForCompany(Attendance attendance, int idCompany);

  /**
   * Find the contacts who have a confirmed attendance for the parameter participation.
   * 
   * @author sam.ndagano
   * @param participation the participation we want the attendances for.
   * @return list of the contact with a confirmed attendance.
   */
  List<AttendanceDto> findAttendanceContactByParticipation(ParticipationDto participation);
}
