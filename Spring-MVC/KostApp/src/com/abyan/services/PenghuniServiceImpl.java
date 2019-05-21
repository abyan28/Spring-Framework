package com.abyan.services;

import java.util.List;
//import java.io.File;
//import java.io.IOException;
import java.time.LocalDate;
//import java.util.LinkedList;

//import javax.mail.MessagingException;
//import javax.swing.JOptionPane;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.itextpdf.text.DocumentException;

import com.abyan.entity.Penghuni;
import com.abyan.entity.Kamar;
import com.abyan.dao.PenghuniDAO;
import com.abyan.dao.KamarDAO;
//import com.abyan.services.helper.PDFPrinter;
//import com.abyan.services.helper.EmailMessage;

import java.time.temporal.ChronoUnit;

@Service
public class PenghuniServiceImpl implements PenghuniService {

	@Autowired
	private PenghuniDAO penghuniDAO;
	
	@Autowired
	private KamarDAO kamarDAO;
	
	@Override
	@Transactional
	public List<Penghuni> getActualPenghuni() {
		return penghuniDAO.getActualPenghuni();
	}

	@Override
	@Transactional
	public List<Penghuni> getArsipPenghuni() {
		return penghuniDAO.getCheckedoutPenghuni();
	}

	@Override
	@Transactional
	public List<Kamar> getKamarKosong() {
		return kamarDAO.getKamarKosong();
	}

	@Override
	@Transactional
	public List<Kamar> getOccupiedRooms() {
		return kamarDAO.getOccupiedRooms();
	}

	@Override
	@Transactional
	public void saveUpdatePenghuni(Penghuni penghuni) {
		penghuniDAO.saveUpdatePenghuni(penghuni);
	}

	@Override
	@Transactional
	public void saveUpdateKamar(Kamar kamar) {
		kamarDAO.saveUpdateKamar(kamar);
	}

	@Override
	@Transactional
	public Kamar getKamarById(int id) {
		return kamarDAO.getKamarById(id);
	}

	@Override
	@Transactional
	public Penghuni getPenghuniById(int id) {
		return penghuniDAO.getPenghuniById(id);
	}

	@Override
	public int getNightsNumber(Penghuni penghuni) {
		LocalDate checkIn = penghuni.getCheckinDate();
		LocalDate checkOut;
		
		if(penghuni.getIsCheckedout()) {
			checkOut = penghuni.getCheckoutDate();
		}else {
			checkOut = LocalDate.now();
		}
		
		int nightsNumber = (int) ChronoUnit.DAYS.between(checkIn, checkOut);
		return nightsNumber;
	}

}
