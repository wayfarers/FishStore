package org.genia.fishstore.web;

import java.util.Calendar;

import javax.inject.Inject;
import javax.inject.Named;

import org.genia.fishstore.entities.Customer;
import org.genia.fishstore.services.CustomerService;
import org.springframework.context.annotation.Scope;

@Named
@Scope("session")
public class CustomerRegistrationBean {
	Customer newCustomer;
	
	@Inject
	CustomerService customerService;
	
	public CustomerRegistrationBean() {
		newCustomer = new Customer();
	}
	
	public String apply() {
		if(customerService.findByLogin(newCustomer.getLogin()) == null) {
			//message, such login is already exists.
			return "registerCustomer.xhtml?faces-redirect=true";
		}
		newCustomer.setRegistrationDate(Calendar.getInstance().getTime());
		customerService.save(newCustomer);
		
		return "filter.xhtml?faces-redirect=true";
	}
	
	

	public Customer getNewCustomer() {
		return newCustomer;
	}

	public void setNewCustomer(Customer newCustomer) {
		this.newCustomer = newCustomer;
	}

}
