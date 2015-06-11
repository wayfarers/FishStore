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
public class BossBean {
	
	@Inject
	FishBatchService fishBatchService;
	@Inject
	PurchaseOrderService purchaseService;
	
	public List<FishBatch> getFishBatches() {
		return fishBatchService.findByFilter(null).getResultList();
	}
	
	public List<PurchaseOrder> getPurchaseOrders() {
		return purchaseService.findAll();
	}
}
