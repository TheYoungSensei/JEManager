package mockObjects;

import java.util.Collection;

import biz.Dto;
import biz.User;
import persistence.dao.UserDao;
import util.SetValidator;

public class MockUserDao extends SetValidator implements UserDao {

  private boolean giveNoUsername;

  /**
   * Empty constructor.
   * 
   * @author alexandre.maniet
   */
  public MockUserDao() {
    super();
  }

  /**
   * @param expectedMethodsCalls expected methods.
   * @author alexandre.maniet
   */
  public MockUserDao(Collection<String> expectedMethodsCalls) {
    super(expectedMethodsCalls);
    giveNoUsername = false;
  }

  /**
   * @param expectedMethodsCalls expected methods.
   * @param giveNoUsername wether or not the getUsernameByPseudo returns null.
   * @author alexandre.maniet
   */
  public MockUserDao(Collection<String> expectedMethodsCalls, boolean giveNoUsername) {
    super(expectedMethodsCalls);
    this.giveNoUsername = giveNoUsername;
  }

  @Override
  public int delete(Dto dto) {
    addCurrentMethodToSet();
    return 0;
  }

  @Override
  public User getUserById(int id) {
    addCurrentMethodToSet();
    return new MockUser();
  }

  @Override
  public User getUserByPseudo(String pseudo) {
    addCurrentMethodToSet();
    if (giveNoUsername)
      return null;
    return new MockUser();
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

}
