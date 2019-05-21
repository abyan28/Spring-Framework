package com.abyan.dao;

import java.util.List;

import com.abyan.entity.Penghuni;

public interface PenghuniDAO {

	public List<Penghuni> getActualPenghuni();
	
	public List<Penghuni> getCheckedoutPenghuni();
	
	public void saveUpdatePenghuni(Penghuni penghuni);
	
	public Penghuni getPenghuniById(int id);
	
	public List<Penghuni> getComingCheckout();
}
