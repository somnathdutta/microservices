package com.configclient.demo.configclientpcf;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@RefreshScope
@Component
public class EmployeeConfiguration {

	@Value("${firstName}")
	private String firstName;
	
	@Value("${lastName}")
	private String lastName;

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}
}
