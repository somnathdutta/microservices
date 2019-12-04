package com.shopping.microservice;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="SALES_ORDER")
public class SalesOrder {

	@Id
	@GeneratedValue
	@Column
	private Long id;
	
	@Column(name="order_date")
	private Date orderdate;
	
	@Column(name="cust_id")
	private Long customerId;
	
	@Column(name="order_desc")
	private String orderDescription;
	
	@Column(name="total_price")
	private double totalPrice;

	@Transient
	private String message;
	
	@OneToMany
	@JoinColumn(name="sales_order_id")
	private List<Item> items = new ArrayList<>();
	
	public SalesOrder(Long salesOrderId, Date orderdate, Long customerId, String orderDescription, double totalPrice) {
		super();
		this.id = salesOrderId;
		this.orderdate = orderdate;
		this.customerId = customerId;
		this.orderDescription = orderDescription;
		this.totalPrice = totalPrice;
	}

	
	@Override
	public String toString() {
		return "Order [id=" + id + ", orderdate=" + orderdate + ", customerId=" + customerId
				+ ", orderDescription=" + orderDescription + ", totalPrice=" + totalPrice + ", items=" + items + ", message=" + message+"]";
	}


	public SalesOrder() {
	}

	

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Date getOrderdate() {
		return orderdate;
	}

	public void setOrderdate(Date orderdate) {
		this.orderdate = orderdate;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getOrderDescription() {
		return orderDescription;
	}

	public void setOrderDescription(String orderDescription) {
		this.orderDescription = orderDescription;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}


	public List<Item> getItems() {
		return items;
	}


	public void setItems(List<Item> items) {
		this.items = items;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
