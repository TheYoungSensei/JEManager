package persistence.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import biz.Attendance;
import biz.AttendanceDto;
import biz.AttendanceFactory;
import biz.Contact;
import biz.ContactFactory;
import biz.Dto;
import biz.ParticipationDto;
import exceptions.FatalException;
import persistence.DalBackEndServices;

public class AttendanceDaoImpl implements AttendanceDao {

  private DalBackEndServices dalBackendService;
  private AttendanceFactory attendanceFactory;
  private ContactFactory contactFactory;

  /**
   * The constructor of this class.
   * 
   * @param dalServices the dalServices linking us to the DB
   * @param attendanceFactory the factory for attendances
   * @param contactFactory the factory for contacts
   */
  public AttendanceDaoImpl(DalBackEndServices dalServices, AttendanceFactory attendanceFactory,
      ContactFactory contactFactory) {
    this.dalBackendService = dalServices;
    this.attendanceFactory = attendanceFactory;
    this.contactFactory = contactFactory;
  }

  @Override
  public Attendance setAttendanceConfirmation(Attendance attendance) {
    attendance.setVersion(this.update(attendance));
    if (attendance.getVersion() == -1) {
      throw new IllegalArgumentException();
    }
    try (PreparedStatement prepare = dalBackendService.prepareStatement("query.cancelAttendance")) {
      prepare.setInt(1, attendance.getAttendanceId());
      prepare.setInt(2, attendance.getVersion());
      try (ResultSet result = prepare.executeQuery()) {
        while (result.next()) {
          attendance.setConfirmed(result.getBoolean(1));
          return attendance;
        }
      } catch (SQLException sqle) {
        throw new FatalException(sqle);
      }
    } catch (SQLException sqle2) {
      throw new FatalException(sqle2);
    }
    return null;
  }

  @Override
  public List<Integer> addAllForCompany(Attendance attendance, int idCompany) {
    List<Integer> toReturn = new ArrayList<>();
    try (PreparedStatement prepareContacts =
        dalBackendService.prepareStatement("query.getContactsPerCompany")) {
      prepareContacts.setInt(1, idCompany);
      try (ResultSet resultContacts = prepareContacts.executeQuery()) {
        while (resultContacts.next()) {
          try (PreparedStatement prepare =
              dalBackendService.prepareStatement("query.addAttendance")) {
            prepare.setInt(1, resultContacts.getInt(1));
            prepare.setInt(2, attendance.getParticipationId());
            try (ResultSet result = prepare.executeQuery()) {
              while (result.next()) {
                toReturn.add(result.getInt(1));
              }
            } catch (SQLException sqle) {
              throw new FatalException(sqle);
            }
          } catch (SQLException sqle2) {
            throw new FatalException(sqle2);
          }
        }
      } catch (SQLException sqle3) {
        throw new FatalException(sqle3);
      }
    } catch (SQLException sqle4) {
      throw new FatalException(sqle4);
    }
    return toReturn;
  }

  @Override
  public List<AttendanceDto> findAttendanceContactByParticipation(ParticipationDto participation) {
    List<AttendanceDto> attendanceList = new ArrayList<>();
    try (PreparedStatement prepare =
        dalBackendService.prepareStatement("query.getAttendanceByParticipationId")) {
      prepare.setInt(1, participation.getParticipationId());
      try (ResultSet result = prepare.executeQuery()) {
        while (result.next()) {
          Attendance attendance = (Attendance) attendanceFactory.getAttendance();
          attendance.setAttendanceId(result.getInt(1));
          Contact contact = (Contact) contactFactory.getContact();
          contact.setFirstName(result.getString(2));
          contact.setLastName(result.getString(3));
          contact.setEmail(result.getString(4));
          contact.setPhoneNumber(result.getString(5));
          attendance.setContact(contact);
          attendanceList.add(attendance);
        }
      } catch (SQLException sqle) {
        throw new FatalException(sqle);
      }
    } catch (SQLException sqle) {
      throw new FatalException(sqle);
    }
    return attendanceList;
  }

  @Override
  public int update(Dto dto) {
    Attendance attendance = (Attendance) dto;
    try (PreparedStatement prepare =
        dalBackendService.prepareStatement("query.getAttendanceVersion")) {
      prepare.setInt(1, attendance.getAttendanceId());
      try (ResultSet result = prepare.executeQuery()) {
        while (result.next()) {
          return result.getInt(1);
        }
      } catch (SQLException sqle) {
        throw new FatalException(sqle);
      }
    } catch (SQLException sqle) {
      throw new FatalException(sqle);
    }
    return -1;
  }

  @Override
  public int insert(Dto dto) {
    throw new UnsupportedOperationException();
  }

  @Override
  public int delete(Dto dto) {
    throw new UnsupportedOperationException();
  }
}
