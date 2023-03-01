package com.siival.springlearn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.siival.springlearn.exception.CustomerException;
import com.siival.springlearn.first.data.TestFirst;
import com.siival.springlearn.model.Person;
import com.siival.springlearn.service.PersonService;

@RestController
@RequestMapping("/person")
public class PersonController {
	
	@Autowired
	private PersonService personService;

	@GetMapping("/{id}")
	public Person findById(@PathVariable("id") Integer id) {
		if (id<1) {
			throw new RuntimeException("参数不正确");
		}		
		return personService.getPerson(id);
	}
	@GetMapping("/tx/{id}")
	public TestFirst testTransaction(@PathVariable("id") Integer id) {
			try {
				return personService.saveFirstById(id);
			} catch (Exception e) {
				return new TestFirst();
			}
		 
	}
	
	
	@GetMapping("/test/{times}")
	public String testRollback(@PathVariable("times") Integer times) {
		personService.rollback(times);
		return "{\"rollback\":1}";
	}
	
}
