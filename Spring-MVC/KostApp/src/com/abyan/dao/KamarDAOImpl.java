package com.abyan.dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.abyan.entity.Kamar;

@Repository
public class KamarDAOImpl implements KamarDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Kamar> getAllKamar() {
		Session session = sessionFactory.getCurrentSession();
		Query<Kamar> query = session.createQuery("from Kamar order by number", Kamar.class);
		List<Kamar> kamar = query.getResultList();
		
		return kamar;
	}

	@Override
	public List<Kamar> getKamarKosong() {
		Session session = sessionFactory.getCurrentSession();
		Query<Kamar> query = session.createQuery("select number from Kamar where is_occupied = 0 order by number", Kamar.class);
		List<Kamar> kamar = query.getResultList();
		return kamar;
	}

	@Override
	public Kamar getKamarById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Kamar kamar = session.get(Kamar.class, id);
		Hibernate.initialize(kamar.getOccupants()); //otherwise lazy fetch excpetion - this object would not be available outside of transaction
		return kamar;
	}

	@Override
	public void saveUpdateKamar(Kamar kamar) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(kamar);
	}

	@Override
	public List<Kamar> getOccupiedRooms() {
		Session session = sessionFactory.getCurrentSession();
		Query<Kamar> query = session.createQuery("select number from Kamar where is_Occupied = 1 order by number", Kamar.class);
		List<Kamar> kamar = query.getResultList();
		kamar.forEach(r -> Hibernate.initialize(r.getOccupants())); //otherwise lazy fetch excpetion - this object would not be available outside of transaction)
		return kamar;
	}

}
