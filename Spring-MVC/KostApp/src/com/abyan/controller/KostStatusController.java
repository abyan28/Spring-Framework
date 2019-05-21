package com.abyan.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.abyan.entity.Penghuni;
import com.abyan.entity.Kamar;
import com.abyan.services.KostStatusService;

@Controller
public class KostStatusController {

	@Autowired
	private KostStatusService kostStatusService;
	
	@RequestMapping("/")
	public String home(){
		return "kostStatus";
	}
	
	@GetMapping("/kostStatus")
	public String showHotelStatus(Model theModel) {

		List<Penghuni> daftarPenghuni = kostStatusService.getActualPenghuni();
		List<Kamar> daftarKamar = kostStatusService.getAllKamar();

		Integer jumlahKamar = 0;
		Integer jumlahOccupiedRooms = 0;
		Integer jumlahKamarKosong = 0;
		Integer jumlahKamarStandardKosong = 0;
		Integer jumlahKamarBisnisKosong = 0;
		Integer jumlahKamarPremiumKosong = 0;

		for(Kamar kamar : daftarKamar) {
			jumlahKamar ++;
			if(kamar.getIsOccupied()) {
				jumlahOccupiedRooms ++;	
			}else {
				jumlahKamarKosong ++;
				if(kamar.getStandard().equals("standard")) {
					jumlahKamarStandardKosong ++;
				}else if(kamar.getStandard().equals("business")) {
					jumlahKamarBisnisKosong ++;
				}else {
					jumlahKamarPremiumKosong ++;
				}
			}

		}

		Integer jumlahPenghuni = 0;
		Integer upcommingCheckOuts = 0;

		for(Penghuni penghuni : daftarPenghuni) {
			if(!penghuni.getIsCheckedout()) {
				jumlahPenghuni++;
			}else {
				if(penghuni.getCheckoutDate().isEqual(LocalDate.now()) || penghuni.getCheckoutDate().isBefore(LocalDate.now())) {
					upcommingCheckOuts++;
				}
			}
		}
		theModel.addAttribute("jumlahKamar", jumlahKamar);
		theModel.addAttribute("jumlahOccupiedRooms", jumlahOccupiedRooms);
		theModel.addAttribute("jumlahKamarKosong", jumlahKamarKosong);
		theModel.addAttribute("jumlahKamarStandardKosong", jumlahKamarStandardKosong);
		theModel.addAttribute("jumlahKamarBisnisKosong", jumlahKamarBisnisKosong);
		theModel.addAttribute("jumlahKamarPremiumKosong", jumlahKamarPremiumKosong);
		theModel.addAttribute("jumlahPenghuni", jumlahPenghuni);
		theModel.addAttribute("upcommingCheckOuts", upcommingCheckOuts);

		return "kostStatus";
	}
}
