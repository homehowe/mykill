package mykill;

import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import howe.mykill.dao.MyKillDao;
import howe.mykill.entity.Mykill;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class MyKillDaoTest {
	@Autowired
	private MyKillDao myKillDao;
	
	@Test
	public void reduceNumber() throws Exception {
		fail("Not yet implemented");
	}

	@Test
	public void queryById() throws Exception {
		long id = 1000;
		
		Mykill mykill = myKillDao.queryById(id);
		
		System.out.println(mykill.getName());
	}

	@Test
	public void queryAll() throws Exception {
		fail("Not yet implemented");
	}

}
