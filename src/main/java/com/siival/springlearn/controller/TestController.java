package com.siival.springlearn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.siival.springlearn.service.RedisService;

/**
 * @time 2023年6月14日10:32:57
 * @author mark acrossxwall@gmail.com
 * @className TestController
 */
@RestController
@RequestMapping("/test")
public class TestController {

	@Autowired
	private RedisService redisService;
	
	@GetMapping("/increment")
	public String testIncrement() {
		long a = redisService.incrementByKey("test");
		return "{\"test\": "+a+" }";
	}
	@GetMapping("/transaction")
	public String testTransaction () {
		redisService.redisTransaction();
		return "ok";
	}
}
