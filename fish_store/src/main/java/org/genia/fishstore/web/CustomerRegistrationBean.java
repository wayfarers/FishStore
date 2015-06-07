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
			return "registerCustomer.xhtml";
		}
		newCustomer.setRegistrationDate(Calendar.getInstance().getTime());
		customerService.save(newCustomer);
		
		return "filter.xhtml";
	}
	
	

	public Customer getNewCustomer() {
		return newCustomer;
	}

	public void setNewCustomer(Customer newCustomer) {
		this.newCustomer = newCustomer;
	}

//	public String getLogin() {
//		return login;
//	}
//
//	public void setLogin(String login) {
//		this.login = login;
//	}
//
//	public String getPassword() {
//		return password;
//	}
//
//	public void setPassword(String password) {
//		this.password = password;
//	}
}
