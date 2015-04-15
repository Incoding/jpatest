package cn.ibeans.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.ibeans.servicejpa.UserServiceJpa;
import cn.ibeans.web.model.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:applicationContext.xml")
public class TestUserService {
	
	@Autowired
	private UserServiceJpa jpa;
	
	@Test
	public void testCheckUserWithId() throws Exception {
		String id = "1";
		User checkUserWithId = jpa.checkUserWithId(id);
		System.out.println(checkUserWithId);
		assertNotNull(checkUserWithId);
	}

}
