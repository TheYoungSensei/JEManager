package exceptions;

/**
 * Extends RuntimeException, is meant to be caught in the main
 * 
 * @author Maniet.Alexandre
 */
public class IncompleteRequestException extends RuntimeException {
  private static final long serialVersionUID = 1L;

  /**
   * Creates an empty IncompleteRequestException.
   */
  public IncompleteRequestException() {
    super();
  }

  /**
   * Creates a qualified IncompleteRequestException.
   * 
   * @param message Small descriptor to attach to the exception
   */
  public IncompleteRequestException(String message) {
    super(message);
  }
}
