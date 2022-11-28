package com.siival.springlearn.controller;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.siival.springlearn.model.Person;

@RestController
@RequestMapping("/person")
public class PersonController {

	@GetMapping("/{id}")
	public Person findById(@PathVariable("id") Integer id) {
		Person p = new Person();
		p.setId(id);
		p.setName("张三");
		p.setCreateTime(LocalDateTime.now());
		p.setUpdateTime(LocalDateTime.now());
		return p;
	}
	
}
