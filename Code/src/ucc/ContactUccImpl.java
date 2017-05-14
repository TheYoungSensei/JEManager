package ucc;

import java.util.List;
import java.util.stream.Collectors;

import biz.Contact;
import biz.ContactDto;
import exceptions.InvalidInformationException;
import persistence.DalServices;
import persistence.UnitOfWork;
import persistence.dao.ContactDao;

public class ContactUccImpl implements ContactUcc {

  private ContactDao contactDao;
  private UnitOfWork unit;
  private DalServices dal;

  /**
   * @param contactDao the ucc's dao
   * @param unit the ucc's unit of work
   * @param dal the ucc's instance of dalservices
   * @author alexandre.maniet
   */
  public ContactUccImpl(ContactDao contactDao, UnitOfWork unit, DalServices dal) {
    this.contactDao = contactDao;
    this.unit = unit;
    this.dal = dal;
  }

  /**
   * {@inheritDoc}.
   */
  public Contact addContact(ContactDto contact) {
    unit.startTransaction();
    Contact contactDto = (Contact) contact;
    try {
      contactDto.checkNewContactInformation();
    } catch (InvalidInformationException exception) {
      unit.rollBack();
      throw new InvalidInformationException();
    }
    unit.addInsert(contactDto);
    unit.commit();
    contactDto.setContactId(unit.getResult());
    if (contactDto.getContactId() == -1) {
      throw new InvalidInformationException();
    }
    return contactDto;
  }

  @Override
  public List<ContactDto> getAllContacts() {
    dal.startTransaction();
    List<ContactDto> list =
        contactDao.getAllContacts().stream().map(c -> (ContactDto) c).collect(Collectors.toList());
    dal.commit();
    return list;
  }

  @Override
  public Contact setContactActivity(ContactDto contactParam) {
    dal.startTransaction();
    Contact contact = contactDao.getContactById(contactParam.getContactId());
    dal.commit();
    contact.setActive(contactParam.isActive());
    contact.setContactId(contactParam.getContactId());
    contact.setVersion(contactParam.getVersion());
    unit.startTransaction();
    unit.addUpdate(contact);
    unit.commit();
    dal.startTransaction();
    Contact contactRetour = contactDao.getContactById(contact.getContactId());
    dal.commit();
    return contactRetour;
  }

  @Override
  public ContactDto updateContact(ContactDto contact) {
    unit.startTransaction();
    try {
      ((Contact) contact).checkModifyContactInformation();
    } catch (InvalidInformationException exception) {
      unit.rollBack();
      throw new InvalidInformationException();
    }
    unit.addUpdate(contact);
    unit.commit();
    dal.startTransaction();
    ContactDto toReturn = contactDao.getContactById(contact.getContactId());
    dal.commit();
    return toReturn;
  }
}
