package org.genia.fishstore.dao;

import java.util.List;

import org.genia.fishstore.entities.Customer;

public interface CustomerDao extends GenericDao<Customer> {
	public Customer findByLogin(String login);
	
	// TODO: Implement a generic findAll(@Nullable PageInfo pageInfo);
	// This method goes both into generic DAO and service.
	public List<Customer> getCustomerList();
}
