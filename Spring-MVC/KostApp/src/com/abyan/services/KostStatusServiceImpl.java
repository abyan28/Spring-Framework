package com.abyan.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abyan.entity.Penghuni;
import com.abyan.entity.Kamar;
import com.abyan.dao.PenghuniDAO;
import com.abyan.dao.KamarDAO;

@Service
public class KostStatusServiceImpl implements KostStatusService {

	@Autowired
	private KamarDAO kamarDAO; 
	
	@Autowired
	private PenghuniDAO penghuniDAO;
	
	@Override
	public List<Kamar> getAllKamar() {
		return kamarDAO.getAllKamar();
	}

	@Override
	@Transactional
	public List<Penghuni> getActualPenghuni() {
		return penghuniDAO.getActualPenghuni();
	}

}
