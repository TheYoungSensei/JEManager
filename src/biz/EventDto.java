package biz;

import java.time.LocalDateTime;

/**
 * This is the Event class's interface as seen from the servlet. The factory instanciates Event
 * objects with this interface as type, then hands the object over to the servlet. A UCC may then
 * cast said object into a fully functionnal "Event" interface type, granting him access to all
 * business-related methods.
 * 
 * @author Antoine.Maniet
 */
public interface EventDto extends Dto {

  /**
   * @return The user's id as assigned in the database during the insertion.
   */
  int getEventId();

  /**
   * @return The event's date as chosen by the manager.
   */
  LocalDateTime getDate();

  /**
   * @return The state of the event. Only the last event may have his closed state set to false.
   */
  boolean isClosed();

  /**
   * @author Antoine.Maniet
   * @param userId The integer to set the field eventId to
   * @exception IllegalArgumentException thrown if the eventId is a negative integer
   */
  void setEventId(int userId);

  /**
   * @author Antoine.Maniet
   * @param date The date to set the event's date to
   * @exception IllegalArgumentException thrown if date is null or empty
   */
  void setDate(LocalDateTime date);

  /**
   * @author Antoine.Maniet
   * @param closed The boolean to set the state of the event (current = not closed)
   */
  void setClosed(boolean closed);
}
