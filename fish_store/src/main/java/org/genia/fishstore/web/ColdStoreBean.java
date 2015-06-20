package org.genia.fishstore.web;

import java.util.Calendar;
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
public class ColdStoreBean {
	
	@Inject
	SessionDataBean sessionData;
	@Inject
	FishBatchService fishBatchService;
	@Inject
	PurchaseOrderService purchaseOrderService;
	@Inject
	FishTypeService fishTypeService;
	
	List<FishType> fishList;
	
	private PurchaseOrder selectedOrder;
	
	private List<FishBatch> orderItems;
	
	private void prepareDetails(PurchaseOrder order) {
		selectedOrder = order;
		orderItems = purchaseOrderService.getOrderItems(order.getId());
	}
	
	public String accept(PurchaseOrder order) {
		prepareDetails(order);
		return "admin/acceptOnStore.xhtml?faces-redirect=true";
	}
	
	public String manage(PurchaseOrder order) {
		prepareDetails(order);
		return "admin/managePurchases.xhtml?faces-redirect=true";
	}
	
	public List<PurchaseOrder> getPurchaseOrders() {
		return purchaseOrderService.findAll();
	}
	
	public List<FishBatch> getFishBatches() {
		return fishBatchService.findByFilter(null).getResultList();
	}
	
	public PurchaseOrder getSelectedOrder() {
		return selectedOrder;
	}

	public void setSelectedOrder(PurchaseOrder selectedOrder) {
		this.selectedOrder = selectedOrder;
	}
	
	public void saveChanges() {
		selectedOrder.setDateArrived(Calendar.getInstance().getTime());
		for (FishBatch fishBatch : orderItems) {
			fishBatch.setWeightLeft(fishBatch.getWeightArrived());
		}
		selectedOrder.setColdStoreManager(sessionData.getLoggedInEmployee());
		for (FishBatch fishBatch : orderItems) {
			fishBatchService.save(fishBatch);
		}
		purchaseOrderService.save(selectedOrder);
	}
	
	public List<FishBatch> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<FishBatch> orderItems) {
		this.orderItems = orderItems;
	}

	public void addItem() {
		FishBatch newItem = new FishBatch();
		newItem.setOrder(selectedOrder);
		orderItems.add(newItem);
	}
	
	public List<FishType> getFishList() {
		fishList = fishTypeService.getFishList();
		return fishList;
	}
	
	public void writeOff(FishBatch batch) {
		fishBatchService.writeOff(batch);
	}
}
