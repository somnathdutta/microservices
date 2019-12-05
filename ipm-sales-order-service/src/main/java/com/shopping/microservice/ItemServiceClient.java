package com.shopping.microservice;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="item-service-709075")
interface ItemServiceClient {
  
	@GetMapping("/item-service/items")
	List<Item> getAllItems();
	
	@GetMapping("/item-service/items/{itemName}")
	Item getItemByName(@PathVariable("itemName") String itemName);
}