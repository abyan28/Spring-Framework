package com.abyan.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abyan.entity.Penghuni;
import com.abyan.dao.PenghuniDAO;

@Service
public class ComingCheckoutServiceImpl implements ComingCheckoutService {

	@Autowired
	private PenghuniDAO penghuniDAO;
	
	@Override
	@Transactional
	public List<Penghuni> getComingCheckout() {
		return penghuniDAO.getComingCheckout();
	}

}
