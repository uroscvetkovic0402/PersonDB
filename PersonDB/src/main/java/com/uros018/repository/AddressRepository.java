package com.uros018.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.uros018.model.Address;

@Transactional
@Repository
public class AddressRepository {

	@Autowired
	SessionFactory sessionFactory;

	public void save(Address address) {

		Session session = sessionFactory.openSession();
		session.save(address);
		session.close();

	}

	public Address findByFullAddress(Address address) {
		String hql = "from Address a where a.state.state = : state"
			    + " and a.city.city = : city "
				+ " and a.street = : street "
				+ " and a.buildingNumber = : buildingNumber"
				+ " and a.apartmentNumber = : apartmentNumber";
		
		Session session=sessionFactory.openSession();
		Query query=session.createQuery(hql);
		query.setParameter("state", address.getState().getState());
		query.setParameter("city", address.getCity().getCity());
		query.setParameter("street", address.getStreet());
	    query.setParameter("buildingNumber", address.getBuildingNumber());
		query.setParameter("apartmentNumber", address.getApartmentNumber());
		Address ad=(Address) query.uniqueResult();
		return ad;
	}

}
