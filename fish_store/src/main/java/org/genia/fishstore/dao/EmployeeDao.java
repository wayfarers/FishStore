package org.genia.fishstore.dao;

import org.genia.fishstore.EmployeeFilter;
import org.genia.fishstore.entities.Employee;
import org.genia.fishstore.entities.GenericResult;

public interface EmployeeDao extends GenericDao<Employee> {
	public Employee findByLogin(String login);
	public GenericResult<Employee> findByFilter(EmployeeFilter filter);
}
