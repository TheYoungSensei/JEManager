package tests;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.time.LocalDateTime;

import org.junit.Before;
import org.junit.Test;

import biz.objects.UserImpl;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

public class UserImplTest {

  private UserImpl user1;
  private UserImpl user2;

  /**
   * @throws Exception if one is thrown during initialisation.
   */
  @Before
  public void setUp() throws Exception {
    user1 = new UserImpl();

    user2 = new UserImpl();
    user2.setEmail("a");
    user2.setFirstName("b");
    user2.setLastName("c");
    user2.setManager(true);
    user2.setPassword("d");
    user2.setRegistrationDate(LocalDateTime.now());
    user2.setUserId(1);
    user2.setUsername("e");
  }

  /**
   * Constructor test 1.
   */
  @Test
  public void testRealUser() {
    user1 = new UserImpl();
    assertNotNull("User should not be null", user1);
  }

  /**
   * SetUserId test 1 with correct value.
   */
  @Test
  public void testSetUserId1() {
    user1.setUserId(1);
    assertEquals("Id should be 1", 1, user1.getUserId());
  }

  /**
   * SetUserId test 2 with incorrect value (negative integer).
   */
  @Test(expected = IllegalArgumentException.class)
  public void testSetUserId2() {
    user1.setUserId(-1);
  }

  /**
   * SetUsername test 1 with correct value.
   */
  @Test
  public void testSetUsername1() {
    user1.setUsername("a");
    assertEquals("Username should be a", "a", user1.getUsername());
  }

  /**
   * SetUsername test 2 with incorrect value (empty string).
   */
  @Test(expected = IllegalArgumentException.class)
  public void testSetUsername2() {
    user1.setUsername("");
  }

  /**
   * SetUsername test 3 with incorrect value (null).
   */
  @Test(expected = IllegalArgumentException.class)
  @SuppressFBWarnings("NP")
  public void testSetUsername3() {
    user1.setUsername(null);
  }

  /**
   * SetFirstName test 1 with correct value.
   */
  @Test
  public void testSetFirstName1() {
    user1.setFirstName("a");
    assertEquals("FirstName should be a", "a", user1.getFirstName());
  }

  /**
   * SetFirstName test 2 with incorrect value (empty string).
   */
  @Test(expected = IllegalArgumentException.class)
  public void testSetFirstName2() {
    user1.setFirstName("");
  }

  /**
   * SetFirstName test 3 with incorrect value (null).
   */
  @Test(expected = IllegalArgumentException.class)
  @SuppressFBWarnings("NP")
  public void testSetFirstName3() {
    user1.setFirstName(null);
  }

  /**
   * SetLastName test 1 with correct value.
   */
  @Test
  public void testSetLastName1() {
    user1.setLastName("a");
    assertEquals("LastName should be a", "a", user1.getLastName());
  }

  /**
   * SetLastName test 2 with incorrect value (empty string).
   */
  @Test(expected = IllegalArgumentException.class)
  public void testSetLastName2() {
    user1.setLastName("");
  }

  /**
   * SetLastName test 3 with incorrect value (null).
   */
  @Test(expected = IllegalArgumentException.class)
  @SuppressFBWarnings("NP")
  public void testSetLastName3() {
    user1.setLastName(null);
  }

  /**
   * SetEmail test 1 with correct value.
   */
  @Test
  public void testSetEmail1() {
    user1.setEmail("a");
    assertEquals("Email should be a", "a", user1.getEmail());
  }

  /**
   * SetEmail test 2 with incorrect value (empty string).
   */
  @Test(expected = IllegalArgumentException.class)
  public void testSetEmail2() {
    user1.setEmail("");
  }

  /**
   * SetEmail test 3 with incorrect value (null).
   */
  @Test(expected = IllegalArgumentException.class)
  @SuppressFBWarnings("NP")
  public void testSetEmail3() {
    user1.setEmail(null);
  }

  /**
   * SetRegistrationDate test 1 with correct value.
   */
  @Test
  public void testSetRegistrationDate1() {
    LocalDateTime now = LocalDateTime.now();
    user1.setRegistrationDate(now);
    assertEquals("RegistrationDate should be " + now.toString(), user1.getRegistrationDate(), now);
  }

  /**
   * SetRegistrationDate test 2 with incorrect value (1 hour in the future).
   */
  @Test(expected = IllegalArgumentException.class)
  public void testSetRegistrationDate2() {
    user1.setRegistrationDate(LocalDateTime.now().plusHours(1));
  }

  /**
   * SetRegistrationDate test 2 with incorrect value (null).
   */
  @Test(expected = IllegalArgumentException.class)
  @SuppressFBWarnings("NP")
  public void testSetRegistrationDate3() {
    user1.setRegistrationDate(null);
  }

  /**
   * SetPassword test 1 with correct value.
   */
  @Test
  public void testSetPassword1() {
    user1.setPassword("a");
    assertEquals("Password should be a", "a", user1.getPassword());
  }

  /**
   * SetPassword test 2 with incorrect value (empty string).
   */
  @Test(expected = IllegalArgumentException.class)
  public void testSetPassword2() {
    user1.setPassword("");
  }

  /**
   * SetPassword test 3 with incorrect value (null).
   */
  @Test(expected = IllegalArgumentException.class)
  @SuppressFBWarnings("")
  public void testSetPassword3() {
    user1.setPassword(null);
  }

  /**
   * SetManager test 1 with correct value.
   */
  @Test
  public void testSetManager1() {
    user1.setManager(true);
    assertEquals("Manager value should be true", true, user1.isManager());
  }

  /**
   * Testing all getters on a sample user.
   */
  @Test
  public void testGetters() {
    LocalDateTime now = LocalDateTime.now();
    user2.setRegistrationDate(now);

    assertEquals("Email should be a", "a", user2.getEmail());
    assertEquals("FirstName should be b", "b", user2.getFirstName());
    assertEquals("LastName should be c", "c", user2.getLastName());
    assertEquals("Manager should be true", true, user2.isManager());
    assertEquals("Password should be d", "d", user2.getPassword());
    assertEquals("RegistrationDate should be " + now.toString(), now, user2.getRegistrationDate());
    assertEquals("UserId should be 1", 1, user2.getUserId());
    assertEquals("Username should be e", "e", user2.getUsername());
  }

  /**
   * EncryptPassword test, verifies that the password changes after encryption procedure. Note :
   * this test does not guarantee the quality of the encryption procedure.
   */
  @Test
  public void testEncryptPassword() {
    String pass1 = user2.getPassword();
    user2.encryptPassword();
    String pass2 = user2.getPassword();
    if (pass1.equals(pass2))
      fail("Password encryption failed");
  }

  /**
   * CheckPassword test 1 with correct values.
   */
  @Test
  public void testCheckPassword1() {
    user2.encryptPassword();
    assertEquals("Password check should result true", true, user2.checkPassword("d"));
  }

  /**
   * CheckPassword test 2 wih incorrect values (entered password doesn't match the user's).
   */
  @Test
  public void testCheckPassword2() {
    user2.encryptPassword();
    assertEquals("Password check should result false", false, user2.checkPassword("bad"));
  }

  /**
   * CheckNewUserInformation test, TODO
   */
  @Test
  public void testCheckNewUserInformation() {
    // TODO
  }
}
