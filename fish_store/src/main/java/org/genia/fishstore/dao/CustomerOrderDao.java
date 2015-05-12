package org.genia.fishstore.dao;

import java.util.List;

import org.genia.fishstore.entities.CustomerOrder;

public interface CustomerOrderDao extends GenericDao<CustomerOrder>{
	public List<CustomerOrder> getCustomerOrders(int customerId);
}
