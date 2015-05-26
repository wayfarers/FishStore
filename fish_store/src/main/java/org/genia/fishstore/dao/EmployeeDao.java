package org.genia.fishstore.dao;

import org.genia.fishstore.EmployeeFilter;
import org.genia.fishstore.entities.Employee;
import org.genia.fishstore.entities.PaginatedResult;

public interface EmployeeDao extends GenericDao<Employee> {
	public Employee findByLogin(String login);
	public PaginatedResult<Employee> findByFilter(EmployeeFilter filter);
}
