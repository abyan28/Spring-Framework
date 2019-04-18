package com.abyan.springmvc;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.abyan.springmvc.User;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String login()
	{
		String page = "redirect:login";
		return page;
	}
	
	@RequestMapping("/login")
	public ModelAndView showPage() {
		return new ModelAndView("login", "user", new User());
	}
	
	@RequestMapping(value = "/regist", method = RequestMethod.GET)
	public ModelAndView showForm()
	{
		return new ModelAndView("regist","user", new User());
	}
	
	@RequestMapping(value = "/home", method = RequestMethod.POST)
	public String home(@ModelAttribute("user") User user, BindingResult result, ModelMap model)
	{	
		model.addAttribute("nama", user.getNama());
		model.addAttribute("password", user.getPassword());	
		return "home";		
	}
}