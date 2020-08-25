package com.bca.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bca.dao.UserDaoImpl;
import com.bca.model.User;
@Controller

public class LoginController {
	@Autowired
	UserDaoImpl udi=null;
	@Autowired
	private HttpSession session;
	
	@RequestMapping("/login")
	public ModelAndView getLoginPage(@RequestParam(value="errors", defaultValue = "") String error) {
		if (error=="true") {
			System.out.println("error bro maap");
			ModelAndView mv = new ModelAndView("login", "command", new User());
			mv.addObject("errors", "denied");
			return mv;
		}else {
			System.out.println("masuk sini");
			return new ModelAndView("login", "command", new User());
		}
	}
 
	@RequestMapping(value = "/processLogin", method = RequestMethod.POST)
	public ModelAndView processLogin(@ModelAttribute("login") User login, HttpSession session) {
		System.out.println(udi.validateUser(login));
		if (udi.validateUser(login)!=null){
			System.out.println("logged in");
			ModelAndView mv = new ModelAndView();
			mv.setViewName("success");
			session.setAttribute("user", (String) login.getUsername());
			session.setAttribute("pw", (String) login.getPw());
			this.session=session;
			return mv;
		} else {
			System.out.println("NOT logged in");
			ModelAndView mv = new ModelAndView("redirect:login","command",new User());
			mv.addObject("errors","true");
			return mv;
		}
	}

	@RequestMapping("/logout")
	public ModelAndView logout(HttpSession session) {
		session.removeAttribute("user");
		session.removeAttribute("pw");
		return new ModelAndView("redirect:login", "command", new User());
	}
}
