package com.uros018.repository;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.uros018.model.Gender;
import com.uros018.model.Person;

@Repository
@Transactional
public class GenderRepository {

	@Autowired
	SessionFactory sessionFactory;
	
	public Gender findByNameGender(Gender gender) {
		String hql="from Gender g where g.gender =: gender";
		Session session=sessionFactory.openSession();
		Query query=session.createQuery(hql);
		query.setParameter("gender", gender.getGender());
		Gender g= (Gender) query.uniqueResult();
		session.close();
		
		return g;
		
	}
}
