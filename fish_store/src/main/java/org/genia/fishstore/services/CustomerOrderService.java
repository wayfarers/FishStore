package org.genia.fishstore.services;

import java.util.List;

import org.genia.fishstore.entities.CompanyOrderItem;
import org.genia.fishstore.entities.CustomerOrderItem;

public interface CustomerOrderService {
	public void updateOrderList(int orderId, List<CompanyOrderItem> items);
	public List<CustomerOrderItem> getOrderDetails(int orderId);
	public void removeItemById(int id);
}
