package tests;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import exceptions.InvalidInformationException;
import exceptions.UserNameAlreadyPickedException;
import mockObjects.MockDalServices;
import mockObjects.MockUnitOfWork;
import mockObjects.MockUser;
import mockObjects.MockUserDao;
import ucc.UserUccImpl;
import util.Helper;

public class UserUccImplTest {

  private Helper helper;
  private MockDalServices mockDal, mockDal2;
  private MockUnitOfWork mockUnitOfWork1, mockUnitOfWork2;
  private UserUccImpl ucc1, ucc2, ucc3, ucc4;
  private MockUserDao mockUserDao1, mockUserDao3, mockUserDao4;
  private MockUser mockUser;

  /**
   * @throws Exception If one is thrown during initialisation.
   */
  @Before
  public void setUp() throws Exception {
    helper = new Helper();
    mockDal = new MockDalServices(Arrays.asList("startTransaction", "commit"));
    mockDal2 = new MockDalServices(Arrays.asList("rollback"));
    mockUser = new MockUser();
    mockUnitOfWork1 = new MockUnitOfWork(Arrays.asList("sartTransaction", "commit"));
    mockUnitOfWork2 = new MockUnitOfWork(Arrays.asList("startTransaction", "commit", "addInsert"));
    mockUserDao1 = new MockUserDao(Arrays.asList("getUserByPseudo"));
    mockUserDao3 = new MockUserDao(Arrays.asList("getUserById"));
    mockUserDao4 = new MockUserDao(Arrays.asList("getUserById", "getUserByPseudo"), true); // giveNoUsername
    ucc1 = new UserUccImpl(mockUserDao1, mockDal, mockUnitOfWork1);
    ucc2 = new UserUccImpl(mockUserDao4, mockDal, mockUnitOfWork2);
    ucc3 = new UserUccImpl(mockUserDao3, mockDal, mockUnitOfWork1);
    ucc4 = new UserUccImpl(mockUserDao1, mockDal2, mockUnitOfWork1);
  }

  /**
   * Checking that login calls the getUserByPseudo method on the company dao and
   * startTransaction+commit on the dal.
   */
  @Test
  public void testLogin() {
    ucc1.login(mockUser);
    assertEquals("getUserByPseudo should have been called on the dao", true,
        mockUserDao1.validate());
    helper.testDal(mockDal);
  }

  /**
   * Checking that register calls the addInsert, startTransaction and commit on the unit of work and
   * startTansaction+commit was called on the dal. Also checks that getUserById is called on the dao
   * 
   * @throws InvalidInformationException if thrown by the method under test
   * @throws UserNameAlreadyPickedException if thrown by the method under test
   */
  @Test
  public void testRegister() throws UserNameAlreadyPickedException, InvalidInformationException {
    ucc2.register(mockUser);
    helper.testUnit(mockUnitOfWork2);
    helper.testDal(mockDal);
    helper.testUserDao(mockUserDao4);
  }

  /**
   * Checking that register throws and exception +rollback if the dao returns null when asked to
   * fetch a user.
   * 
   * @throws InvalidInformationException if thrown by the method under test
   * @throws UserNameAlreadyPickedException if thrown by the method under test
   */
  @Test(expected = Exception.class)
  public void testRegister2() throws UserNameAlreadyPickedException, InvalidInformationException {
    try {
      ucc4.register(mockUser);
    } finally {
      helper.testDal(mockDal2);
    }
  }

  /**
   * Checking that getUserByUsername calls the getUserByPseudo method on the company dao.
   */
  @Test
  public void testGetUserByUsername() {
    ucc1.getUserByUsername("");
    assertEquals("getUserByPseudo should have been called on the dao", true,
        mockUserDao1.validate());
  }

  /**
   * Checking that an exception is thrown + rollback when the string given as argument is null.
   */
  @Test(expected = Exception.class)
  public void testGetUserByUsername2() {
    ucc1.getUserByUsername(null);
    assertEquals("getUserByPseudo should have been called on the dao", true,
        mockUserDao1.validate());
  }

  /**
   * Checking that getUserById calls the getUserById method on the company dao.
   */
  @Test
  public void testGetUserById() {
    ucc3.getUserById(0);
    assertEquals("getUserById should have been called on the dao", true, mockUserDao3.validate());
  }
}
