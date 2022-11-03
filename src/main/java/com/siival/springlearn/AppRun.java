package com.siival.springlearn;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AppRun {
	
	public static void main(String[] args) {
		SpringApplication spring = new SpringApplication(AppRun.class);
		spring.setBannerMode(Banner.Mode.CONSOLE);
		spring.run(args);
	}

}
