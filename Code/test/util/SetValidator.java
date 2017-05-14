package util;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * This class is a helper tool intented for JUnit tests, especially method call testing with mock
 * objects. This class is meant to be extendend by mock objects (don't forget to generate the
 * constructors from this superclass in the mock objects), which may then have the
 * "addCurrentMethodToSet" at the beginning all of their methods. Testing using those mock objects
 * is now as simple as creating them with a list of expected methods as a constructor parameter (eg
 * : new myMock(Arrays.asList("myMethod1","myMethod42")) ), executing a test routine and finally
 * calling the validate() method on said mock object to verify all expected calls were made.
 * 
 * @author Alexandre.Maniet
 */
public abstract class SetValidator {

  /**
   * @see addCurrentMethodToSet() for usage details. This represents the index of the closest,
   *      non-internal caller method when looking up a stacktrace table.
   * @author Alexandre.Maniet
   */
  private static final int CALLER_METHOD_INDEX = 2;

  /**
   * The expectedMethodCalls set is to be populated with a constructor parameter (at object
   * initialisation) while the receivedMethodCalls set is to be populated "one by one" using the
   * addCurrentMethodToSet method until it hopefully matches all elements of the expected calls.
   * 
   * @author Alexandre.Maniet
   */
  private Set<String> receivedMethodCalls, expectedMethodCalls;

  /**
   * Empty constructor.
   */
  public SetValidator() {
    super();
    this.receivedMethodCalls = new HashSet<>();
    this.expectedMethodCalls = new HashSet<>();

  }

  /**
   * @param expectedMethodsCalls A collection containing all methods which are expected to be called
   *        on an object during a test.
   * @author Alexandre.Maniet
   */
  public SetValidator(Collection<String> expectedMethodsCalls) {
    this.receivedMethodCalls = new HashSet<>();
    this.expectedMethodCalls = new HashSet<>(expectedMethodsCalls);
  }

  /**
   * Adds the calling method's name to the set of received method calls. If myMockObjectMethod()
   * calls addCurrentMethodToSet, the entry "myMockObjectMethod" will be added to the validator's
   * set of received method calls.
   * 
   * @author Alexandre.Maniet
   */
  public void addCurrentMethodToSet() {
    receivedMethodCalls
        .add(Thread.currentThread().getStackTrace()[CALLER_METHOD_INDEX].getMethodName());
  }

  /**
   * @return true if all expected method calls were received or expectedMethodCalls is null. false
   *         if any of the expected calls was not received.
   * @author Alexandre.Maniet
   */
  public boolean validate() {
    if (expectedMethodCalls == null)
      return true;
    return receivedMethodCalls.containsAll(expectedMethodCalls);
  }

}
