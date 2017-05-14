package util;

import static org.junit.Assert.assertEquals;

import mockObjects.MockDalServices;
import mockObjects.MockParticipationDao;
import mockObjects.MockUnitOfWork;
import mockObjects.MockUserDao;

public class Helper {

  public void testDal(MockDalServices dal) {
    assertEquals("Some of the dal's methods were not called as expected", true, dal.validate());
  }

  public void testUnit(MockUnitOfWork unit) {
    assertEquals("Some of the unit of work's methods were not called as expected", true,
        unit.validate());
  }

  public void testUserDao(MockUserDao dao) {
    assertEquals("Some of the user dao's methods were not called as expected", true,
        dao.validate());
  }

  public void testParticipationDao(MockParticipationDao dao) {
    assertEquals("Some of the participation dao's methods were not called as expected", true,
        dao.validate());
  }

}
