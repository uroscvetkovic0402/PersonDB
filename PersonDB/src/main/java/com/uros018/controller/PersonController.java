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
	public ModelAndView createPerson(@ModelAttribute("person")PersonDTO person) {
		personService.personSave(person);
		ModelAndView mav=new ModelAndView("index");
		return mav;
	}
	
}
