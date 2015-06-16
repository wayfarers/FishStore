package org.genia.fishstore.web;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.genia.fishstore.entities.FishBatch;
import org.genia.fishstore.entities.PurchaseOrder;
import org.genia.fishstore.services.FishBatchService;
import org.genia.fishstore.services.PurchaseOrderService;
import org.springframework.context.annotation.Scope;

@Named
@Scope("session")
public class ColdStoreBean {
	
	@Inject
	SessionDataBean sessionData;
	@Inject
	FishBatchService fishBatchService;
	@Inject
	PurchaseOrderService purchaseOrderService;
	
	
	public List<FishBatch> getFishBatches() {
		return fishBatchService.findByFilter(null).getResultList();
	}
	
	public void accept(PurchaseOrder order) {
	}
	
	public List<PurchaseOrder> getPurchaseOrders() {
		return purchaseOrderService.findAll();
	}
}
