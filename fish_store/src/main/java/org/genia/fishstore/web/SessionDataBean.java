package org.genia.fishstore.web;

import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.PersistenceContext;

import org.genia.fishstore.entities.Customer;
import org.genia.fishstore.entities.Employee;
import org.genia.fishstore.entities.Role;
import org.genia.fishstore.services.CustomerService;
import org.springframework.context.annotation.Scope;

@Named
@Scope(value="session")
public class SessionDataBean {
	private Employee loggedInEmployee;
	private Customer loggedInCustomer;
	
	@Inject
	CustomerService customerService;
	
	public Customer getLoggedInCustomer() {
		return loggedInCustomer;
	}

	public void setLoggedInCustomer(Customer loggedInCustomer) {
		this.loggedInCustomer = loggedInCustomer;
	}

	public Employee getLoggedInEmployee() {
		return loggedInEmployee;
	}

	public void setLoggedInEmployee(Employee loggedInEmployee) {
		this.loggedInEmployee = loggedInEmployee;
	}
	
	public Role getCurrentRole() {
		if (loggedInEmployee == null) {
			return null;
		}
		
		return loggedInEmployee.getRole();
	}
	
	public boolean itsAnEmployee() {
		return loggedInEmployee != null;
	}
}
