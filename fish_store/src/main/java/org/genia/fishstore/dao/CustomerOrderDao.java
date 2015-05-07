package org.genia.fishstore.dao;

import java.util.List;

import org.genia.fishstore.entities.CustomerOrderItem;

public interface CustomerOrderDao {
	public List<CustomerOrderItem> getOrderDetails();		//needed?
	public void removeItemById(int id);
	public void removeOrderById(int id);
}
