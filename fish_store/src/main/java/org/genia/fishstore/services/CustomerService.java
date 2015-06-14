package org.genia.fishstore.services;

import java.util.List;

import org.genia.fishstore.entities.Customer;


public interface CustomerService extends GenericService<Customer> {
	public Customer findByLogin(String login);
	public Customer authentificate(String login, String password);
	public List<Customer> findAll();
}
