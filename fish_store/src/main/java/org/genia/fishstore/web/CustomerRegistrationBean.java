package org.genia.fishstore.web;

import java.util.Calendar;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
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
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "We are sorry, but login '" + newCustomer.getLogin() + "' is already used.", null));
			return null;
		}
		newCustomer.setRegistrationDate(Calendar.getInstance().getTime());
		customerService.save(newCustomer);
//		RequestContext.getCurrentInstance().execute("PF('reg_ok').show()");
		
		return "registerSuccessed.xhtml?faces-redirect=true";
	}
	
	

	public Customer getNewCustomer() {
		return newCustomer;
	}

	public void setNewCustomer(Customer newCustomer) {
		this.newCustomer = newCustomer;
	}

}
