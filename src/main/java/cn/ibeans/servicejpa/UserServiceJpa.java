package cn.ibeans.servicejpa;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import cn.ibeans.daojpa.UserDao;
import cn.ibeans.web.model.User;

@Component
public class UserServiceJpa {
	private static Logger logger = Logger.getLogger(UserServiceJpa.class);
	@Autowired
	private UserDao userDao;
	
	@Transactional(readOnly=false)
	public void saveUser(User user){
		userDao.save(user);
		logger.debug(user.getUsername()+",保存成功！");
	}
	public User checkUserWithId(String id) {
		User findByName = userDao.findOne(id);
		return findByName;
	}
	public User checkUserWithUserName(String username) {
		User findByName = userDao.findByUsername(username);
		return findByName;
	}
	public User checkUserWithUserNameByQueryAnnotation(String username) {
		User findByName = userDao.findUserByQueryAnnotation(username);
		return findByName;
	}
}
