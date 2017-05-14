package persistence.dao;

import biz.User;

public interface UserDao extends Dao {


  /**
   * get a user from its pseudo.
   * 
   * @param pseudo the pseudo of the user
   * @return null if the authentification fails
   */
  User getUserByPseudo(String pseudo);

  /**
   * Function which retrieves a user's data from the persistence unit.
   * 
   * @param id target user's id
   * @return the target user's data, null otherwise.
   */
  User getUserById(int id);
}
