package org.genia.fishstore.web;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.genia.fishstore.entities.CustomerOrder;
import org.genia.fishstore.services.CustomerOrderService;
import org.springframework.context.annotation.Scope;

@Named
@Scope("session")
public class CustomerOrdersBean {

	@Inject
	CustomerOrderService customerOrderService;
	
	private CustomerOrder currentOrder;
	
	public List<CustomerOrder> getOrders() {
		return customerOrderService.findByFilter(null).getResultList();
	}
	
	public String orderDetails(CustomerOrder order) {
		currentOrder = order;
		return "orderDetails.xhtml?faces-redirect=true";
	}

	public CustomerOrder getCurrentOrder() {
		return currentOrder;
	}

	public void setCurrentOrder(CustomerOrder currentOrder) {
		this.currentOrder = currentOrder;
	}
	
	
}
