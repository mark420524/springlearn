package com.siival.springlearn.mq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import com.siival.springlearn.mq.constant.MqConstant;

@Service
public class ProduceService {

	private final RabbitTemplate rabbitTemplate;
	
	public ProduceService( RabbitTemplate rabbitTemplate) {
		this.rabbitTemplate = rabbitTemplate;
	}
	
	public void sendMsg() {
		String json = "{\"test\":1}";
		rabbitTemplate.convertAndSend(MqConstant.EXCHANGE_KEY, MqConstant.ROUTE_KEY, json);
	}
	
	public void sendFanout() {
		String json = "{\"test\":\"fanout\"}";
		rabbitTemplate.convertAndSend(MqConstant.EXCHANGE_FANOUT_KEY, "", json);
	}
	
}
