package ucc;

import biz.User;
import biz.UserDto;
import exceptions.InvalidInformationException;
import exceptions.UserNameAlreadyPickedException;

public interface UserUcc {

  /**
   * @author Maniet.Alexandre
   * @param user The User instance of which the values must be set then compared to the DB using the
   *        persistence layer
   * @return True if the login was successful, false otherwise.
   */
  UserDto login(UserDto user);

  /**
   * @author Maniet.Alexandre
   * @param username The user's username as present in the current session variable
   * @return A complete userDto object corresponding to the username given as parameter
   */
  UserDto getUserByUsername(String username);

  /**
   * @author Maniet.Alexandre
   * @param id Id of the user to retrieve
   * @return A UserDao corresponding to the given id
   */
  UserDto getUserById(int id);

  /**
   * Register the user if the UserDto contains valid information.
   * 
   * @param user The UserDto
   * @return The User with his ID
   * @throws UserNameAlreadyPickedException Thrown if the name of the user is already contained in
   *         the DB
   * @throws InvalidInformationException Thrown if the typed datas are invalid.
   */
  User register(UserDto user) throws UserNameAlreadyPickedException, InvalidInformationException;
}
