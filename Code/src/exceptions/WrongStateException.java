package exceptions;

public class WrongStateException extends Exception {
  private static final long serialVersionUID = 1L;

  public WrongStateException(String message) {
    super(message);
  }
}
