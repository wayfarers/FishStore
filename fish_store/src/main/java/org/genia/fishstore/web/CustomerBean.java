package org.genia.fishstore.web;

import java.util.List;

import javax.annotation.PostConstruct;
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
	
	@PostConstruct
	private void init() {
		customers = customerService.findAll();
	}
	
	public List<Customer> getCustomers() {
		
		return customers;
	}
	
	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	public void saveCustomer(Customer customer) {
		customerService.save(customer);
//		customer = customerService.getFreshCopy(customer);
	}
}
