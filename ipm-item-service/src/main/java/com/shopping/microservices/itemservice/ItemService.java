package com.shopping.microservices.itemservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.stereotype.Component;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Component
@EnableHystrix
public class ItemService {

	@Autowired
	ItemRepository itemRepository;
	
	public List<Item> getAllItems(){
		return itemRepository.findAll();
	}
	
	public Item getItemByName(String itemName){
		return itemRepository.findByItemName(itemName);
	}
	
	@HystrixCommand(fallbackMethod="invalidItem")
	public String saveItem(Item item){
		if(item==null|| item.getItemName()==null||item.getItemName()==""||item.getItemPrice()==null||item.getItemPrice()==0.0d){
			throw new RuntimeException("Invalid item data!");
		}else{
			itemRepository.save(item);
			System.out.println("Item saved to db!");
		}
		return "The saved item is : "+item.toString();
	}
	
	public String invalidItem(Item item){
		return "Item saving failed due to some internal error. Please try again later";
	}
}
