package org.genia.fishstore.services;

import java.util.List;

import org.genia.fishstore.entities.Employee;

public interface EmployeeService extends GenericService<Employee>{
	public Employee findByLogin(String login);
	public void suspendById(int id);
	public void unSuspendById(int id);
	public List<Employee> getEmployeeList();
}
