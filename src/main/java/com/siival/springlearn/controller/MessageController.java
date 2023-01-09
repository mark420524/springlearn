package com.siival.springlearn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.siival.springlearn.mq.ProduceService;

@RestController
@RequestMapping("/msg")
public class MessageController {
	
	@Autowired
	private ProduceService produceService;

	@GetMapping("/send")
	public void sendMsg() {
		produceService.sendMsg();
	}
	

	@GetMapping("/fanout")
	public void sendFanoutMsg() {
		produceService.sendFanout();
	}
}
