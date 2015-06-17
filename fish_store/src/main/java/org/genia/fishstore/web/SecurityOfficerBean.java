package org.genia.fishstore.web;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.genia.fishstore.EmployeeFilter;
import org.genia.fishstore.entities.Employee;
import org.genia.fishstore.services.EmployeeService;
import org.primefaces.context.RequestContext;
import org.springframework.context.annotation.Scope;

@Named
@Scope("session")
public class SecurityOfficerBean {
	
	private Employee employee;
	EmployeeFilter filter;
	
	@Inject
	EmployeeService employeeService;
	
	public SecurityOfficerBean() {
		employee = new Employee();
		filter = new EmployeeFilter();
	}
	
	public List<Employee> getEmployees() {
		return employeeService.findByFilter(filter).getResultList();
	}
	
	public void disableEmployee(Employee empl) {
		empl.setSuspended(true);
	}

	public void enableEmployee(Employee empl) {
		empl.setSuspended(false);
	}
	
	public void saveEmployee() {
		employeeService.save(employee);
		RequestContext.getCurrentInstance().closeDialog(employee);
	}
	
	public void editEmployee(Employee employee) {
		this.employee = employee;
//		RequestContext.getCurrentInstance().execute("updateDialog()");
//		RequestContext.getCurrentInstance().execute("edit_dlg.show();");
		
//		Map<String, Object> options = new HashMap<String, Object>();
//    	options.put("contentHeight", 250);
//    	options.put("contentWidth", 400);
//        RequestContext.getCurrentInstance().openDialog("newEmployee", options, null);
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public EmployeeFilter getFilter() {
		return filter;
	}

	public void setFilter(EmployeeFilter filter) {
		this.filter = filter;
	}
	
	public void addNew() {
		
	}
}
