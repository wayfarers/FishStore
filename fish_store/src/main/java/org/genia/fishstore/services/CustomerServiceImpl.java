package org.genia.fishstore.services;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.NoResultException;

import org.genia.fishstore.dao.CustomerDao;
import org.genia.fishstore.entities.Customer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CustomerServiceImpl extends GenericServiceImpl<Customer> implements CustomerService {

	private CustomerDao dao;
	
	@Inject
	public CustomerServiceImpl(CustomerDao dao) {
		super(dao, Customer.class);
		this.dao = dao;
	}

	@Override
	public Customer findByLogin(String login) {
		return dao.findByLogin(login);
	}

	@Override
	public Customer authentificate(String login, String password) {
		try {
			Customer customer = dao.findByLogin(login);
			if (customer.getPassword().equals(password)) {
				return customer;
			}
			throw new UnsupportedOperationException("Invalid username or password");
		} catch (NoResultException e) {
			throw new UnsupportedOperationException("Invalid username or password");
		}
	}

	@Override
	public List<Customer> findAll() {
		return dao.findAll();
	}
}
