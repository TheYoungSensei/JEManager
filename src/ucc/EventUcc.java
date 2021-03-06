package ucc;

import java.util.HashMap;
import java.util.List;

import biz.EventDto;

public interface EventUcc {

  /**
   * This method gather informations for the soon full csv file. The csv file must contain : "le nom
   * de l'entreprise, le nom de la personne de contact, le prénom de la personne de contact,
   * l'e-mail de la personne de contact."
   * 
   * @param event The event we need the information for
   * @return a map containing all the information
   */
  HashMap<String, Object> generateFullCsv(EventDto event);

  /**
   * This method send a string used for the csvModifiedThings case.
   * 
   * @param idParticipation The id of the participation we need a row for
   * @return a map containing all the information
   */
  HashMap<String, Object> generateCsvRows(int idParticipation);

  /**
   * This method send a full EventDto object if there is an event unclosed, null otherwise.
   * 
   * @return the eventDto having his closed boolean to false
   */
  EventDto getCurrentEvent();

  /**
   * @author Sacre.Christopher
   * @return The list about the events found in the database.
   */
  List<EventDto> getAllEvents();

  /**
   * Use case Create function for an event.
   * 
   * @param eventDto event's data
   * @return newly added event or null otherwise.
   */
  EventDto addNewEvent(EventDto eventDto);

  /**
   * Get an event by his id.
   * 
   * @author Sacre.Christopher
   * @param id the id.
   * @return the eventDto corresponding to the id.
   */
  EventDto getEventById(int id);
}
