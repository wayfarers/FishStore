package org.genia.fishstore.services;

import java.util.List;

import org.genia.fishstore.entities.Employee;

public interface EmployeeService extends GenericService<Employee>{
	
	// Probably, all these four method will be removed
	public Employee findByLogin(String login);
	public void suspendById(int id);
	public void unSuspendById(int id);
	public List<Employee> getEmployeeList();
	
	
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
