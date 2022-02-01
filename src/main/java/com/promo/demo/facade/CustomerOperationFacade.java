package com.promo.demo.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.promo.demo.model.db.CustomerModel;
import com.promo.demo.service.CustomerOperationsService;

@Component
public class CustomerOperationFacade {

	@Autowired
	private CustomerOperationsService customerOperationsService;
	
	public CustomerOperationFacade() {
		// TODO Auto-generated constructor stub
	}

	public String ListAllCustomers() {
		return customerOperationsService.ListAllCustomers();
	}
	
	public CustomerModel updateCustomerOrAdd(CustomerModel newCustomer , Long id) {
		return customerOperationsService.updateCustomerOrAdd(newCustomer, id);
	}
	
	 public String DeleteCustomer(Long id) {
		 return customerOperationsService.DeleteCustomer(id);
	 }
	 
		public String UpdateAllCustomersStatus( int newStatus,
				int oldStatus) {
			return customerOperationsService.UpdateAllCustomersStatus(newStatus, oldStatus);
		}
		
}
