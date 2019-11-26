package com.pcf.serviceregistry.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@EnableDiscoveryClient
@EnableFeignClients
@RestController
public class GreeterController {

	@Autowired
	MessagesClient messagesClient;

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public Greeting hello(@RequestParam(value = "salutation", defaultValue = "Hello") String salutation,
			@RequestParam(value = "name", defaultValue = "Bob") String name) {
		Greeting greeting = messagesClient.greeting(name, salutation);
		return greeting;
	}

}
