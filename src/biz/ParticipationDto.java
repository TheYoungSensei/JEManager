package biz;

/**
 * This is the Participation class's interface as seen from the servlet. The factory instanciates
 * Participation objects with this interface as type, then hands the object over to the servlet. A
 * UCC may then cast said object into a fully functionnal "Participation" interface type, granting
 * him access to all business-related methods. < *
 * 
 * @author Antoine.Maniet
 */
public interface ParticipationDto extends Dto {

  /**
   * @return The participation's id as assigned in the database during the insertion.
   */
  int getParticipationId();

  /**
   * Retrieves the Company from the DB with the ID contained in the CompanyId field of the
   * participation.
   * 
   * 
   * @return The participation's company as assigned in the database during the insertion.
   */
  Company getCompany();

  /**
   * Retrieves the Event from the DB with the ID contained in the EventId field of the
   * participation.
   * 
   * 
   * @return The participation's event as assigned in the database during the insertion.
   */
  Event getEvent();

  /**
   * @return The participation's current state.
   */
  String getState();

  /**
   * @author Antoine.Maniet
   * @param participationId The integer to set the field ParticipationId to
   * @exception IllegalArgumentException thrown if the ParticipationId is a negative integer
   */
  void setParticipationId(int participationId);

  /**
   * @author Antoine.Maniet
   * @param company The Company to set the field Company to
   * @exception IllegalArgumentException thrown if the company is null
   */
  void setCompany(Company company);

  /**
   * @author Antoine.Maniet
   * @param event The Event to set the field Event to
   * @exception IllegalArgumentException thrown if the event is null
   */
  void setEvent(Event event);

  /**
   * @author Antoine.Maniet
   * @param state The string to set the field State to
   * @exception IllegalArgumentException thrown if the ParticipationId is null or an invalid state
   */
  void setState(String state);

  /**
   * @return The participation's company's id as assigned in the database during the insertion.
   */
  public int getCompanyId();

  /**
   * @author Antoine.Maniet
   * @param companyId The integer to set the field CompanyId to
   * @exception IllegalArgumentException thrown if the CompanyId is a negative integer
   */
  public void setCompanyId(int companyId);

  /**
   * @return The participation's event's id as assigned in the database during the insertion.
   */
  public int getEventId();

  /**
   * @author Antoine.Maniet
   * @param eventId The integer to set the field EventId to
   * @exception IllegalArgumentException thrown if the EventId is a negative integer
   */
  public void setEventId(int eventId);

  /**
   * @author Damien.Meur
   * @param version the version's number we wan't to set
   */
  public void setVersion(int version);

  /**
   * @author Damien.Meur
   * @return current num version
   */
  public int getVersion();
}
