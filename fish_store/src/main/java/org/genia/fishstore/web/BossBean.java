package org.genia.fishstore.web;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.genia.fishstore.entities.FishBatch;
import org.genia.fishstore.entities.FishType;
import org.genia.fishstore.entities.PurchaseOrder;
import org.genia.fishstore.services.FishBatchService;
import org.genia.fishstore.services.FishTypeService;
import org.genia.fishstore.services.PurchaseOrderService;
import org.springframework.context.annotation.Scope;

@Named
@Scope("session")
public class BossBean {
	
	PurchaseOrder currentOrder;
	List<FishType> fishList;
	
	@Inject
	FishBatchService fishBatchService;
	@Inject
	PurchaseOrderService purchaseService;
	@Inject
	FishTypeService fishTypeService;
	
	private List<FishBatch> orderItems;
	
	public List<FishBatch> getFishBatches() {
		return fishBatchService.findByFilter(null).getResultList();
	}
	
	public List<PurchaseOrder> getPurchaseOrders() {
		return purchaseService.findAll();
	}
	
	public List<FishBatch> getItems(int orderId) {
		return purchaseService.getOrderItems(orderId);
	}
	
	public String editOrder(PurchaseOrder order) {
		currentOrder = order;
		orderItems = getItems(order.getId());
		return "editPurchase.xhtml?faces-redirect=true";
	}

	public List<FishBatch> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<FishBatch> orderItems) {
		this.orderItems = orderItems;
	}
	
	public void saveChanges() {
		purchaseService.save(currentOrder);
		
		
		for (FishBatch fishBatch : orderItems) {
			fishBatch.setOrder(currentOrder);
			fishBatchService.save(fishBatch);
		}
	}
	
	public String newOrder() {
		currentOrder = new PurchaseOrder();
		orderItems = new ArrayList<>();
		orderItems.add(new FishBatch());
		
		return "editPurchase.xhtml?faces-redirect=true";
	}
	
	public void addItem() {
		FishBatch newItem = new FishBatch();
		orderItems.add(newItem);
	}
	
	public List<FishType> getFishList() {
		fishList = fishTypeService.getFishList();
		return fishList;
	}
}
