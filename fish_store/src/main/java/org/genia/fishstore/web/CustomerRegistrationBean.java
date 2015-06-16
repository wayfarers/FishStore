package org.genia.fishstore.web;

import java.util.Calendar;

import javax.faces.application.FacesMessage;
import javax.inject.Inject;
import javax.inject.Named;

import org.genia.fishstore.entities.Customer;
import org.genia.fishstore.services.CustomerService;
import org.primefaces.context.RequestContext;
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
		if(customerService.findByLogin(newCustomer.getLogin()) != null) {
			//message, such login is already exists.
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Registration failed", "We are sorry, but login " + newCustomer.getLogin() + " is already used.");
			RequestContext.getCurrentInstance().showMessageInDialog(message);
			
		}
		newCustomer.setRegistrationDate(Calendar.getInstance().getTime());
		customerService.save(newCustomer);
		RequestContext.getCurrentInstance().execute("PF('reg_ok').show()");
		
		return null;//"filter.xhtml?faces-redirect=true";
	}
	
	

	public Customer getNewCustomer() {
		return newCustomer;
	}

	public void setNewCustomer(Customer newCustomer) {
		this.newCustomer = newCustomer;
	}

}
