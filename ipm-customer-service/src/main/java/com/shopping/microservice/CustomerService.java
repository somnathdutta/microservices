package com.shopping.microservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.stereotype.Component;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Component
@EnableHystrix
public class CustomerService {
	
	@Autowired
	RabbitMQSender rabbitMQSender;
	
	@Autowired
	CustomerRepository customerRepository;
	
	public List<Customer> getAllCustomer(){
		return customerRepository.findAll();
	}
	
	
	@HystrixCommand(fallbackMethod="invalidCustomer")
	public String createCustomer(Customer customer){
		if(customer == null || customer.getFirstName() == null || customer.getFirstName()=="" || 
				customer.getLastName()==null || customer.getLastName()=="" || customer.getEmail()== null || customer.getEmail()==""){
			throw new RuntimeException("Invalid customer data!");
		}else{
			System.out.println("Customer created for db successfully!");
			customerRepository.save(customer);
			rabbitMQSender.send(customer);
			System.out.println("Customer creation event published successfully!");
		}
		return "Customer created successfully with details :"+customer.toString();				
	}

	public String invalidCustomer(Customer customer){
		return "Customer creation failed due to some internal error. Please try again later";
	}
}
