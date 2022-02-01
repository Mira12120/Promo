package com.promo.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.promo.demo.model.db.CustomerModel;
import com.promo.demo.repository.db.CustomerRepository;
@Service
public class CustomerOperationsService {

	
	@Autowired
	private CustomerRepository repo;
	
	public CustomerOperationsService() {
		// TODO Auto-generated constructor stub
	}

	
	public String ListAllCustomers() {
		List<CustomerModel> listUsers = repo.findAll();
		ObjectMapper objectMapper = new ObjectMapper();
		String json = null;
		try {
			json = objectMapper.writeValueAsString(listUsers);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return json;
	} 
	
	
	public CustomerModel updateCustomerOrAdd(CustomerModel newCustomer , Long id) {
		
		return repo.findById(id).map(customer -> {
			customer.setCustomerName(newCustomer.getCustomerName());
			customer.setStatus(newCustomer.getStatus());
			return repo.save(customer);
		}).orElseGet(() -> {
			newCustomer.setCustomerId(id);
			return repo.save(newCustomer);
		});
	}
	
	
	public String DeleteCustomer(Long id) {
		if (repo.findById(id).isPresent())
			repo.deleteById(id);
		else
			return "No Customer Found";

		return "Done";
	}
	
	public String UpdateAllCustomersStatus( int newStatus,
			int oldStatus) {

		Thread t1 = new Thread() {
			public void run() {
				repo.updateCustomers(newStatus, oldStatus);
				// Displaying the thread that is running
				System.out.println("Thread " + Thread.currentThread().getId() + " is running");
			}
		};

		t1.start();
		// t2.start();
		return "Done";

	}
}
