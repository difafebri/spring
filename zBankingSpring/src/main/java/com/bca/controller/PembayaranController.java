package com.bca.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bca.dao.PembayaranDaoImpl;
import com.bca.model.Pembayaran;
import com.bca.model.Pembelian;

@Controller
public class PembayaranController {
	@Autowired
	PembayaranDaoImpl bayar;
	
	@RequestMapping("/pembayaran")
	public ModelAndView getPembayaranPage() {
		System.out.println("INI PEMBAYARAN");
		return new ModelAndView("pembayaran", "command", new Pembayaran());
	}
	
	@RequestMapping(value = "/prosesPembayaran", method = RequestMethod.POST)
	public ModelAndView processPembayaran(@ModelAttribute("pembayaran") Pembayaran pembayaran, HttpSession session) {
		int rows = bayar.save(pembayaran);
		System.out.println("Pembayarannnn sesi: "+session.getAttribute("user"));
		if(rows>=1) {		
			ModelAndView mv = new ModelAndView();
			mv.setViewName("saved");
			mv.addObject("yeay", "ye");
			return mv;
		}else {
			ModelAndView mv = new ModelAndView();
			mv.setViewName("notsaved");
			mv.addObject("nay", "no");
			return mv;
		}
	}
}
