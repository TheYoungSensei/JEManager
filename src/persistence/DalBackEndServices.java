package persistence;

import java.sql.PreparedStatement;

public interface DalBackEndServices {

  /**
   * This returns a preparedStatement.
   * 
   * @param requete A string corresponding to a SQL request
   * @return The PreparedStatement made with "requete"
   */
  public PreparedStatement prepareStatement(String requete);
}
