package org.genia.fishstore.dao;

import org.genia.fishstore.entities.Customer;

public interface CustomerDao extends GenericDao<Customer> {
	public Customer findByLogin(String login);
}
