package org.genia.fishstore.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import org.genia.fishstore.entities.Employee;
import org.genia.fishstore.services.EmployeeService;
import org.primefaces.context.RequestContext;
import org.springframework.context.annotation.Scope;

@Named
@Scope("session")
public class SuperUserBean {
	
	Employee employee = new Employee();
	
	@Inject
	EmployeeService employeeService;
	
	public List<Employee> getEmployees() {
		return employeeService.findByFilter(null).getResultList();
	}
	
	public void disableEmployee(Employee empl) {
		empl.setSuspended(true);
	}

	public void enableEmployee(Employee empl) {
		empl.setSuspended(false);
	}
	
	public void addEmployee() {
		employeeService.save(employee);
	}
	
	public void editEmployee(Employee employee) {
		this.employee = employee;
		Map<String, Object> options = new HashMap<String, Object>();
    	options.put("contentHeight", 400);
    	options.put("contentWidth", 400);
        RequestContext.getCurrentInstance().openDialog("newEmployee", options, null);
	}
}
