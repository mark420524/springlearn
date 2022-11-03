package com.siival.springlearn.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(0)
public class MyCommandRunner implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		System.out.println("command line runner");
	}

}
