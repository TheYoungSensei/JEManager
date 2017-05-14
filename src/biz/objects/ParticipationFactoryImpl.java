package biz.objects;

import biz.ParticipationDto;
import biz.ParticipationFactory;

/**
 * This implementation of the factory is used to create new Real DTO objects.
 * 
 * @author Antoine.Maniet
 */
class ParticipationFactoryImpl implements ParticipationFactory {
  public ParticipationDto getParticipation() {
    return new ParticipationImpl();
  }
}
