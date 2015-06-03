package org.genia.fishstore.web;

import java.util.Calendar;

import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.genia.fishstore.entities.Customer;
import org.genia.fishstore.services.CustomerService;

@Named
@SessionScoped
public class CustomerRegBean {
	Customer newCustomer;
	String login;
	String password;
	String email;
	String name;
	
	@Inject
	CustomerService customerService;
	
	public CustomerRegBean() {
		newCustomer = new Customer();
	}
	
	public String apply() {
		if(customerService.findByLogin(login) == null) {
			//message, such login is already exists.
			return "registerCustomer.xhtml";
		}
		newCustomer.setEmail(email);
		newCustomer.setLogin(login);
		newCustomer.setName(name);
		newCustomer.setPassword(password);
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

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
