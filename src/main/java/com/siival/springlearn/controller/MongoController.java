package com.siival.springlearn.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.siival.springlearn.service.MongoService;

/**
 * @time 2023年3月16日下午7:12:54
 * @author mark acrossxwall@gmail.com
 * @className MongoController
 */
@RestController
@RequestMapping("/mongodb")
public class MongoController {
	@Autowired
	private MongoService mongoService;

	@GetMapping("/list")
	public Set<String> findAllDatabase() {
		return mongoService.findAll();
	}
	
}
