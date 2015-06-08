package org.genia.fishstore.web;

import javax.inject.Inject;
import javax.inject.Named;

import org.genia.fishstore.services.CustomerService;
import org.genia.fishstore.services.EmployeeService;
import org.springframework.context.annotation.Scope;

@Named
@Scope("session")
public class LoginBean {
	private String login;
	private String password;
	private Boolean isEmployee = false;
	
	@Inject
	SessionDataBean sessionData;
	
	@Inject
	CustomerService customerService;
	@Inject
	EmployeeService employeeService;
	
	public String login() {
		if(isEmployee) {
			sessionData.setLoggedInEmployee(employeeService.authentificate(login, password));
			return "";
		} else {
			sessionData.setLoggedInCustomer(customerService.authentificate(login, password));
			return "filter.xhtml?faces-redirect=true";
		}
	}
	
	public String logout() {
		sessionData.setLoggedInEmployee(null);
		sessionData.setLoggedInCustomer(null);
		
		return "loggedOut.xhtml?faces-redirect=true";
	}
	
	public LoginBean() {
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

	public Boolean getIsEmployee() {
		return isEmployee;
	}

	public void setIsEmployee(Boolean isEmployee) {
		this.isEmployee = isEmployee;
	}

	
}