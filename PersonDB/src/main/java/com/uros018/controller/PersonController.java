package com.uros018.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.uros018.dto.PersonDTO;
import com.uros018.dto.SocialNumberDTO;
import com.uros018.model.Person;
import com.uros018.service.PersonService;

@Controller
public class PersonController {
	
	@Autowired
	PersonService personService;


	@InitBinder
	protected void initBinder(WebDataBinder binder) {
	    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(
	            dateFormat, false));
	}
	
	@GetMapping("/person_new")
	public ModelAndView test() {
		
	
		ModelAndView mav=new ModelAndView("person_new");
		mav.addObject(new PersonDTO());
		
		return mav;
	}
	
	
	
	@PostMapping("/person_create")
	public ModelAndView createPerson(@ModelAttribute("personDto")PersonDTO personDto) {
		personService.personSave(personDto);
		ModelAndView mav=new ModelAndView("person_view");
		
		SocialNumberDTO socialNumberDto=new SocialNumberDTO();
		socialNumberDto.setSocialNumber(personDto.getSocialNumber().getSocialNumber());
		Person person=personService.findBySocialNumber(socialNumberDto);
		mav.addObject("person", person);
		return mav;
	}
	
	@GetMapping("/person_find")
	public ModelAndView personFind() {
		
		
		ModelAndView mav=new ModelAndView("person_find");
		mav.addObject(new SocialNumberDTO());
		
		return mav;
	}
	
	@PostMapping("/find_by_socialNumber")
	public ModelAndView findBySocialNumber(SocialNumberDTO socialNumberDto) {
		ModelAndView mav;
		Person person=personService.findBySocialNumber(socialNumberDto);
	
		if(person==null) {
			mav=new ModelAndView("person_find");
			mav.addObject("msg","NE POSTOJI LICE SA ZADATIM KRITERIJUMOM");
		}
		else {
			mav=new ModelAndView("person_view");
			mav.addObject("person",person);
		}
		
		
		return mav;
	}
	

	
}
