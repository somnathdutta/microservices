package com.pcf.rabbitmq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RabbitMQWebController {

	@Autowired
	RabbitMQSender rabbitMQSender;

	@GetMapping(value = "/producer")
	public String producer(@RequestParam("empName") String empName, @RequestParam("empId") Long empId) {
		System.out.println("::: Inside producer :::");
		Employee emp = new Employee();
		emp.setEmpId(empId);
		emp.setEmpName(empName);
		rabbitMQSender.send(emp);

		return "Message"+ emp +"sent to the RabbitMQ Successfully";
	}

}