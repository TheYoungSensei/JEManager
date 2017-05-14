package mockObjects;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import biz.Company;
import biz.Contact;
import biz.Dto;
import persistence.dao.CompanyDao;
import util.SetValidator;

public class MockCompanyDao extends SetValidator implements CompanyDao {

  /**
   * Empty constructor.
   * 
   * @author alexandre.maniet
   */
  public MockCompanyDao() {
    super();
  }

  /**
   * @param expectedMethodsCalls expected methods.
   * @author alexandre.maniet
   */
  public MockCompanyDao(Collection<String> expectedMethodsCalls) {
    super(expectedMethodsCalls);
  }

  @Override
  public int delete(Dto dto) {
    addCurrentMethodToSet();
    return 0;
  }

  @Override
  public List<Company> getCompaniesToInvite() {
    addCurrentMethodToSet();
    return Arrays.asList(new MockCompany());
  }

  @Override
  public Company getCompanyById(int idCompany) {
    addCurrentMethodToSet();
    return new MockCompany();
  }

  @Override
  public List<Contact> getMyContacts(Company company) {
    addCurrentMethodToSet();
    return Arrays.asList(new MockContact());
  }

  @Override
  public int insert(Dto dto) {
    addCurrentMethodToSet();
    return 0;
  }

  @Override
  public List<Company> selectAll() {
    addCurrentMethodToSet();
    return Arrays.asList(new MockCompany());
  }

  @Override
  public int update(Dto dto) {
    addCurrentMethodToSet();
    return 0;
  }

}
