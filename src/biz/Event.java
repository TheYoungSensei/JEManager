package biz;

/**
 * This is the Event class's interface as seen from a UCC. Once a UCC has been given a DTO, he may
 * cast said object into this type in order to access all business-related methods in addition to
 * the DTO's accessors.
 * 
 * @author Antoine.Maniet
 */
public interface Event extends EventDto, OptimisticLock {

  /**
   * This checks whether the Event we want to add is after the current one.
   * 
   * @param current The current event
   * @return true if the current event is after
   */
  boolean isAfter(EventDto current);
}
