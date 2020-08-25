package com.bca.controller;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bca.dao.PembelianDaoImpl;
import com.bca.model.Pembelian;


@Controller
public class PembelianController {
	@Autowired
	PembelianDaoImpl beli;
	
	@RequestMapping("/pembelian")
	public ModelAndView getPembelianPage() {
		return new ModelAndView("pembelian", "command", new Pembelian());
	}
	 
	@RequestMapping(value = "/prosesPembelian", method = RequestMethod.POST)
	public ModelAndView processPembelian(@ModelAttribute("pembelian") Pembelian pembelian, HttpSession session) {
		int rows = beli.save(pembelian);
		System.out.println("Pembelian sesi: "+session.getAttribute("user"));
		if(rows>=1) {		
			ModelAndView mv = new ModelAndView();
			mv.setViewName("saved");
			mv.addObject("yeay", "ey");
			return mv;
		}else {
			ModelAndView mv = new ModelAndView();
			mv.setViewName("notsaved");
			mv.addObject("nay", "nay");
			return mv;
		}
	}
}
