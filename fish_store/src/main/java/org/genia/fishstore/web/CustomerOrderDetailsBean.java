package org.genia.fishstore.web;

import javax.inject.Named;

import org.genia.fishstore.entities.CustomerOrder;
import org.springframework.context.annotation.Scope;

@Named
@Scope("session")
public class CustomerOrderDetailsBean {

	private CustomerOrder currentOrder;
	
	public String orderDetails(CustomerOrder order) {
		currentOrder = order;
		return "/customer/orderDetails.xhtml?faces-redirect=true";
	}

	public CustomerOrder getCurrentOrder() {
		return currentOrder;
	}

	public void setCurrentOrder(CustomerOrder currentOrder) {
		this.currentOrder = currentOrder;
	}
}
