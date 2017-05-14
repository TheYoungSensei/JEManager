package exceptions;

public class InvalidInformationException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  /**
   * super on Exception. Here for his name.
   * 
   * @param message the message to print with the error.
   */
  public InvalidInformationException(String message) {
    super(message);
  }

  public InvalidInformationException() {
    super();
  }

}
