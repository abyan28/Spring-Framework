package com.abyan.services;

import java.util.List;

import com.abyan.entity.Kamar;

public interface KamarService {

	public Kamar getKamarById(int id) ;
	
	public List<Kamar> getKamarKosong();
	
	public List<Kamar> getOccupiedRooms ();
	
	void saveUpdateRoom(Kamar kamar);
}
