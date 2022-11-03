package com.siival.springlearn.listener;

import org.springframework.boot.availability.AvailabilityChangeEvent;
import org.springframework.boot.availability.LivenessState;
import org.springframework.boot.availability.ReadinessState;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class MyEventListener {

	@EventListener
	public void livenessStateChange(AvailabilityChangeEvent<LivenessState> state) {
		
		LivenessState live = state .getState();
		switch (live) {
		case CORRECT -> System.out.println("correct");
		case BROKEN -> System.out.println("broken");
		default -> System.out.println("default");
		
		}
	}
	
	@EventListener
	public void readinessStateChange(AvailabilityChangeEvent<ReadinessState> state) {
		ReadinessState readiness = state.getState();
		switch (readiness) {
		case ACCEPTING_TRAFFIC -> System.out.println("accept traffic");
		case REFUSING_TRAFFIC -> System.out.println("refuse traffic");
		default -> System.out.println("");
		}
	}
}
