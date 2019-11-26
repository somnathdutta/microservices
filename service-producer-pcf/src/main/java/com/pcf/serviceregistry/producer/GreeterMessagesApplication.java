package com.pcf.serviceregistry.producer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class GreeterMessagesApplication {

	public static void main(String[] args) {
		SpringApplication.run(GreeterMessagesApplication.class, args);
	}

}
