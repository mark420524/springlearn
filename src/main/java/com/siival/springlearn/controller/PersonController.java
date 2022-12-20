package com.siival.springlearn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.siival.springlearn.model.Person;
import com.siival.springlearn.service.PersonService;

@RestController
@RequestMapping("/person")
public class PersonController {
	
	@Autowired
	private PersonService personService;

	@GetMapping("/{id}")
	public Person findById(@PathVariable("id") Integer id) {
		return personService.getPerson(id);
	}
	
}
