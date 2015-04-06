package cn.ibeans.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import cn.ibeans.dao.UserDao;
import cn.ibeans.web.model.User;

@Repository
public class UserDaoImpl implements UserDao {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public User findByName(String name) {
		String sql = "select * from i_user where username=:username";
		 Query createNativeQuery = em.createNativeQuery(sql, User.class);
		 createNativeQuery.setParameter("username", name);
		 Object singleResult = createNativeQuery.getSingleResult();
		return (User) singleResult;
	}

	@Override
	public User findByLoginName(String loginName) {
		return null;
	}

	@Override
	public void saveOrUpdate(User user) {
		em.persist(user);
	}

}
