package org.genia.fishstore.services;

import java.util.List;

import org.genia.fishstore.entities.CompanyOrderItem;
import org.genia.fishstore.entities.CustomerOrderItem;

public interface CustomerOrderService {
//	public void updateOrderList(int orderId, List<CompanyOrderItem> items);		//implement later. There is a question bout type of parameters.
	public List<CustomerOrderItem> getOrderList(int orderId);
}
