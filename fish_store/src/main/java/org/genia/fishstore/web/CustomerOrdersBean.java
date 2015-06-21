package org.genia.fishstore.web;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.genia.fishstore.entities.CustomerOrder;
import org.genia.fishstore.services.CustomerOrderService;
import org.springframework.context.annotation.Scope;

@Named
@Scope("request")
public class CustomerOrdersBean {

	@Inject
	SessionDataBean sessionData;
	
	@Inject
	CustomerOrderService customerOrderService;
	
	private List<CustomerOrder> orders;
	
	@PostConstruct
	private void init() {
		orders = customerOrderService.getCustomerOrders(sessionData.getLoggedInCustomer().getId());
	}
	
	public List<CustomerOrder> getOrders() {
		return orders;
	}
}
