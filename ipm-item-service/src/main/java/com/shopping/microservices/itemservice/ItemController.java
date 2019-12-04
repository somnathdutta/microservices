package com.shopping.microservices.itemservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemController {

	@Autowired
	ItemService itemService;
	
	@GetMapping("/item-service/items")
	public List<Item> getAllItems(){
		return itemService.getAllItems();
	}
	
	@GetMapping("/item-service/items/{itemName}")
	public Item getItem(@PathVariable String itemName){
		return itemService.getItemByName(itemName);
	}
	
	@PostMapping("/item-service/item")
	public String saveItem(@RequestBody Item item){	
		return itemService.saveItem(item);
	}
}
