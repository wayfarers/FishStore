package org.genia.fishstore.dao;

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
		TypedQuery<Employee> query = em.createQuery("select emp from Employee emp where emp.login = :login", Employee.class);
		query.setParameter("login", login);
		return query.getSingleResult();
	}
}
