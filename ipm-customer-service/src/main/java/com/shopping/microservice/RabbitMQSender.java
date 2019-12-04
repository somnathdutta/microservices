package com.shopping.microservice;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


@Service
public class RabbitMQSender{
	
	@Autowired
	private AmqpTemplate amqpTemplate;
	
	@Autowired
	private CustomConfiguration customConfiguration;
	
	public void send(Customer customer) {
		amqpTemplate.convertAndSend(customConfiguration.getExchange(), customConfiguration.getRoutingkey(), customer);
		System.out.println("Sending msg to the exchange : " + customConfiguration.getExchange()+". The value is :"+customer);
	}
}
