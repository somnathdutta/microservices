package com.shopping.microservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@RefreshScope
@Component
public class CustomConfiguration {

	@Value("${success.message}")
	private String successMessage;
	
	public String getSuccessMessage() {
		return successMessage;
	}
}
