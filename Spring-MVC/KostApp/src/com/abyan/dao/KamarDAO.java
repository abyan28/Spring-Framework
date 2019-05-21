package com.abyan.dao;

import java.util.List;

import com.abyan.entity.Kamar;

public interface KamarDAO {

	public List<Kamar> getAllKamar();
	
	public List<Kamar> getKamarKosong();
	
	public Kamar getKamarById(int id);
	
	public void saveUpdateKamar(Kamar kamar);
	
	public List<Kamar> getOccupiedRooms();
}
