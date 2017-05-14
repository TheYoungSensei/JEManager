package ucc;

import java.util.List;
import java.util.stream.Collectors;

import biz.Company;
import biz.CompanyDto;
import biz.ContactDto;
import persistence.DalServices;
import persistence.UnitOfWork;
import persistence.dao.CompanyDao;
import util.Util;

public class CompanyUccImpl implements CompanyUcc {

  private CompanyDao companyDao;
  private UnitOfWork unit;
  private DalServices dal;

  /**
   * @author Maniet.Alexandre
   * @param companyDao The ucc's associated dao
   * @param unit an instance of unitOfWork needed to do insert, update and delete.
   */
  public CompanyUccImpl(CompanyDao companyDao, UnitOfWork unit, DalServices dal) {
    this.companyDao = companyDao;
    this.unit = unit;
    this.dal = dal;
  }

  @Override
  public List<CompanyDto> getAllCompanies() {
    dal.startTransaction();
    List<CompanyDto> list =
        companyDao.selectAll().stream().map(c -> (CompanyDto) c).collect(Collectors.toList());
    dal.commit();
    return list;
  }

  @Override
  public CompanyDto getCompanyById(int idCompany) {
    dal.startTransaction();
    CompanyDto toReturn = companyDao.getCompanyById(idCompany);
    if (toReturn == null) {
      dal.rollback();
      return null;
    }
    dal.commit();
    return toReturn;
  }

  @Override
  public List<CompanyDto> getCompaniesToInvite() {
    dal.startTransaction();
    List<CompanyDto> list = companyDao.getCompaniesToInvite().stream().map(c -> (CompanyDto) c)
        .collect(Collectors.toList());
    dal.commit();
    return list;
  }

  @Override
  public CompanyDto addCompany(CompanyDto companyDto) {
    unit.startTransaction();
    if (companyDto == null) {
      unit.rollBack();
      throw new IllegalArgumentException();
    }
    Company company = (Company) companyDto;
    unit.addInsert(company);
    unit.commit();
    return company;
  }

  @Override
  public List<ContactDto> getMyContacts(CompanyDto companyDto) {
    Util.checkNull(companyDto);
    dal.startTransaction();
    List<ContactDto> list = companyDao.getMyContacts((Company) companyDto).stream()
        .map(c -> (ContactDto) c).collect(Collectors.toList());
    dal.commit();
    return list;
  }

}
