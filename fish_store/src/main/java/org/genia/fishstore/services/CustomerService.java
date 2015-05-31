package org.genia.fishstore.services;

import org.genia.fishstore.entities.Customer;


public interface CustomerService extends GenericService<Customer> {
	public Customer findByLogin(String login);
}
