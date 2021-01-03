package com.uros018.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.uros018.model.DateMap;
import com.uros018.model.State;

@Transactional
@Repository
public class DateRepository {

	@Autowired
	SessionFactory sessionFactory;
	
	public void save(DateMap date) {
		Session session= sessionFactory.openSession();
		session.save(date);
		session.close();
	}
	
	public DateMap findByDate(DateMap date) {
		String hql="from DateMap dm where dm.date = :date";
		
		Session session=sessionFactory.openSession();
		Query query=session.createQuery(hql);
		query.setParameter("date", date.getDate());
		DateMap dm= (DateMap) query.uniqueResult();
		session.close();
		
		return dm;
	}
}
