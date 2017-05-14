package mockObjects;

import java.util.Collection;

import biz.Dto;
import persistence.UnitOfWork;
import util.SetValidator;

public class MockUnitOfWork extends SetValidator implements UnitOfWork {

  /**
   * Empty constructor.
   * 
   * @author alexandre.maniet
   */
  public MockUnitOfWork() {
    super();
  }

  /**
   * @param expectedMethodsCalls expected methods.
   * @author alexandre.maniet
   */
  public MockUnitOfWork(Collection<String> expectedMethodsCalls) {
    super(expectedMethodsCalls);
  }

  @Override
  public void addDelete(Dto dto) {
    addCurrentMethodToSet();
  }

  @Override
  public void addInsert(Dto dto) {
    addCurrentMethodToSet();
  }

  @Override
  public void addUpdate(Dto dto) {
    addCurrentMethodToSet();
  }

  @Override
  public void commit() {
    addCurrentMethodToSet();
  }

  @Override
  public int getResult() {
    addCurrentMethodToSet();
    return 0;
  }

  @Override
  public void rollBack() {
    addCurrentMethodToSet();
  }

  @Override
  public void startTransaction() {
    addCurrentMethodToSet();
  }

}
