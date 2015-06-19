package org.genia.fishstore.infrastructure;

import java.util.Calendar;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.inject.Named;

import org.genia.fishstore.web.SessionDataBean;
import org.springframework.context.annotation.Scope;

// TODO: Create a AuthorisationInterceptor, which will check whether employee/customer is logged in and redirect to login page.
// TODO: Split templates into "admin" and "customer" folders
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
    	SessionDataBean session = event.getFacesContext().getApplication().evaluateExpressionGet(event.getFacesContext(), "#{sessionDataBean}", SessionDataBean.class);
        System.out.println("IN " + event.getFacesContext().getViewRoot().getViewId() + " " + 
        		(session.getLoggedInEmployee() != null ? "Logged in as " + session.getLoggedInEmployee().getLogin() : "not loggen in"));
    }

    @Override
    public void afterPhase(PhaseEvent event) {
        // Do your job here which should run after the render response phase.
    	long timeElapsed = Calendar.getInstance().getTimeInMillis() - timeStarted.get();
    	System.out.println("OUT " + event.getFacesContext().getViewRoot().getViewId() + " in " + timeElapsed + "ms.");
    }

}