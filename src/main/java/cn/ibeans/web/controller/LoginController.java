package cn.ibeans.web.controller;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import cn.ibeans.service.UserService;
import cn.ibeans.servicejpa.UserServiceJpa;
import cn.ibeans.web.model.User;

@SuppressWarnings("serial")
@Controller
@RequestMapping(value="/user")
public class LoginController extends HttpServlet{
	private static Logger log = Logger.getLogger(LoginController.class);
	
	@Autowired
	private UserService userService;
	
	@Autowired 
	private UserServiceJpa userServiceJpa;
	

	//@RequestMapping(value="/login")	//如果类级别上已有映射地址（/user），此处的完整请求地址是/user/login
	public String doLogin(Model model,Object loginForm){
		//model.addAttribute("username",username);	//model被用来封装数据，向前台传递
		WebApplicationContext context = ContextLoader.getCurrentWebApplicationContext();
		ServletContext sc = context.getServletContext();
		
		return "/welcome";
	}
	
	@RequestMapping(value="/login")
	public String login(@ModelAttribute User user,Model model){
		log.info(user.getUsername());
		model.addAttribute(user);
		return "/welcome";
	}
	@RequestMapping(value="/findUser")
	public String login(String username,Model model){
		User checkUser = userService.checkUser(username);
		if(checkUser != null) {
			model.addAttribute(checkUser);
		}
		return "/welcome";
	}
	
	@RequestMapping(value="/save")
	public String save(@ModelAttribute User user,Model model){
		log.info(user.getUsername());
		userService.saveUser(user);
		model.addAttribute(user);
		return "/welcome";
	}
	@RequestMapping(value="/savejpa")
	public String savejpa(@ModelAttribute User user,Model model){
		log.info(user.getUsername());
		userServiceJpa.saveUser(user);
		model.addAttribute(user);
		return "/welcome";
	}
	@RequestMapping(value="/findUserJpa")
	public String loginJpa(String id,Model model){
		User checkUser = userServiceJpa.checkUserWithId(id);
		if(checkUser != null) {
			model.addAttribute(checkUser);
		}
		return "/welcome";
	}
	/**根据方法名字查询
	 * @param username
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/findByUsernameJpa")
	public String findByUsernameJpa(String username,Model model){
		User checkUser = userServiceJpa.checkUserWithUserName(username);
		if(checkUser != null) {
			model.addAttribute(checkUser);
		}
		return "/welcome";
	}
	/**query注解,使用jpql语句查询
	 * @param username
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/findByUsernameQueryAnnotation")
	public String findByUsernameQueryAnnotation(String username,Model model){
		User checkUser = userServiceJpa.checkUserWithUserNameByQueryAnnotation(username);
		if(checkUser != null) {
			model.addAttribute(checkUser);
		}
		return "/welcome";
	}
}
