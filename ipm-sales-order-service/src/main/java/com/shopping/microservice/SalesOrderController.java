package com.shopping.microservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@EnableDiscoveryClient
@EnableFeignClients
@RestController
public class SalesOrderController {

	@Autowired
	private SalesOrderService salesOrderservice;

	@PostMapping("/order-service/orders")
	public String createOrder(@RequestBody SalesOrder order){
		return salesOrderservice.createNewOrder(order);		
	}
	
	@GetMapping("/order-service/items")
	public List getAllItems(){
		return salesOrderservice.getAllItems();
	}
	
	@GetMapping("/order-service/{customerId}")
	public Customer getCustomerById(@PathVariable Long customerId){
		return salesOrderservice.getCustomerById(customerId);
	}
}
