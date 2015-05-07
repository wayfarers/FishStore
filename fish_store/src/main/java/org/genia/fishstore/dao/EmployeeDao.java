package org.genia.fishstore.dao;

import java.util.List;

import org.genia.fishstore.entities.Employee;

public interface EmployeeDao extends GenericDao<Employee> {
	public Employee findByLogin(String login);
	public void suspendById(int id);
	public List<Employee> getEmployeeList();
}
