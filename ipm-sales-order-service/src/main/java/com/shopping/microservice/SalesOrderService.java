package com.shopping.microservice;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Component
// @EnableHystrix
public class SalesOrderService {

	private static final Logger LOGGER = LoggerFactory.getLogger(SalesOrderService.class);

	@Autowired
	private ItemServiceClient itemServiceClient;

	@Autowired
	private SalesOrderCustomerRepository salesOrderCustomerRepository;

	@Autowired
	private ItemRepository itemRepository;

	@Autowired
	private SalesOrderRepository salesOrderRepository;
	
	@Autowired
	private CustomConfiguration customConfiguration;

	public Customer getCustomerById(Long customerId) {
		return salesOrderCustomerRepository.getOne(customerId);
	}

	public Item getItemByName(String itemName) {
		return itemServiceClient.getItemByName(itemName);
	}

	public List<Item> getAllItems() {
		return itemServiceClient.getAllItems();
	}

	@HystrixCommand(fallbackMethod = "orderFailed")
	public String createNewOrder(SalesOrder order) {
		LOGGER.debug("<-------- Inside order creation ------------------->");
		System.out.println("###### ###### Inside create order method ###### ###### ######");
		SalesOrder createdOrder = null;
		if (order == null || order.getCustomerId() == null || CollectionUtils.isEmpty(order.getItems())) {
			System.out.println("Invalid order data. May be customer id or items are missing. Please check with your request.");
			throw new RuntimeException("Invalid order data!");
		}

		Optional<Customer> customer = salesOrderCustomerRepository.findById(order.getCustomerId());
		
		if (customer.isPresent()) {
			double totalPrice = 0.0;
			for (Item item : order.getItems()) {
				Item itemFromMs = getItemByName(item.getItemName());
				if (itemFromMs == null) {
					System.out.println("Item service not responding! May be item service is down. Please check later.");
					throw new RuntimeException("Item not found!");
				}
				totalPrice = totalPrice + (item.getItemQuantity() * itemFromMs.getItemPrice());
				item.setItemDescription(itemFromMs.getItemDescription());
				item.setItemPrice(itemFromMs.getItemPrice());
			}
			order.setTotalPrice(totalPrice);
			order.setOrderdate(new Date());

			itemRepository.saveAll(order.getItems());
			createdOrder = salesOrderRepository.save(order);
		}

		return "Hi " + customer.get().getFirstName() + " " + customer.get().getLastName()
				+ customConfiguration.getSuccessMessage() + createdOrder.getId();
	}

	public String orderFailed(SalesOrder order) {
		return "Order creation failed due to some internal error. Please try again later.";
	}
}
