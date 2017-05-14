package tests;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import biz.AttendanceDto;
import biz.ParticipationDto;
import mockObjects.MockAttendance;
import mockObjects.MockAttendanceDao;
import mockObjects.MockDalServices;
import mockObjects.MockParticipation;
import mockObjects.MockUnitOfWork;
import persistence.UnitOfWork;
import ucc.AttendanceUccImpl;

public class AttendanceUccImplTest {

  private MockDalServices dal;
  private AttendanceUccImpl ucc1, ucc2, ucc3;
  private MockAttendanceDao mockAttendanceDao1, mockAttendanceDao2, mockAttendanceDao3;
  private UnitOfWork mockUnitOfWork;
  private AttendanceDto mockAttendanceDto;
  private ParticipationDto mockParticipationDto;

  /**
   * @throws Exception If one is thrown during initialisation.
   */
  @Before
  public void setUp() throws Exception {
    dal = new MockDalServices();
    mockUnitOfWork = new MockUnitOfWork();
    mockParticipationDto = new MockParticipation();
    mockAttendanceDto = new MockAttendance();
    mockAttendanceDao1 = new MockAttendanceDao(Arrays.asList("setAttendanceConfirmation"));
    mockAttendanceDao2 = new MockAttendanceDao(Arrays.asList("addAllForCompany"));
    mockAttendanceDao3 =
        new MockAttendanceDao(Arrays.asList("findAttendanceContactByParticipation"));
    ucc1 = new AttendanceUccImpl(mockAttendanceDao1, mockUnitOfWork, dal);
    ucc2 = new AttendanceUccImpl(mockAttendanceDao2, mockUnitOfWork, dal);
    ucc3 = new AttendanceUccImpl(mockAttendanceDao3, mockUnitOfWork, dal);
  }

  /**
   * Checking that cancelAttendance calls setAttenceConfirmation on the Dao.
   */
  @Test
  public void testCancelAttendance1() {
    ucc1.cancelAttendance(mockAttendanceDto);
    assertEquals("setAttendanceConfirmation should have been called", true,
        mockAttendanceDao1.validate());
  }

  /**
   * Checking that addAllForCompany calls addAllForCompany on the Dao.
   */
  @Test
  public void testAddAllForCompany1() {
    ucc2.addAllForCompany(mockAttendanceDto, 0);
    assertEquals("addAllForCompany should have been called", true, mockAttendanceDao2.validate());
  }

  /**
   * Checking that editConfirmation calls setAttenceConfirmation atleast once.
   */
  @Test
  public void testEditConfirmation1() {
    ucc1.editConfirmation(Arrays.asList(mockAttendanceDto));;
    assertEquals("setAttendanceConfirmation should have been called at least once", true,
        mockAttendanceDao1.validate());
  }

  @Test
  public void testGetallAttendance() {
    ucc3.getAllAttendance(mockParticipationDto);
    assertEquals("findAttendanceContactByParticipation should have been called", true,
        mockAttendanceDao3.validate());
  }


}
