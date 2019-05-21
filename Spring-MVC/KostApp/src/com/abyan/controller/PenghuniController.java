package com.abyan.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
//import java.time.LocalDate;
//import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;
import java.util.List;

//import javax.mail.MessagingException;
//import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.servlet.ModelAndView;

import com.abyan.entity.Penghuni;
import com.abyan.entity.Kamar;
import com.abyan.services.PenghuniService;
//import com.abyan.services.KamarService;

@Controller
@RequestMapping("/penghuni")
public class PenghuniController {

	@Autowired
	private PenghuniService penghuniService;
	
	@GetMapping("/list")
	public String guestList(Model theModel) {

		List<Penghuni> daftarPenghuni = penghuniService.getActualPenghuni();
		theModel.addAttribute("daftarPenghuni", daftarPenghuni);

		return "daftarPenghuni";
	}
	
	@GetMapping("/showTambahPenghuni")
	public String showAddGuest(Model theModel) {

		Penghuni penghuni = new Penghuni();
		List<Kamar> kamarKosong = penghuniService.getKamarKosong();
		Kamar firstRoomOnList = kamarKosong.get(0);
		kamarKosong.remove(firstRoomOnList);
		LinkedHashMap<String, Kamar> vacantRoomsMap = populateRoomsMap(kamarKosong);

		theModel.addAttribute("guest", penghuni);
		theModel.addAttribute("roomsMap", vacantRoomsMap);
		theModel.addAttribute("selectedRoom", firstRoomOnList); //the room to be shown as first on the list

		return "formTambahPenghuni";
	}
	
	@PostMapping("/simpanPenghuni")
	public String saveGuest (@ModelAttribute("penghuni") Penghuni penghuni, BindingResult bindingResult, Model theModel) {

		if(bindingResult.hasErrors()) {
			List<Kamar> kamarKosong = penghuniService.getKamarKosong();
			Kamar firstRoomOnList = kamarKosong.get(0);
			LinkedHashMap<String, Kamar> vacantRoomsMap = populateRoomsMap(kamarKosong);
			theModel.addAttribute("roomsMap", vacantRoomsMap);
			theModel.addAttribute("selectedRoom", firstRoomOnList);

			return "formTambahPenghuni";

		}else {
			penghuni.getKamar().setOccupied(true);
			penghuni.setCheckinDate(LocalDate.now());
			penghuniService.saveUpdateKamar(penghuni.getKamar());
			penghuniService.saveUpdatePenghuni(penghuni);
			return "redirect:/penghuni/list";
		}
	}
	
	@GetMapping("/checkout")
	public String checkoutGuest(@RequestParam("guestId") int theId, Model theModel) {

		Penghuni theGuest = penghuniService.getPenghuniById(theId);
		Kamar theRoom = penghuniService.getKamarById(theGuest.getKamar().getId());
		LocalDate localDate = LocalDate.now();
		localDate.format(DateTimeFormatter.ISO_LOCAL_DATE);

		theGuest.setCheckoutDate(localDate);
		theGuest.setCheckedout(true);
		theGuest.setKamar(null);
		theGuest.setLastCheckedoutRoom(theRoom);
		theRoom.getOccupants().remove(theGuest);
		if(theRoom.getOccupants().size() == 0) {
			theRoom.setOccupied(false);
		}

		penghuniService.saveUpdatePenghuni(theGuest);
		penghuniService.saveUpdateKamar(theRoom);

		return "redirect:/penghuni/list";
	}
	
	@GetMapping("/update")
	public String udpateGuest(@RequestParam("guestId") int theId, Model theModel) {
		Penghuni theGuest = penghuniService.getPenghuniById(theId);

		List<Kamar> vacantRooms = penghuniService.getKamarKosong();
		Kamar selectedRoom = theGuest.getKamar(); //previously selected room to be shown as first on the list
		vacantRooms.remove(selectedRoom);
		LinkedHashMap<String, Kamar> vacantRoomsMap = populateRoomsMap(vacantRooms);



		theModel.addAttribute("guest", theGuest);
		theModel.addAttribute("roomsMap", vacantRoomsMap);
		theModel.addAttribute("selectedRoom", selectedRoom);
		return "formTambahPenghuni";
	}
	
	@GetMapping("/checkin")
	public String checkinGuestToSpecificRoom(@RequestParam("roomId") int theRoomId, Model theModel) {
		Penghuni theGuest = new Penghuni();
		Kamar selectedRoom = penghuniService.getKamarById(theRoomId);
		theModel.addAttribute("guest", theGuest);
		theModel.addAttribute("selectedRoom", selectedRoom);
		return "formTambahPenghuni";
	}
	
	@GetMapping("/archivedGuestsList")
	public String archivedGuests(Model theModel) {

		List<Penghuni> guestList = penghuniService.getArsipPenghuni();
		theModel.addAttribute("daftarPenghuni", guestList);

		return "archivedGuestsList";
	}
	
	@GetMapping("/checkInToOccupiedRoom")
	public String checkInToOccupiedRoom(Model theModel) {

		Kamar kamar = null;
		Penghuni penghuni = new Penghuni();
		LinkedHashMap<String, Kamar> occupiedRoomsMap = null;
		List<Kamar> occupiedRooms = penghuniService.getOccupiedRooms();
		if(!occupiedRooms.isEmpty()) {
			kamar = occupiedRooms.get(0);
			occupiedRoomsMap = populateRoomsMap(occupiedRooms);
		}


		theModel.addAttribute("selectedRoom", kamar); //the room to be shown as first on the list
		theModel.addAttribute("guest", penghuni);
		theModel.addAttribute("roomsMap", occupiedRoomsMap);

		return "formTambahPenghuni";
	}
	
	private LinkedHashMap<String, Kamar> populateRoomsMap(List<Kamar> kamars){

		if(kamars == null || kamars.size() == 0) {
			kamars.add(new Kamar(0, "Tidak ada kamar kosong", true, null));
		}
		LinkedHashMap<String, Kamar> roomsMap = new LinkedHashMap<String, Kamar>();
		for(Kamar kamar : kamars) {
			roomsMap.put(Integer.toString(kamar.getId()), kamar);
		}
		return roomsMap;
	}
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}
}
