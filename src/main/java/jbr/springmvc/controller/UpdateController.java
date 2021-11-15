package jbr.springmvc.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import jbr.springmvc.dao.UserDao;
import jbr.springmvc.model.User;
import jbr.springmvc.service.UserService;

@Controller
public class UpdateController {
	
	@Autowired
	private UserService userService;
	 
	
	@RequestMapping(value = "/admin/update/{userid}")
	public ModelAndView findStudentById(ModelAndView model, @PathVariable("userid") int userid)
			throws IOException {

		List<User> listuser = userService.findUserById(userid);
		model.addObject("listuser", listuser);
		model.setViewName("update");

		return model;
	}
	
	@RequestMapping(value = "/admin/update/", method = RequestMethod.POST)
	public ModelAndView updateStudent( @RequestParam("username") String username,
			@RequestParam("password") String password,
			@RequestParam("firstname") String firstname, @RequestParam("lastname") String lastname,
			@RequestParam("email") String email, @RequestParam("address") String address,@RequestParam("phone") String phone,@RequestParam("id") String id,
			ModelAndView mv) {

		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setFirstname(firstname);
		user.setLastname(lastname); 
		user.setEmail(email);
		user.setAddress(address);
		user.setPhone(phone);
		user.setId(id);
	

		int counter = userService.update(user);

		if (counter > 0) {
			mv.addObject("msg", "User records updated against User id: " + user.getId());
		} else {
			mv.addObject("msg", "Error- check the console log.");
		}

		mv.setViewName("update");

		return mv;
	}
}


 
//https://www.websparrow.org/spring/spring-mvc-crud-example-using-jdbctemplate-mysql

//https://dzone.com/articles/spring-mvc-example-for-user-registration-and-login-1