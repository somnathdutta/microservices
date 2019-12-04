package com.shopping.microservice;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQConsumer {

	@Autowired
	private SalesOrderCustomerRepository salesOrderCustomerRepository;
	
	@RabbitListener(queues = "${msa.rabbitmq.queue}",containerFactory="jsaFactory")
	public void recievedMessage(Customer customer) {
		System.out.println(":::::::::::::::::::::: Recieved Message From RabbitMQ ::::::::::::::::::::::::::::::: " + customer);
		Customer savedCustomer=salesOrderCustomerRepository.save(customer);
		System.out.println("#### ##### #### After saving customer data ::::::::::"+savedCustomer);
	}
	
}