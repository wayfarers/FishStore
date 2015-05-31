package org.genia.fishstore.dao;

import java.util.List;

import org.genia.fishstore.entities.CompanyOrder;
import org.genia.fishstore.entities.CompanyOrderItem;

public interface CompanyOrderDao extends GenericDao<CompanyOrder> {
	public List<CompanyOrderItem> getOrderItems(int orderId);
	public List<CompanyOrder> getOrders();
	
}
