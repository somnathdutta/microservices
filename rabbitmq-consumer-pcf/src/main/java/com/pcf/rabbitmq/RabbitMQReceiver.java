package com.pcf.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQReceiver {
   
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@RabbitListener(queues="${msa.rabbitmq.queue}",containerFactory="jsaFactory")
    public void receivedMessage(Employee employee) {
        System.out.println("Received Message: " + employee);
        employeeRepository.save(employee);
    }
}