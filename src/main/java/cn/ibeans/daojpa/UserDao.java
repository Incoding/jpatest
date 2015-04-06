package cn.ibeans.daojpa;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import cn.ibeans.web.model.User;

public interface UserDao extends CrudRepository<User, String> {
	public User findByUsername(String username);

	@Query("select u from User u where u.username=:username")
	public User findUserByQueryAnnotation(@Param("username") String username);
}
