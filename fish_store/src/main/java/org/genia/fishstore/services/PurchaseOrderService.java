package org.genia.fishstore.services;

import java.util.List;

import org.genia.fishstore.entities.FishBatch;
import org.genia.fishstore.entities.PurchaseOrder;

public interface PurchaseOrderService extends GenericService<PurchaseOrder> {
	
	public List<PurchaseOrder> findAll();
	public List<FishBatch> getOrderItems(int orderId);
}

// TODO: Fish profile page
// URL: /fish/345 - ID, name, later - some statistics about sales

// TODO: Client profile
// URL: /client/4545 - Client info, statistics, last login date
