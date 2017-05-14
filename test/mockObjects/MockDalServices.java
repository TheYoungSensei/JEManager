package mockObjects;

import java.util.Collection;

import persistence.DalServices;
import util.SetValidator;

/**
 * Used in tests, acts as a fake dal.
 * 
 * @author Alexandre.Maniet
 */
public class MockDalServices extends SetValidator implements DalServices {

  /**
   * Empty constructor.
   * 
   * @author alexandre.maniet
   */
  public MockDalServices() {
    super();
  }

  /**
   * @param expectedMethodsCalls expected methods.
   * @author alexandre.maniet
   */
  public MockDalServices(Collection<String> expectedMethodsCalls) {
    super(expectedMethodsCalls);
  }

  @Override
  public void commit() {
    addCurrentMethodToSet();
  }

  @Override
  public void rollback() {
    addCurrentMethodToSet();
  }

  @Override
  public void startTransaction() {
    addCurrentMethodToSet();
  }
}
