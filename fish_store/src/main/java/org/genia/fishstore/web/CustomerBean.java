package org.genia.fishstore.web;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.genia.fishstore.entities.Customer;
import org.genia.fishstore.services.CustomerService;
import org.springframework.context.annotation.Scope;

@Named
@Scope("session")
public class CustomerBean {

	@Inject
	CustomerService customerService;
	
	private List<Customer> customers;
	
	
	public List<Customer> getCustomers() {
		customers = customerService.findAll();
		return customers;
	}
	
	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	public void saveCustomer(Customer customer) {
		customerService.save(customer);
		System.out.println("invoked saving");
	}
}