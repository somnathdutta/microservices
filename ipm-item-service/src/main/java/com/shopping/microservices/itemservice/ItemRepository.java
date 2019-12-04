package com.shopping.microservices.itemservice;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long>{

	Item findByItemName(String itemName);
}
