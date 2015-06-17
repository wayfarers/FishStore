package org.genia.fishstore.services;

import javax.inject.Inject;
import javax.persistence.NoResultException;

import org.genia.fishstore.EmployeeFilter;
import org.genia.fishstore.dao.EmployeeDao;
import org.genia.fishstore.entities.Employee;
import org.genia.fishstore.entities.PaginatedResult;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EmployeeServiceImpl extends GenericServiceImpl<Employee> implements
		EmployeeService {
	
	private EmployeeDao dao;
	
	@Inject
	public EmployeeServiceImpl(EmployeeDao dao) {
		super(dao, Employee.class);
		this.dao = dao;
	}
	
	@Override
	public Employee findByLogin(String login) {
		return dao.findByLogin(login);
	}

	@Override
	public PaginatedResult<Employee> findByFilter(EmployeeFilter filter) {
		return dao.findByFilter(filter);
	}

	@Override
	public Employee authentificate(String login, String password) {
		try {
			Employee employee = dao.findByLogin(login);
			if (employee.getPassword().equals(password) && !employee.getSuspended()) {
				return employee;
			}
			throw new UnsupportedOperationException("Invalid username or password");
		} catch (NoResultException e) {
			throw new UnsupportedOperationException("Invalid username or password");
		}
	}
}
