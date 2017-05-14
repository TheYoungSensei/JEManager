package biz.objects;

import java.time.LocalDateTime;

import biz.User;
import util.Util;

public class CompanyImpl implements biz.Company {
  private int companyId;
  private User creator;
  private int creatorId;
  private String name;
  private LocalDateTime dateFirstContact;
  private String street;
  private int number;
  private String box;
  private int postalCode;
  private String municipality;
  private int version = 0;

  public int getCompanyId() {
    return companyId;
  }

  public int getCreatorId() {
    return creatorId;
  }

  public User getCreator() {
    return creator;
  }

  public String getName() {
    return name;
  }

  public LocalDateTime getDateFirstContact() {
    return dateFirstContact;
  }

  public String getStreet() {
    return street;
  }

  public int getNumber() {
    return number;
  }

  public String getBox() {
    return box;
  }

  public int getPostalCode() {
    return postalCode;
  }

  public String getMunicipality() {
    return municipality;
  }

  public void setCompanyId(int companyId) {
    Util.checkPositiveInteger(companyId);
    this.companyId = companyId;
  }

  public void setCreatorId(int creatorId) {
    Util.checkPositiveInteger(creatorId);
    this.creatorId = creatorId;
  }

  public void setCreator(User creator) {
    Util.checkNull(creator);
    this.creator = creator;
  }

  public void setName(String name) {
    Util.checkString(name);
    this.name = name;
  }

  public void setDateFirstContact(LocalDateTime dateFirstContact) {
    Util.checkLocalDateTime(dateFirstContact);
    this.dateFirstContact = dateFirstContact;
  }

  public void setStreet(String street) {
    Util.checkString(street);
    this.street = street;
  }

  public void setNumber(int number) {
    Util.checkPositiveInteger(number);
    this.number = number;
  }

  public void setBox(String box) {
    Util.isString(box);
    this.box = box;
  }

  public void setPostalCode(int postalCode) {
    Util.checkPositiveInteger(postalCode);
    this.postalCode = postalCode;
  }

  public void setMunicipality(String municipality) {
    Util.checkString(municipality);
    this.municipality = municipality;
  }

  @Override
  public void setVersion(int version) {
    this.version = version;
  }

  @Override
  public int getVersion() {

    return this.version;
  }

  @Override
  public String toString() {
    return "RealCompany [companyId=" + companyId + ", creator=" + creator + ", name=" + name
        + ", dateFirstContact=" + dateFirstContact + ", street=" + street + ", number=" + number
        + ", box=" + box + ", postalCode=" + postalCode + ", municipality=" + municipality + "]";
  }

  @Override
  public String getId() {
    return this.getClass().getName() + this.companyId;
  }
}
