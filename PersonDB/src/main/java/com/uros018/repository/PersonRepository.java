package com.uros018.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.uros018.model.Person;

@Transactional
@Repository
public class PersonRepository {

	@Autowired
	SessionFactory sessionFactory;
	
	public void save(Person person) {
		
		Session session=sessionFactory.openSession();
		session.save(person);
		session.close();
		
	
	}
}
