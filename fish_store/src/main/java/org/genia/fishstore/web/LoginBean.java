package org.genia.fishstore.web;

import javax.faces.application.FacesMessage;
import javax.inject.Inject;
import javax.inject.Named;

import org.genia.fishstore.services.CustomerService;
import org.genia.fishstore.services.EmployeeService;
import org.primefaces.context.RequestContext;
import org.springframework.context.annotation.Scope;

@Named
@Scope("session")
public class LoginBean {
	private String login;
	private String password;
	
	@Inject
	SessionDataBean sessionData;
	
	@Inject
	CustomerService customerService;
	@Inject
	EmployeeService employeeService;
	
	public String loginCustomer() {
		sessionData.setLoggedInCustomer(customerService.authentificate(login, password));
		return "filter.xhtml?faces-redirect=true";
	}
	
	public String loginEmployee() {
		try {
			sessionData.setLoggedInEmployee(employeeService.authentificate(login, password));
			return "securityOfficerPage.xhtml?faces-redirect=true";
		} catch (UnsupportedOperationException e) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Authentification error", "Invalid username or password");
			RequestContext.getCurrentInstance().showMessageInDialog(message);
			return null;
		}
	}
	
	
	public String logout() {
		boolean itsEmployee = sessionData.itsAnEmployee();
		sessionData.setLoggedInEmployee(null);
		sessionData.setLoggedInCustomer(null);
		
		if (itsEmployee) {
			return "employeeLogin.xhtml?faces-redirect=true";
		}
			
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
	
}
