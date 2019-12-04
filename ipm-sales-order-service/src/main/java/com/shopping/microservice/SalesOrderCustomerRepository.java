package com.shopping.microservice;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SalesOrderCustomerRepository extends JpaRepository<Customer, Long>{

}
