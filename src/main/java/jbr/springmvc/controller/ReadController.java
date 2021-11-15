package jbr.springmvc.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

 
import jbr.springmvc.model.User;
import jbr.springmvc.service.UserService;


@Controller
public class ReadController {
	@Autowired
	private UserService userService;
	

	@RequestMapping(value = "/admin/read")
	public ModelAndView readStudent(ModelAndView model) throws IOException {

		List<User> listuser = userService.read();
		model.addObject("listuser", listuser);
		model.setViewName("read");

		return model;
	}

}
