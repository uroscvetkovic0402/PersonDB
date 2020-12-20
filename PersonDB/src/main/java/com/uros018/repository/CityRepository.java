package com.uros018.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.uros018.model.City;

@Transactional
@Repository
public class CityRepository {

	@Autowired
	SessionFactory sessionFactory;
	
	public void save(City city) {
		
		Session session=sessionFactory.openSession();
		session.save(city);
		session.close();
	}
	
	public City findByName(City city) {
		String hql="from City c where c.city =:city";
		Session session=sessionFactory.openSession();
		Query query=session.createQuery(hql);
		query.setParameter("city", city.getCity());
		City c=(City) query.uniqueResult();
		session.close();
		
		return c;
	}
}
