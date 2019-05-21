package com.abyan.dao;

import java.util.List;
import java.time.LocalDate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.abyan.entity.Penghuni;

@Repository
public class PenghuniDAOImpl implements PenghuniDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Penghuni> getActualPenghuni() {
		Session session = sessionFactory.getCurrentSession();
		Query<Penghuni> query = session.createQuery("from Penghuni", Penghuni.class); 
		List<Penghuni> penghuni = query.getResultList();
		
		return penghuni;
	}

	@Override
	public List<Penghuni> getCheckedoutPenghuni() {
		Session session = sessionFactory.getCurrentSession();
		Query<Penghuni> query = session.createQuery("select id_number from Penghuni where is_checkedout=1 order by last_name", Penghuni.class); 
		List<Penghuni> penghuni = query.getResultList();
		
		return penghuni;
	}

	@Override
	public void saveUpdatePenghuni(Penghuni penghuni) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(penghuni);
	}

	@Override
	public Penghuni getPenghuniById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Penghuni penghuni = session.get(Penghuni.class, id);
		return penghuni;
	}

	@Override
	public List<Penghuni> getComingCheckout() {
		LocalDate tomorrow = LocalDate.now();
		tomorrow.plusDays(2);
		Session session = sessionFactory.getCurrentSession();
		Query<Penghuni> query = session.createQuery("select id_number from Penghuni where id_number.checkout_date <= :tomorrow and id_number.is_checkedout = 1 order by checkout_date", Penghuni.class); 
		query.setParameter("tomorrow", tomorrow);
		List<Penghuni> penghuni = query.getResultList();
		
		return penghuni;
	}

}
