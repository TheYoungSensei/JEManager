package util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Util {

  /**
   * @author Maniet.Alexandre
   * @param arrayList The ArrayList which needs to be verified.
   * @exception IllegalArgumentException thrown if the arrayList is empty.
   */
  public static void checkArrayList(ArrayList<?> arrayList) {
    checkNull(arrayList);
    if (arrayList.isEmpty()) {
      throw new IllegalArgumentException("The list cannot be empty");
    }
  }

  /**
   * @author Maniet.Alexandre
   * @param integer The Integer which needs to be verified.
   * @exception IllegalArgumentException thrown if the Integer has a negative value.
   */
  public static void checkPositiveInteger(Integer integer) {
    checkNull(integer);
    if (integer < 0) {
      throw new IllegalArgumentException("Integer has a negative value : " + integer);
    }
  }

  /**
   * @author Sacre.Christopher
   * @param integer The integer which needs to be verified.
   * @exception IllegalArgumentException thrown if the Integer has a positive value or equals 0.
   */
  public static void checkNegativeInteger(Integer integer) {
    checkNull(integer);
    if (integer >= 0) {
      throw new IllegalArgumentException("Integer has a positive value : " + integer);
    }
  }

  /**
   * @author Sacre.Christopher
   * @param string The String to be tested.
   * @exception IllegalArgumentException thrown if the String is not a valid number.
   */
  public static void checkNumeric(String string) {
    checkString(string);
    try {
      Long.parseLong(string);
    } catch (NumberFormatException nfe) {
      throw new IllegalArgumentException("The String must be a valid number");
    }
  }

  /**
   * @author Maniet.Alexandre
   * @param dateTime The date and time which needs to be verified.
   * @exception IllegalArgumentException thrown if the entered date is null (-or in the future.) ->
   *            Antoine.Maniet : I changed this since some LocalDateTime can be in the futur
   *            (current event's date)
   */
  public static void checkLocalDateTime(LocalDateTime dateTime) {
    checkNull(dateTime);
    if (dateTime.isAfter(LocalDateTime.now())
        || dateTime.isBefore(LocalDateTime.of(1000, 1, 1, 1, 1))) {
      throw new IllegalArgumentException("Date entered is in the future : " + dateTime.toString());
    }
  }

  /**
   * @author Maniet.Alexandre
   * @param object The object which needs to be verified.
   * @exception IllegalArgumentException thrown if the object is null.
   */
  public static void checkNull(Object object) {
    if (object == null) {
      throw new IllegalArgumentException("Variable is null");
    }
  }

  /**
   * @author Maniet.Alexandre
   * @param string The string which needs to be verified.
   * @exception IllegalArgumentException thrown if the string is either null or empty.
   */
  public static void checkString(String string) {
    checkNull(string);
    if (string.isEmpty()) {
      throw new IllegalArgumentException("String cannot be empty");
    }
  }

  /**
   * @author Maniet.Alexandre
   * @param object The object of which the type must be verified.
   * @return True if the object given as argument is an Integer.
   */
  public static boolean isInteger(Object object) {
    checkNull(object);
    return object.getClass().equals(Integer.class);
  }

  /**
   * @author Maniet.Alexandre
   * @param object The object of which the type must be verified.
   * @return True if the object given as argument is a String.
   */
  public static boolean isString(Object object) {
    checkNull(object);
    return object.getClass().equals(String.class);
  }

  /**
   * Example of a valid LocalDateTime string : 2011-12-03 10:15:30.
   * 
   * @author Maniet.Antoine
   * @param stringDate The string which needs to become a LocalDateTime.
   * @return The LocalDateTime made if the string given as argument has a valid format, null
   *         otherwise.
   */
  public static LocalDateTime stringToLocalDateTime(String stringDate) {
    stringDate = stringDate.substring(0, 10) + " 00:00:00";
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    checkNull(stringDate);
    try {
      return LocalDateTime.parse(stringDate, formatter);
    } catch (Exception exception) {
      return null;
    }
  }

  /**
   * Example of a valid LocalDateTime string : 2011-12-03 10:15:30.
   * 
   * @author Maniet.Antoine
   * @param localDateTime The LocalDateTime which needs to become a String.
   * @return The toString of LocalDateTime if the localDateTime given as argument isn't null
   */
  public static String localDateTimeToString(LocalDateTime localDateTime) {
    checkNull(localDateTime);
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    String toReturn = localDateTime.format(formatter);
    return toReturn;
  }
}
