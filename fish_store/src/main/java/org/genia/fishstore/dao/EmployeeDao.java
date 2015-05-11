package org.genia.fishstore.dao;

import org.genia.fishstore.entities.Employee;

public interface EmployeeDao extends GenericDao<Employee> {
	public Employee findByLogin(String login);
	//TODO move to the service
//	public void suspendById(int id);
//	public void unSuspendById(int id);
	//TODO move to the generic
//	public List<Employee> getEmployeeList();
}
