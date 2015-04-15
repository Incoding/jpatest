package cn.ibeans.daojpa;
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.ibeans.web.model.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:applicationContext.xml")
@ActiveProfiles("development")
public class TestUserDao {
	@Autowired
	private UserDao	dao;
	
	@Test
	public void testFindOne() throws Exception {
		User findOne = dao.findOne("1");
		System.out.println(findOne);
		assertNotNull(findOne);
	}
	@Test
	public void findOne() throws Exception {
		User user = dao.findUserByQueryAnnotation("admin");
		System.out.println(user);
		assertNotNull(user);
	}
}
