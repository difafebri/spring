package com.bca.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bca.dao.UserDaoImpl;
import com.bca.model.User;

@Controller
public class AdminController {
	@Autowired
	UserDaoImpl udi;
	//@Autowired
	//private HttpSession session;
	
	@RequestMapping("/administrasi")
	public ModelAndView getAdministrasi(HttpSession session) {
		return new ModelAndView("administrasi","command", new User());
	}	
	
	@RequestMapping("/gantipw")
	public ModelAndView getGantipwPage(HttpSession session) {
		String passwordLama = session.getAttribute("pw").toString();
		ModelAndView mv = new ModelAndView("gantipw", "command", new User());
		mv.addObject("passwordLama", passwordLama);
		return mv;
	}
	
	@RequestMapping("/gantibahasa")
	public ModelAndView getGantibahasaPage() {
		return new ModelAndView("gantibahasa", "command", new User());
	}
	
	@RequestMapping(value = "/prosesGantipw", method = RequestMethod.POST)
	public ModelAndView prosesGantiPassword(@ModelAttribute("user") User user, HttpSession session) {
		System.out.println(user.getUsername()+ user.getPw());
		udi.gantiPassword(user);
		System.out.println("TEST ganti password INI DAH LEWAT");
		session.setAttribute("pw", user.getPw());
		return getGantipwPage(session);
	}
}
