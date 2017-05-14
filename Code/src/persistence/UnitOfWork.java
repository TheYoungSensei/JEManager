package persistence;

import biz.Dto;

/**
 * This is the UnitOfWork's interface, it is needed to test the UCC methods as we will create a
 * MockUnitOfWork implementing this interface.
 * 
 * @author Alexandre.Maniet
 */
public interface UnitOfWork {

  /**
   * Used to instantiate a new UnitOfWorkBag for the current thread an increment the semaphore.
   *
   * @author SacreChristopher
   */
  public void startTransaction();

  /**
   * Used to decrement the semaphore.
   *
   * @author Sacre.Christopher
   */
  public void rollBack();

  /**
   * Used to put the dto in the update map.
   * 
   * @author Sacre.Christopher
   * @param dto the dto to update.
   */
  public void addUpdate(Dto dto);

  /**
   * Used to put the dto in the insert map.
   * 
   * @author Sacre.Christopher
   * @param dto the dto to insert.
   */
  public void addInsert(Dto dto);

  /**
   * Used to put the dto in the delete map.
   * 
   * @author Sacre.Christopher
   * @param dto the dto to delete.
   */
  public void addDelete(Dto dto);

  /**
   * Method that start the transaction, process insert, update and delete and then commit.
   *
   * @author Sacre.Christopher
   */
  public void commit();

  /**
   * Return the result get during the commit.
   * 
   * @return the id returned for the Thread during the commit.
   */
  public int getResult();
}
