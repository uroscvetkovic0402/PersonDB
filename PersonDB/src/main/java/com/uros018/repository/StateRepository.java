package com.uros018.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.uros018.model.State;

@Transactional
@Repository
public class StateRepository {

	@Autowired
	SessionFactory sessionFactory;
	
	public void save(State state) {
		Session session=sessionFactory.openSession();
		session.save(state);
		session.close();
	}
	
	public State findByName(State state) {
		String hql="from State s where s.state =:state";
		Session session=sessionFactory.openSession();
		Query query=session.createQuery(hql);
		query.setParameter("state", state.getState());
		State s= (State) query.uniqueResult();
		session.close();
		
		return s;
	}
}
