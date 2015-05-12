package org.genia.fishstore.services;

import java.util.List;

import org.genia.fishstore.entities.CustomerOrder;
import org.genia.fishstore.entities.CustomerOrderItem;

public interface CustomerOrderService extends GenericService<CustomerOrder>{
//	public void updateOrderList(int orderId, List<CompanyOrderItem> items);		//implement later. There is a question bout type of parameters.
	public List<CustomerOrderItem> getOrderList(int orderId);
}
