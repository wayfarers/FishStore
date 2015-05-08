package org.genia.fishstore.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.genia.fishstore.entities.Employee;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDaoImpl extends GenericDaoImpl<Employee> implements EmployeeDao{

	public EmployeeDaoImpl() {
		super(Employee.class);
	}
	
	@Override
	public Employee findByLogin(String login) {
		TypedQuery<Employee> query = em.createQuery("select emp from Employee emp where emp.login = :login", entityClass);
		query.setParameter("login", login);
		return query.getSingleResult();
	}

	@Override
	public void suspendById(int id) {
		Employee employee = em.find(entityClass, id);
		employee.setSuspended(true);
	}
	
	@Override
	public void unSuspendById(int id) {
		Employee employee = em.find(entityClass, id);
		employee.setSuspended(false);
	}

	@Override
	public List<Employee> getEmployeeList() {
		return em.createQuery("select empl from Employee empl", entityClass).getResultList();
	}

}
