package com.uros018.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.uros018.model.SocialNumber;

@Transactional
@Repository
public class SocialNumberRepository {

	@Autowired
	SessionFactory sessionFactory;
	
	public void save(SocialNumber socialNumber) {
		Session session=sessionFactory.openSession();
		session.save(socialNumber);
		session.close();
	}
}
