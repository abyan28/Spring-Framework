package com.abyan.services;

//import javax.mail.MessagingException;

import com.abyan.entity.Penghuni;
import com.abyan.entity.Kamar;

import java.util.List;

public interface PenghuniService {

	public List<Penghuni> getActualPenghuni ();
	public List<Penghuni> getArsipPenghuni ();
	public List<Kamar> getKamarKosong();
	public List<Kamar> getOccupiedRooms();
	public void saveUpdatePenghuni(Penghuni penghuni);
	public void saveUpdateKamar(Kamar kamar);
	public Kamar getKamarById(int id);
	public Penghuni getPenghuniById(int id);
	public int getNightsNumber(Penghuni penghuni);
}
