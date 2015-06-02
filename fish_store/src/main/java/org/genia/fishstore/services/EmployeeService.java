package org.genia.fishstore.services;

import org.genia.fishstore.EmployeeFilter;
import org.genia.fishstore.entities.Employee;
import org.genia.fishstore.entities.PaginatedResult;

public interface EmployeeService extends GenericService<Employee>{
	
	public Employee findByLogin(String login);
	public PaginatedResult<Employee> findByFilter(EmployeeFilter filter);
	public Employee authentificate(String login, String password);
	
	
	// public void authentificate(String login, String password) throws InvalidAuthentificationException;
	// public void updateEmployeeInfo(Employee employee, int employeeId);
}

/**
 * 
 * User (Browser)
 * 
 * Controller
 * 
 * Service Service Service // Can a service use DAOs of other entities, or should it use its service?
 * 
 * DAO DAO DAO
 * 
 * EntityManager, JPA
 * 
 * JDBC
 * 
 */
