package com.uros018.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.uros018.dto.PersonDTO;
import com.uros018.model.Person;

@Component
public class PersonDtoConverter {

	@Autowired
	Person person;
	
	public Person convertPerson(PersonDTO personDto) {
		
		
		person.setFirstName(personDto.getFirstName());
		person.setLastName(personDto.getLastName());
		person.setDateOfBirth(personDto.getDateOfBirth());
		person.setSocialNumber(personDto.getSocialNumber());
		
		return person;
	}
}
