package org.genia.fishstore.dao;

import org.genia.fishstore.entities.Employee;

public interface EmployeeDao extends GenericDao<Employee> {
	public Employee findByLogin(String login);
}
