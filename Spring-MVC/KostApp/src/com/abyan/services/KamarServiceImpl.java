package com.abyan.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abyan.dao.KamarDAO;
import com.abyan.entity.Kamar;

@Service
public class KamarServiceImpl implements KamarService {

	@Autowired
	private KamarDAO kamarDAO;
	
	@Override
	@Transactional
	public Kamar getKamarById(int id) {
		return kamarDAO.getKamarById(id);
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
	public void saveUpdateRoom(Kamar kamar) {
		kamarDAO.saveUpdateKamar(kamar);
	}

}
