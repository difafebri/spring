package com.bca.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bca.dao.KartuKreditDaoImpl;
import com.bca.model.KartuKredit;
import com.bca.model.Tagihan;
import com.bca.model.Transaksi;

@Controller
public class KartuKreditController {
	@Autowired
	KartuKreditDaoImpl kk;

	@RequestMapping(value="/kartukredit",method = RequestMethod.GET)
	public ModelAndView getKartuKredit(HttpSession session) {
		return new ModelAndView("kartukredit", "command", new KartuKredit());
		// command is a reserved request attribute name, now use <form> tag to show
		// object data
	}

	@RequestMapping(value = "/tagihan", method = RequestMethod.GET)
	public ModelAndView getTagihan(HttpSession session) {
		Tagihan gt = kk.getTagihan(session.getAttribute("user").toString());
		List<Transaksi> list = kk.getTransaksi(session.getAttribute("user").toString(), 1);
		System.out.println("Session saat in: " + session.getAttribute("user").toString());
		ModelAndView mv = new ModelAndView("tagihan", "command", new Tagihan());
		mv.addObject("tagihanBulanLalu", gt);
		mv.addObject("listTranBulanLalu", list);
		return mv;
	}

	@RequestMapping(value = "/tagihanDibayar", method = RequestMethod.POST)
	public ModelAndView finishBayar(@ModelAttribute("tagihan") Tagihan tagihan, HttpSession session) {
		System.out.println("tagihan yg dibayar = " + tagihan.getPaid());
		ModelAndView mv = new ModelAndView();
		int rowAffected = kk.bayarTagihan(session.getAttribute("user").toString(), tagihan.getPaid());
		if (rowAffected >= 1) {
			mv.setViewName("saved");
			mv.addObject("yeay", "hey");
		} else {
			mv.setViewName("notsaved");
			mv.addObject("nay", "no.");
		}
		return mv;
	}

	@RequestMapping("/transaksi")
	public ModelAndView getTransaksi(HttpSession session) {
		List<Transaksi> list = kk.getTransaksi(session.getAttribute("user").toString(), 0);
		System.out.println("Session saat in: " + session.getAttribute("user").toString());
		ModelAndView mv = new ModelAndView("transaksi", "command", new Transaksi());
		mv.addObject("listTran", list);
		return mv;
	}
}
