package com.siival.springlearn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.siival.springlearn.util.MessageUtil;

@RestController
public class IndexController {

	@Autowired
	private MessageUtil messageUtil;
	
	@RequestMapping("/")
	public String index() {
		return messageUtil.getValueByKey("welcome");
	}
}
