package com.uros018.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uros018.converter.PersonDtoConverter;
import com.uros018.converter.SocialNumberDtoConverter;
import com.uros018.dto.PersonDTO;
import com.uros018.dto.SocialNumberDTO;
import com.uros018.model.DateMap;
import com.uros018.model.Gender;
import com.uros018.model.Person;
import com.uros018.model.SocialNumber;
import com.uros018.repository.DateRepository;
import com.uros018.repository.GenderRepository;
import com.uros018.repository.PersonRepository;
import com.uros018.repository.SocialNumberRepository;

@Service
public class PersonService {

	@Autowired
	PersonRepository personRepository;
	@Autowired 
	GenderRepository genderRepository;
	@Autowired
	DateRepository dateRepository;

	
	@Autowired
	PersonDtoConverter personDtoConverter;
	public void personSave(PersonDTO personDto) {
	 Person person=personDtoConverter.convertPerson(personDto);
		
	 person.setGender(genderRepository.findByNameGender(person.getGender()));
	 
	 	DateMap dateMap=dateRepository.findByDate(person.getDateOfBirth());
	 	if(dateMap==null) {
	 		dateRepository.save(person.getDateOfBirth());
	 	}
	 	else {
	 		person.setDateOfBirth(dateMap);
	 	}
	 
		personRepository.save(person);
	}
	
	@Autowired
	SocialNumberRepository socialNumberRepository;
	
	
	@Autowired
	SocialNumberDtoConverter socialNumberDtoConverter;
	public Person findBySocialNumber(SocialNumberDTO socialNumberDto) {
		SocialNumber socialNumber=socialNumberRepository.findSocialNumber(
				socialNumberDtoConverter.socialNumberConvert(socialNumberDto));
		
		return personRepository.findBySocialNumber(socialNumber);
		
		
	}
}
