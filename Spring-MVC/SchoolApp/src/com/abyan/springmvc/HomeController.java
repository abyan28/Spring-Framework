package com.abyan.springmvc;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.abyan.springmvc.Siswa;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String home()
	{
		String page = "redirect:home";
		return page;
	}
	
	@RequestMapping("/home")
	public String showPage() {
		return "home";
	}
	
	@RequestMapping(value = "/regist", method = RequestMethod.GET)
	public ModelAndView showForm()
	{
		return new ModelAndView("regist","siswa", new Siswa());
	}
	
	@RequestMapping(value = "/result", method = RequestMethod.POST)
	public String resultForm(@ModelAttribute("siswa") Siswa siswa, BindingResult result, ModelMap model)
	{	
		model.addAttribute("nisn", siswa.getNisn());
		model.addAttribute("nama", siswa.getNama());
		model.addAttribute("tempatLahir", siswa.getTempatLahir());
		model.addAttribute("tanggalLahir", siswa.getTanggalLahir());
		model.addAttribute("alamat", siswa.getAlamat());
		model.addAttribute("asalSekolah", siswa.getAsalSekolah());	
		return "resultForm";		
	}
}