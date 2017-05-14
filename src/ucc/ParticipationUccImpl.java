package ucc;

import java.util.List;
import java.util.stream.Collectors;

import biz.Event;
import biz.EventDto;
import biz.Participation;
import biz.ParticipationDto;
import exceptions.WrongStateException;
import persistence.DalServices;
import persistence.UnitOfWork;
import persistence.dao.ParticipationDao;

public class ParticipationUccImpl implements ParticipationUcc {

  private ParticipationDao participationDao;
  private UnitOfWork unit;
  private DalServices dal;

  /**
   * @param participationDao the ucc's dao
   * @param unit the ucc's unit of work
   * @param dal the ucc's instance of dalservices
   * @author alexandre.maniet
   */
  public ParticipationUccImpl(ParticipationDao participationDao, UnitOfWork unit, DalServices dal) {
    this.participationDao = participationDao;
    this.unit = unit;
    this.dal = dal;
  }

  @Override
  public ParticipationDto addParticipation(ParticipationDto participation) {
    unit.startTransaction();
    Participation participationDto = (Participation) participation;
    unit.addInsert(participationDto);
    unit.commit();
    participationDto.setParticipationId(unit.getResult());
    if (participationDto.getParticipationId() == -1) {
      return null;
    }
    return participationDto;
  }

  @Override
  public List<ParticipationDto> getCurrentParticipations() {
    dal.startTransaction();
    List<ParticipationDto> list = participationDao.getCurrentParticipations().stream()
        .map(p -> (ParticipationDto) p).collect(Collectors.toList());
    dal.commit();
    return list;
  }

  @Override
  public List<ParticipationDto> getAllParticipations() {
    dal.startTransaction();
    List<ParticipationDto> list = participationDao.getAllParticipations().stream()
        .map(p -> (ParticipationDto) p).collect(Collectors.toList());
    dal.commit();
    return list;
  }

  @Override
  public int countInvitedParticipation(EventDto event) {
    dal.startTransaction();
    int integer = participationDao.countParticipations((Event) event, INVITED);
    dal.commit();
    return integer;
  }

  @Override
  public int countConfirmedParticipation(EventDto event) {
    dal.startTransaction();
    int integer = participationDao.countParticipations((Event) event, CONFIRMED);
    dal.commit();
    return integer;
  }

  @Override
  public int countRefusedParticipation(EventDto event) {
    dal.startTransaction();
    int integer = participationDao.countParticipations((Event) event, REFUSED);
    dal.commit();
    return integer;
  }

  @Override
  public int countCancelledParticipation(EventDto event) {
    dal.startTransaction();
    int integer = participationDao.countParticipations((Event) event, CANCELLED);
    dal.commit();
    return integer;
  }

  @Override
  public int countInvoicedParticipation(EventDto event) {
    dal.startTransaction();
    int integer = participationDao.countParticipations((Event) event, INVOICED);
    dal.commit();
    return integer;
  }

  @Override
  public int countPaidParticipation(EventDto event) {
    dal.startTransaction();
    int integer = participationDao.countParticipations((Event) event, PAID);
    dal.commit();
    return integer;
  }

  @Override
  public int editStates(List<ParticipationDto> participations) throws WrongStateException {
    unit.startTransaction();
    for (ParticipationDto participationDto : participations) {
      Participation participation = (Participation) participationDto;
      participation.checkState();
      unit.addUpdate(participationDto);
    }
    unit.commit();
    return 0;
  }

  @Override
  public List<ParticipationDto> getAllPartcipationFor(EventDto event) {
    dal.startTransaction();
    List<ParticipationDto> list = participationDao.getParticipationForState((Event) event, ALL)
        .stream().map(p -> (ParticipationDto) p).collect(Collectors.toList());
    dal.commit();
    return list;
  }

  @Override
  public List<ParticipationDto> getInvitedParticipationsFor(EventDto event) {
    dal.startTransaction();
    List<ParticipationDto> list = participationDao.getParticipationForState((Event) event, INVITED)
        .stream().map(p -> (ParticipationDto) p).collect(Collectors.toList());
    dal.commit();
    return list;
  }

  @Override
  public List<ParticipationDto> getConfirmedParticipationsFor(EventDto event) {
    dal.startTransaction();
    List<ParticipationDto> list =
        participationDao.getParticipationForState((Event) event, CONFIRMED).stream()
            .map(p -> (ParticipationDto) p).collect(Collectors.toList());
    dal.commit();
    return list;
  }

  @Override
  public List<ParticipationDto> getRefusedParticipationsFor(EventDto event) {
    dal.startTransaction();
    List<ParticipationDto> list = participationDao.getParticipationForState((Event) event, REFUSED)
        .stream().map(p -> (ParticipationDto) p).collect(Collectors.toList());
    dal.commit();
    return list;
  }

  @Override
  public List<ParticipationDto> getCancelledParticipationsFor(EventDto event) {
    dal.startTransaction();
    List<ParticipationDto> list =
        participationDao.getParticipationForState((Event) event, CANCELLED).stream()
            .map(p -> (ParticipationDto) p).collect(Collectors.toList());
    dal.commit();
    return list;
  }

  @Override
  public List<ParticipationDto> getInvoicedParticipationsFor(EventDto event) {
    dal.startTransaction();
    List<ParticipationDto> list = participationDao.getParticipationForState((Event) event, INVOICED)
        .stream().map(p -> (ParticipationDto) p).collect(Collectors.toList());
    dal.commit();
    return list;
  }

  @Override
  public List<ParticipationDto> getPaidParticipationsFor(EventDto event) {
    dal.startTransaction();
    List<ParticipationDto> list = participationDao.getParticipationForState((Event) event, PAID)
        .stream().map(p -> (ParticipationDto) p).collect(Collectors.toList());
    dal.commit();
    return list;
  }
}
