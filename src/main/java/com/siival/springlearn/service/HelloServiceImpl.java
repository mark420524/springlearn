package com.siival.springlearn.service;

import org.springframework.stereotype.Service;

import com.siival.hellostarter.HelloService;

/**
 * @time 2023年1月31日下午4:14:18
 * @author mark acrossxwall@gmail.com
 * @className HelloServiceImpl
 */
@Service
public class HelloServiceImpl implements HelloService {

	@Override
	public void sayHello() {
		System.out.println("hello service on app ");
	}

}
