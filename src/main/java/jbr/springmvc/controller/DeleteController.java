package jbr.springmvc.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import jbr.springmvc.service.UserService;

@Controller
public class DeleteController {
	
 
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/admin/delete/{userid}")
	public ModelAndView deleteStudentById(ModelAndView mv, @PathVariable("userid") int userid)
			throws IOException {

		int counter = userService.delete(userid);

		if (counter > 0) {
			mv.addObject("msg", "User records deleted against User id: " + userid);
		} else {
			mv.addObject("msg", "Error- check the console log.");
		}

		mv.setViewName("delete");

		return mv;

 }
}



//https://www.websparrow.org/spring/spring-mvc-crud-example-using-jdbctemplate-mysql

//https://dzone.com/articles/spring-mvc-example-for-user-registration-and-login-1