package com.uros018.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.uros018.dto.PersonDTO;
import com.uros018.model.Person;
import com.uros018.model.SocialNumber;

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
	
	public Person findById(int id) {
		String hql="from Person p where p.id =: id";
		Session session=sessionFactory.openSession();
		Query query=session.createQuery(hql);
		query.setParameter("id", id);
		Person p1=(Person) query.uniqueResult();
		session.close();
		
		return p1;
	}
	
	public Person findBySocialNumber(SocialNumber socialNumber) {
//		String hql=" from  Person p  JOIN  p.socialNumber sc where sc.socialNumber =: socialNumber";
//		Session session=sessionFactory.openSession();
//		Query query=session.createQuery(hql);
//		query.setParameter("socialNumber", socialNumber.getSocialNumber());
//		Person p1=(Person) query.uniqueResult();
//		session.close();

		String hql="from Person p where p.socialNumber =: socialNumber";
		Session session=sessionFactory.openSession();
		Query query=session.createQuery(hql);
		query.setParameter("socialNumber", socialNumber);
		Person p1=(Person) query.uniqueResult();
		session.close();
		return p1;
		
	}
}
