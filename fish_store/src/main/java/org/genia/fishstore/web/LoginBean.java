package org.genia.fishstore.web;

import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.genia.fishstore.services.CustomerService;
import org.genia.fishstore.services.EmployeeService;

@Named
@SessionScoped
public class LoginBean {
	private String login;
	private String password;
	private Boolean isStuff = false;
	
	@Inject
	CustomerService customerService;
	@Inject
	EmployeeService employeeService;
	
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

	public Boolean getIsStuff() {
		return isStuff;
	}

	public void setIsStuff(Boolean isStuff) {
		this.isStuff = isStuff;
	}

	public String applyLogin() {
		if(isStuff) {
			int id = employeeService.authentificate(login, password).getId();
			return "";
		} else {
			int id = customerService.authentificate(login, password).getId();
			return "filter.xhtml";
		}
	}
}
