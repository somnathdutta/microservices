package com.shopping.microservice;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Customer implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name="cust_id")
	private Long customerId;
	
	@Column(name="cust_first_name")
	private String firstName;
	
	@Column(name="cust_last_name")
	private String lastName;
	
	@Column(name="cust_email")
	private String email;

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(Long customerId, String firstName, String lastName, String email) {
		super();
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + "]";
	}
	
	
}
