package org.genia.fishstore.web;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.genia.fishstore.CustomerOrderFilter;
import org.genia.fishstore.entities.CustomerOrder;
import org.genia.fishstore.services.CustomerOrderService;
import org.springframework.context.annotation.Scope;

@Named
@Scope("session")
public class AccountantBean {
	
	@Inject
	CustomerOrderService customerOrderService;
	
	CustomerOrderFilter filter = new CustomerOrderFilter();
	public List<CustomerOrder> getCustomerOrders(CustomerOrderFilter filter) {
		filter.setUnPayed(true);
		return customerOrderService.findByFilter(filter).getResultList();
	}
}
