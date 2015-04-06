package cn.ibeans.dao;

import cn.ibeans.web.model.User;

public interface UserDao {

	User findByName(String name);

	User findByLoginName(String loginName);
	
	void saveOrUpdate(User user);
}
