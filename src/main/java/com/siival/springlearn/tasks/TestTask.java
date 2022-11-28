package com.siival.springlearn.tasks;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TestTask {

	
	@Scheduled(cron = "0/2 * * * * ?")
	public void testTask() {
		System.out.println("模拟task执行");
	}
}
