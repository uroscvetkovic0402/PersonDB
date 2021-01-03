package com.uros018.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.uros018.dto.SocialNumberDTO;
import com.uros018.model.SocialNumber;
@Component
public class SocialNumberDtoConverter {

	@Autowired
	SocialNumber socialNumber;
	
	public SocialNumber socialNumberConvert(SocialNumberDTO socialNumberDto) {
		
		socialNumber.setSocialNumber(socialNumberDto.getSocialNumber());
		
		return socialNumber;
	}
}
