package com.shopping.microservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController{

	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private CustomConfiguration customConfiguration;
	
	@GetMapping("/customer-service/test")
	public String test(){
		return customConfiguration.getExchange();
	}
	
	@GetMapping("/customer-service/customers")
	public List<Customer> getCustomers(){
		return customerService.getAllCustomer();
	}
	
	@PostMapping("/customer-service/customer")
	public String createCustomer(@RequestBody Customer customer){
		System.out.println(":::::::::::::::::::::::::::::::::::::: New customer creation started ::::::::::::::::::::::::::::::::::::::::::");
		return customerService.createCustomer(customer);
	}
	
}
