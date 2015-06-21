package org.genia.fishstore.infrastructure;

import java.io.IOException;
import java.util.Calendar;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.inject.Named;

import org.genia.fishstore.entities.Employee;
import org.genia.fishstore.entities.Role;
import org.genia.fishstore.web.SessionDataBean;
import org.springframework.context.annotation.Scope;

// TODO: Create a AuthorisationInterceptor, which will check whether employee/customer is logged in and redirect to login page.
// TODO: Check authorisation only for pages from "admin" folder
@Named
@Scope("session")
public class LoggingInterceptor implements PhaseListener {
	private static final long serialVersionUID = 1L;
	
	ThreadLocal<Long> timeStarted = new ThreadLocal<>();

	@Override
    public PhaseId getPhaseId() {
        return PhaseId.RENDER_RESPONSE;
    }

    @Override
    public void beforePhase(PhaseEvent event) {
    	timeStarted.set(Calendar.getInstance().getTimeInMillis());
    	String url = event.getFacesContext().getViewRoot().getViewId();
    	String pageName = url.substring(url.lastIndexOf("/") + 1, url.lastIndexOf("."));
    	
    	SessionDataBean session = event.getFacesContext().getApplication().evaluateExpressionGet(event.getFacesContext(), "#{sessionDataBean}", SessionDataBean.class);
    	Employee loggedInEmployee = session.getLoggedInEmployee();
    	
        System.out.println("IN " + event.getFacesContext().getViewRoot().getViewId() + " " + 
        		(session.getLoggedInEmployee() != null ? "Logged in as " + session.getLoggedInEmployee().getLogin() : "not loggen in"));
        System.out.println(pageName);
		try {

			if (url.contains("admin/")) {
				switch (pageName) {
				case "boss":
				case "manageCustomers":
				case "report":
				case "editPurchase":
					if (loggedInEmployee != null
							&& loggedInEmployee.getRole() == Role.GENERAL_MANAGER) {
						return;
					}
				case "coldStore":
				case "acceptOnStore":
				case "managePurchases":
				case "restOnStock":
					if (loggedInEmployee != null
							&& loggedInEmployee.getRole() == Role.COLD_STORE_MANAGER) {
						return;
					}
				case "orderApproving":
					if (loggedInEmployee != null
							&& loggedInEmployee.getRole() == Role.ACCOUNTANT) {
						return;
					}
				case "securityOfficerPage":
				case "newEmployee":
					if (loggedInEmployee != null
							&& loggedInEmployee.getRole() == Role.SECURITY_OFFICER) {
						return;
					}
				}
				event.getFacesContext().getExternalContext().redirect("/fish_store/employeeLogin.xhtml");
			} else if (url.contains("customer/") && session.getLoggedInCustomer() == null) {
				event.getFacesContext().getExternalContext().redirect("/fish_store/loginPage.xhtml");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

    @Override
    public void afterPhase(PhaseEvent event) {
        // Do your job here which should run after the render response phase.
    	long timeElapsed = Calendar.getInstance().getTimeInMillis() - timeStarted.get();
    	System.out.println("OUT " + event.getFacesContext().getViewRoot().getViewId() + " in " + timeElapsed + "ms.");
    }

}