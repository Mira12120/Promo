package com.promo.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.promo.demo.facade.CustomerOperationFacade;
import com.promo.demo.model.db.CustomerModel;

@RestController
public class PromoController {

	@Autowired
	private CustomerOperationFacade customerOperationFacade;

	public PromoController() {
		// TODO Auto-generated constructor stub
	}

	@GetMapping("listCustomers")
	public String ListAllCustomers(                                                                                     ) {
		return customerOperationFacade.ListAllCustomers();
	}

	@PutMapping("updateCustomer")
	public CustomerModel UpdateCustomer(@RequestBody CustomerModel newCustomer,
			@RequestParam(required = true) Long id) {
		return customerOperationFacade.updateCustomerOrAdd( newCustomer ,  id);
	}
	
	
	@DeleteMapping("deleteCustomer")
	public String DeleteCustomer(@RequestParam(required = true) Long id) {
		return customerOperationFacade.DeleteCustomer(id);

	}

	@PutMapping("updateAllCustomers")
	public String UpdateAllCustomersStatus(@RequestParam(required = true) int newStatus,
			@RequestParam(required = true) int oldStatus) {

		return customerOperationFacade.UpdateAllCustomersStatus(newStatus, oldStatus);
	}
}
