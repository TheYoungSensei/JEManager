package ucc;

import java.util.List;

import biz.AttendanceDto;
import biz.ParticipationDto;

public interface AttendanceUcc {

  /**
   * Confirmation function of attendance.
   * 
   * @param attendanceDto the attendance which must be confirmed.
   * @return updated attendance, null otherwise.
   */
  AttendanceDto cancelAttendance(AttendanceDto attendanceDto);

  /**
   * Add an attendance for every contact of the company known in the database.
   * 
   * @param attendanceDto the first attendance to add.
   * @param idCompany the id of the related company.
   * @return The list of ids per attendance, empty if an error occurred.
   **/
  List<Integer> addAllForCompany(AttendanceDto attendanceDto, int idCompany);

  /**
   * Update the confirmation status of the attendances in the parameter list.
   * 
   * @param attendanceDtos attendance which has to be updated.
   */
  void editConfirmation(List<AttendanceDto> attendanceDtos);

  /**
   * Finds all the attendance related to the specific participation.
   * 
   * @param participation.
   * @return a List with the result of the query findAttendanceContactByParticipation.
   */
  List<AttendanceDto> getAllAttendance(ParticipationDto participation);
}
