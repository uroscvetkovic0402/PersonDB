package com.uros018.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uros018.converter.PersonDtoConverter;
import com.uros018.dto.PersonDTO;
import com.uros018.model.Address;
import com.uros018.model.City;
import com.uros018.model.DateMap;
import com.uros018.model.Person;
import com.uros018.model.State;
import com.uros018.repository.AddressRepository;
import com.uros018.repository.CityRepository;
import com.uros018.repository.DateRepository;
import com.uros018.repository.PersonRepository;
import com.uros018.repository.SocialNumberRepository;
import com.uros018.repository.StateRepository;

@Service
public class PersonService {

	@Autowired
	PersonRepository personRepository;
	@Autowired
	SocialNumberRepository socialNumberRepository;
	@Autowired
	DateRepository dateRepository;
	@Autowired
	AddressRepository addressRepository;
	@Autowired 
	CityRepository cityRepository;
	@Autowired 
	StateRepository stateRepository;
	
	@Autowired
	Person person;
	@Autowired 
	PersonDtoConverter personDtoConverter;
	public void personSave(PersonDTO personDto) {
		
//		City city=cityRepository.findByName(person.getAddress().getCity());
//		if(city==null)
//			cityRepository.save(person.getAddress().getCity());
//		else
//			person.getAddress().setCity(city);
//		
//		State state=stateRepository.findByName(person.getAddress().getState());
//		if(state==null)
//			stateRepository.save(person.getAddress().getState());
//		else
//			person.getAddress().setState(state);
//		
//		DateMap dateOfBirth=dateRepository.findByDate(person.getDateOfBirth());
//		if(dateOfBirth==null)
//			dateRepository.save(person.getDateOfBirth());
//		else
//			person.setDateOfBirth(dateOfBirth);
//		
//		Address address=addressRepository.findByFullAddress(person.getAddress());
//		if(address==null)
//			addressRepository.save(person.getAddress());
//		else
//			person.setAddress(address);
		
		person=personDtoConverter.convertPerson(personDto);
		socialNumberRepository.save(person.getSocialNumber());
		
		personRepository.save(person);
		
		
		
	}
	
	
}
