package com.siival.springlearn.mq.consumer;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.siival.springlearn.mq.constant.MqConstant;

@Component
public class MqConsumer {

	@RabbitListener(bindings = @QueueBinding(
				exchange = @Exchange(value = MqConstant.EXCHANGE_KEY),
				value = @Queue("queueKey"),
				key = MqConstant.ROUTE_KEY
			))
	public void msgConsumer(String json) {
		System.out.println("收到mq:" + json);
	}
	@RabbitListener(bindings = @QueueBinding(
			exchange = @Exchange(value = MqConstant.EXCHANGE_FANOUT_KEY, type = ExchangeTypes.FANOUT ),
			value = @Queue("queueKeyFanout1") 
		))
	public void msgFanout1(String json) {
		System.out.println("fanout consumer1 收到 :" + json);
	}
	
	@RabbitListener(bindings = @QueueBinding(
			exchange = @Exchange(value = MqConstant.EXCHANGE_FANOUT_KEY, type = ExchangeTypes.FANOUT ),
			value = @Queue("queueKeyFanout2") 
		))
	public void msgFanout2(String json) {
		System.out.println("fanout consumer2 收到 :" + json);
	}
}
