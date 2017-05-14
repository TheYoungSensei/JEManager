package mockObjects;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import biz.Contact;
import biz.Dto;
import persistence.dao.ContactDao;
import util.SetValidator;

public class MockContactDao extends SetValidator implements ContactDao {

  /**
   * Empty constructor.
   * 
   * @author alexandre.maniet
   */
  public MockContactDao() {
    super();
  }

  /**
   * @param expectedMethodsCalls expected methods.
   * @author alexandre.maniet
   */
  public MockContactDao(Collection<String> expectedMethodsCalls) {
    super(expectedMethodsCalls);
  }

  @Override
  public int delete(Dto dto) {
    addCurrentMethodToSet();
    return 0;
  }

  @Override
  public List<Contact> getAllContacts() {
    addCurrentMethodToSet();
    return Arrays.asList(new MockContact());
  }

  @Override
  public Contact getContactById(int idContact) {
    addCurrentMethodToSet();
    return new MockContact();
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
