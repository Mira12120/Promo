package com.promo.demo.model.db;

import javax.persistence.Entity;
import javax.persistence.Table;

import javax.persistence.Id;

@Entity
@Table(name = "customer")
public class CustomerModel {

	public CustomerModel() {
		// TODO Auto-generated constructor stub
	}

	
	@Id
	private Long customerId;
	private String customerName;
	private int status;

	
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	
}
