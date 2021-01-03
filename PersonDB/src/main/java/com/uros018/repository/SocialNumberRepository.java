package com.uros018.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.uros018.model.Person;
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
	
	public SocialNumber findSocialNumber(SocialNumber socialNumber) {
		String hql="from SocialNumber s where s.socialNumber =: socialNumber";
		Session session=sessionFactory.openSession();
		Query query=session.createQuery(hql);
		query.setParameter("socialNumber", socialNumber.getSocialNumber());
		SocialNumber s1=(SocialNumber) query.uniqueResult();
		session.close();
		
		return s1;
	}
}
