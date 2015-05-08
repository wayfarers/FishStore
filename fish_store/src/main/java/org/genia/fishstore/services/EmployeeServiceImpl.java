package org.genia.fishstore.services;

import java.util.List;

import javax.inject.Inject;

import org.genia.fishstore.dao.EmployeeDao;
import org.genia.fishstore.entities.Employee;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EmployeeServiceImpl extends GenericServiceImpl<Employee> implements
		EmployeeService {
	
	@Inject
	private EmployeeDao dao;
	
	@Inject
	public EmployeeServiceImpl(EmployeeDao dao) {
		super(dao, Employee.class);
	}
	
	@Override
	public Employee findByLogin(String login) {
		return dao.findByLogin(login);
	}

	@Override
	public void suspendById(int id) {
		dao.suspendById(id);
	}

	@Override
	public void unSuspendById(int id) {
		dao.unSuspendById(id);
	}

	@Override
	public List<Employee> getEmployeeList() {
		return dao.getEmployeeList();
	}

}
