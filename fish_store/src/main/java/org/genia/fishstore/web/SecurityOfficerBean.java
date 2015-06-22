package org.genia.fishstore.web;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
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
	private List<Employee> employees;
	
	@Inject
	EmployeeService employeeService;
	
	@PostConstruct
	private void init() {
		employees = employeeService.findByFilter(filter).getResultList();
	}
	
	public SecurityOfficerBean() {
		employee = new Employee();
		filter = new EmployeeFilter();
	}
	
	public List<Employee> getEmployees() {
		return employees;
	}
	
	public void disableEmployee(Employee empl) {
		empl.setSuspended(true);
	}

	public void enableEmployee(Employee empl) {
		empl.setSuspended(false);
	}
	
	public void saveEmployee() {
		Integer id = employee.getId();
		if (id == null) {
			saveNew();
			return;
		}
		employeeService.save(employee);
		employee = new Employee();
		RequestContext.getCurrentInstance().execute("PF('edit_dlg').hide()");
	}
	
	public void editEmployee(Employee employee) {
		this.employee = employee;
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
		employee = new Employee();
	}
	
	private void saveNew() {
		if (employeeService.findByLogin(employee.getLogin()) != null) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Such login is already used.", null));
			employee.setLogin(null);
			return;
		}
		employeeService.save(employee);
		init();
		employee = new Employee();
		RequestContext.getCurrentInstance().execute("PF('edit_dlg').hide()");
	}
}
