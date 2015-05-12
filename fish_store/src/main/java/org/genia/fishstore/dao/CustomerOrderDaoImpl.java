package org.genia.fishstore.dao;

import java.util.List;

import javax.inject.Inject;

import org.genia.fishstore.entities.CustomerOrder;
import org.genia.fishstore.services.CustomerService;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerOrderDaoImpl extends GenericDaoImpl<CustomerOrder> implements CustomerOrderDao {

	@Inject
	CustomerService customerService;
	
	public CustomerOrderDaoImpl() {
		super(CustomerOrder.class);
	}

	@Override
	public List<CustomerOrder> getCustomerOrders(int customerId) {
		return customerService.findById(customerId).getOrders();
	}

}
