package org.genia.fishstore.web;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
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
		try {
			sessionData.setLoggedInCustomer(customerService.authentificate(login, password));
			return "filter.xhtml?faces-redirect=true";
		} catch (UnsupportedOperationException e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid username or password", null));
			return null;
		}
	}
	
	public String loginEmployee() {
		try {
			sessionData.setLoggedInEmployee(employeeService.authentificate(login, password));
			switch (sessionData.getLoggedInEmployee().getRole()) {
			case GENERAL_MANAGER:
				return "admin/boss.xhtml?faces-redirect=true";
			case COLD_STORE_MANAGER:
				return "admin/coldStore.xhtml?faces-redirect=true";
			case ACCOUNTANT:
				return "admin/orderApproving.xhtml?faces-redirect=true";
			case SECURITY_OFFICER:
				return "admin/securityOfficerPage.xhtml?faces-redirect=true";
			default:
				return null;
			}
			
		} catch (UnsupportedOperationException e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid username or password", null));
			return null;
		}
	}
	
	
	public String logout() {
		boolean itsEmployee = sessionData.itsAnEmployee();
		sessionData.setLoggedInEmployee(null);
		sessionData.setLoggedInCustomer(null);
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		if (itsEmployee) {
			return "/employeeLogin.xhtml?faces-redirect=true";
		}
			
		return "/loggedOut.xhtml?faces-redirect=true";
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
