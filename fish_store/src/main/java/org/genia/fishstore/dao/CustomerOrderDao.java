package org.genia.fishstore.dao;

import org.genia.fishstore.entities.CustomerOrder;

public interface CustomerOrderDao extends GenericDao<CustomerOrder>{
	public void getCustomerOrders(int customerId);
}
