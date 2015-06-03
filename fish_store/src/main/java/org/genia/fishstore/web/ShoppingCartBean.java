package org.genia.fishstore.web;

import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.genia.fishstore.entities.CustomerOrder;
import org.genia.fishstore.services.FishBatchService;

@Named
@SessionScoped
public class ShoppingCartBean {
	
	@Inject
	FishBatchService fishBatchService;
	
	private CustomerOrder order;
	//private List<CustomerOrderItem> items;
	
	public ShoppingCartBean() {
		order = new CustomerOrder();
		//items = new ArrayList<>();
	}
	
	public void addToCart(int fishBatchId, int weight) {
		order.addFishBatch(fishBatchService.findById(fishBatchId), weight);
	}
	
	public void removeFromCart(int fishBatchId) {
		order.removeFishBatch(fishBatchId);
	}
	
	
}
