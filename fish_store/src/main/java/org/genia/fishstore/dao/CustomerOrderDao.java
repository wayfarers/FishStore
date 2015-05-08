package org.genia.fishstore.dao;

import java.util.List;

import org.genia.fishstore.entities.CompanyOrderItem;
import org.genia.fishstore.entities.CustomerOrderItem;

public interface CustomerOrderDao {
//	public List<CustomerOrderItem> getOrderDetails();		//move to service
//	public void removeItemById(int id);						//move to service
	public void removeOrderById(int id);
	public void updateOrderList(List<CompanyOrderItem> items);
}
