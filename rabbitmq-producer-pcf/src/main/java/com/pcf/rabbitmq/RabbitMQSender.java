package com.pcf.rabbitmq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;



@Service
public class RabbitMQSender {
	
	@Autowired
	private AmqpTemplate rabbitTemplate;
	
	@Value("${msa.rabbitmq.exchange}")
	private String exchange;
	
	@Value("${msa.rabbitmq.routingkey}")
	private String routingkey;	
	
	public void send(Employee employee) {
		System.out.println("Sending msg to the exchange : " + exchange+". The value is :"+employee);
		rabbitTemplate.convertAndSend(exchange, routingkey, employee);
		System.out.println("Sending msg : " + employee);
	}
}
