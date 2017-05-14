package persistence;

public interface DalServices {

  /**
   * Makes all changes made since the previous commit/rollback permanent and releases any database
   * locks currently held by this Connection object. This method should be used only when
   * auto-commit mode has been disabled. Sets this connection's auto-commit mode to True
   * 
   * @author Antoine.Maniet
   */
  public void commit();

  /**
   * Undoes all changes made in the current transaction and releases any database locks currently
   * held by this Connection object. This method should be used only when auto-commit mode has been
   * disabled. Sets this connection's auto-commit mode to True
   * 
   * @author Antoine.Maniet
   */
  public void rollback();

  /**
   * Sets this connection's auto-commit mode to False. If a connection is in auto-commit mode, then
   * all its SQL statements will be executed and committed as individual transactions. Otherwise,
   * its SQL statements are grouped into transactions that are terminated by a call to either the
   * method commit or the method rollback. By default, this connection is in auto-commit mode.
   * 
   * 
   * @author Antoine.Maniet
   */
  public void startTransaction();
}
