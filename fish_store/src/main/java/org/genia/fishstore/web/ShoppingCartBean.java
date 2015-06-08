package org.genia.fishstore.web;

import javax.faces.application.FacesMessage;
import javax.inject.Inject;
import javax.inject.Named;

import org.genia.fishstore.entities.CustomerOrder;
import org.genia.fishstore.entities.FishBatch;
import org.genia.fishstore.services.CustomerOrderService;
import org.genia.fishstore.services.FishBatchService;
import org.primefaces.context.RequestContext;
import org.springframework.context.annotation.Scope;

@Named
@Scope("session")
// TODO: Session scope does not work as expected.
public class ShoppingCartBean {
	
	@Inject
	FishBatchService fishBatchService;
	@Inject
	CustomerOrderService customerOrderService;
	@Inject
	SessionDataBean sessionData;
	
	private CustomerOrder order;
	
	private FishBatch fishBatchSelected;
	
	private int weightSelected;
	
	public ShoppingCartBean() {
		order = new CustomerOrder();
	}
	
	public void addToCart() {
		order.addFishBatch(fishBatchSelected, weightSelected);
		RequestContext.getCurrentInstance().closeDialog(fishBatchSelected);
	}
	
	public String removeFromCart(int fishBatchId) {
		order.removeFishBatch(fishBatchId);
		return "shoppingCart.xhtml?faces-redirect=true";
		
	}

	public CustomerOrder getOrder() {
		return order;
	}

	public void setOrder(CustomerOrder order) {
		this.order = order;
	}

	public int getWeightSelected() {
		return weightSelected;
	}

	public void setWeightSelected(int weightSelected) {
		this.weightSelected = weightSelected;
	}

	public FishBatch getFishBatchSelected() {
		return fishBatchSelected;
	}

	public void setFishBatchSelected(FishBatch fishBatchSelected) {
		this.fishBatchSelected = fishBatchSelected;
	}
	
	public String submitOrder() {
		if (sessionData.getLoggedInCustomer() == null) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Submit error", "Please login to submit an order.");
			RequestContext.getCurrentInstance().showMessageInDialog(message);
		} else {
			customerOrderService.save(order);
			order = new CustomerOrder();
			return "filter.xhtml?faces-redirect=true";
		}
		
		return null;
	}
}
