package exceptions;

public class UserNameAlreadyPickedException extends Exception {

  private static final long serialVersionUID = 1L;

  /**
   * super on Exception. Here for his name.
   * 
   * @param message the message to print with the error.
   */
  public UserNameAlreadyPickedException(String message) {
    super(message);
  }

}
