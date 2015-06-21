package org.genia.fishstore.web;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.genia.fishstore.entities.FishBatch;
import org.genia.fishstore.services.FishBatchService;

@Named
@ViewScoped
public class RestOnStockBean {
	@Inject
	FishBatchService fishBatchService;
	
	private List<FishBatch> orderItems;
	
	@PostConstruct
	private void init() {
		orderItems = fishBatchService.findByFilter(null).getResultList();
	}
	
	public List<FishBatch> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<FishBatch> orderItems) {
		this.orderItems = orderItems;
	}
	
}

