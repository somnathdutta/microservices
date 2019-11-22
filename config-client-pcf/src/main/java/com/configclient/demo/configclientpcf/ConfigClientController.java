package com.configclient.demo.configclientpcf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigClientController {
	
	@Autowired
	private EmployeeConfiguration employeeConfiguration;
	
	@GetMapping("/employee")
	public String getDataFromConfig(){
		return "The values from config server is as : First Name : "+employeeConfiguration.getFirstName()+" Last Name : "+employeeConfiguration.getLastName();
	}

}
