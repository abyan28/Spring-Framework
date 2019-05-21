package com.abyan.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.abyan.entity.Penghuni;
import com.abyan.entity.Kamar;
import com.abyan.services.KamarService;

@Controller
@RequestMapping("/kamar")
public class KamarController {

	@Autowired
	private KamarService kamarService;
	
	@GetMapping("/list")
	public String roomList(Model theModel) {
		
		List <Kamar> kamarKosong = kamarService.getKamarKosong();
		theModel.addAttribute("daftarKamar", kamarKosong);
		return "daftarKamar";
	}
	
	@GetMapping("/occupiedRoomlist")
	public String occupiedRoomList(Model theModel) {
		
		List <Kamar> occupiedRooms = kamarService.getOccupiedRooms();
		theModel.addAttribute("daftarKamar", occupiedRooms);
		return "occupiedRoomList";
	}
	
	@GetMapping("/checkout")
	public String checkoutRoom (@RequestParam("roomId") Integer theRoomId) {
		System.out.println("I am mapped!!!");
		Kamar kamar = kamarService.getKamarById(theRoomId);
		List<Penghuni> occupants = kamar.getOccupants();
		LocalDate localDate = LocalDate.now();
		localDate.format(DateTimeFormatter.ISO_LOCAL_DATE);
		
		for(Penghuni penghuni : occupants) {
			System.out.println(penghuni.getFirstName());
			penghuni.setCheckedout(true);
			penghuni.setCheckoutDate(localDate);
			kamar.setOccupants(null);
			kamar.setOccupied(false);

		}
		kamarService.saveUpdateRoom(kamar);
		return "redirect:/kamar/occupiedRoomlist";
	}
}
