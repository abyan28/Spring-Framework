package com.abyan.controller;

import java.util.List;
//import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.abyan.entity.Penghuni;
import com.abyan.services.ComingCheckoutService;

@Controller
@RequestMapping("/comingCheckout")
public class ComingCheckoutController {

	@Autowired
	private ComingCheckoutService comingCheckoutService;
	
	@GetMapping("/list")
	public String comingCheckoutList(Model theModel) {

		List <Penghuni> comingCheckout = comingCheckoutService.getComingCheckout();
		
		theModel.addAttribute("daftarPenghuni", comingCheckout);
		return "daftarPenghuni";
	}
}
