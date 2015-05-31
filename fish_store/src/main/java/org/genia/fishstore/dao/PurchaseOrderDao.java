package org.genia.fishstore.dao;

import java.util.List;

import org.genia.fishstore.entities.PurchaseOrder;
import org.genia.fishstore.entities.FishBatch;

public interface PurchaseOrderDao extends GenericDao<PurchaseOrder> {
	public List<FishBatch> getOrderItems(int orderId);
	public List<PurchaseOrder> getOrders();
	
}
