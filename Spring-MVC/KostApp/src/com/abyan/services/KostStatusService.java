package com.abyan.services;

import java.util.List;

import com.abyan.entity.Penghuni;
import com.abyan.entity.Kamar;

public interface KostStatusService {

	public List<Kamar> getAllKamar();
	public List<Penghuni> getActualPenghuni();
}