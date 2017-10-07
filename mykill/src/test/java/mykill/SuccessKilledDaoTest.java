package mykill;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import howe.mykill.dao.SuccessKilledDao;
import howe.mykill.entity.SuccessKill;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class SuccessKilledDaoTest {
	@Autowired
	private SuccessKilledDao successKilledDao;
	
	@Test
	public void insertSuccessKilled() throws Exception {
		int insertCount = successKilledDao.insertSuccessKilled(1000, 18888888888L);
		
		System.out.println("success:" + insertCount);
	}

	@Test
	public void queryByIdWithmykill() throws Exception {
		SuccessKill successKill = successKilledDao.queryByIdWithMykill(1000, 18888888888L);
		
		System.out.println(successKill.getSeckill());
	}

}
