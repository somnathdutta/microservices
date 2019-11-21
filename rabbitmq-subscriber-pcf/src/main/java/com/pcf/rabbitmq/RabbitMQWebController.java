package com.pcf.rabbitmq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RabbitMQWebController {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@GetMapping(value = "/subscriber")
	public Employee producer(@RequestParam("empId") Long empId) {
		Employee emp = employeeRepository.findOne(empId);
		return emp;
	}

}