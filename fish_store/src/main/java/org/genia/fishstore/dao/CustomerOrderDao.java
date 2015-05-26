package org.genia.fishstore.dao;

import java.util.List;

import org.genia.fishstore.CustomerOrderFilter;
import org.genia.fishstore.entities.CustomerOrder;
import org.genia.fishstore.entities.PaginatedResult;

public interface CustomerOrderDao extends GenericDao<CustomerOrder>{
	public List<CustomerOrder> getCustomerOrders(int customerId);
	public PaginatedResult<CustomerOrder> findByFilter(CustomerOrderFilter filter);
}
