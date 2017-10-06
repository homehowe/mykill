package mykill;

import static org.junit.Assert.fail;

import java.util.Date;
import java.util.List;

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
		Date killTime = new Date();
		int updateCount = myKillDao.reduceNumber(1000, killTime);
		
		System.out.println("success:" + updateCount);
	}

	@Test
	public void queryById() throws Exception {
		long id = 1000;
		
		Mykill mykill = myKillDao.queryById(id);
		
		System.out.println(mykill.getName());
	}

	@Test
	public void queryAll() throws Exception {
		List<Mykill> mykills = myKillDao.queryAll(0, 1000);
		
		for(Mykill mykill : mykills) {
			System.out.println(mykill);
		}
	}

}
