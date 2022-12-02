package com.siival.springlearn;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@ConfigurationPropertiesScan("com.siival.springlearn.config")
public class AppRun {
	
	public static void main(String[] args) {
		SpringApplication spring = new SpringApplication(AppRun.class);
		spring.setBannerMode(Banner.Mode.OFF);
//		spring.setAddCommandLineProperties(false);
		spring.run(args);
	}

}
