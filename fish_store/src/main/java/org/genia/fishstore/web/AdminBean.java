package org.genia.fishstore.web;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

@Named
@Scope("session")
public class AdminBean {
	
	
	@Inject
	SessionDataBean sessionData;
	
	public String home() {
		
		if (sessionData.getLoggedInEmployee() == null) {
			return "employeeLogin.xhtml?faces-redirect=true";
		}
		
		switch (sessionData.getLoggedInEmployee().getRole()) {
		case GENERAL_MANAGER:
			return "admin/boss.xhtml";
		case SECURITY_OFFICER:
			return "admin/securityOfficerPage.html";
		default:
			throw new UnsupportedOperationException(
					"No home page for role " + sessionData.getLoggedInEmployee().getRole() + " yet");
		}
	}
}
