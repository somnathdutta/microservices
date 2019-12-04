package com.shopping.microservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@RefreshScope
@Component
public class CustomConfiguration {
	@Value("${msa.rabbitmq.queue}")
	private String queueName;

	@Value("${msa.rabbitmq.exchange}")
	private String exchange;

	@Value("${msa.rabbitmq.routingkey}")
	private String routingkey;

	public String getQueueName() {
		return queueName;
	}

	public String getExchange() {
		return exchange;
	}

	public String getRoutingkey() {
		return routingkey;
	}
	
	
}
