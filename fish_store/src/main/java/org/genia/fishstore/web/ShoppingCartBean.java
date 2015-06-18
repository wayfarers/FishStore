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
// TODO: When adding an item to cart, (1) show a growl, (2) make sure the top info is updated.
public class ShoppingCartBean {
	
	@Inject
	FishBatchService fishBatchService;
	@Inject
	CustomerOrderService customerOrderService;
	@Inject
	SessionDataBean sessionData;
	
	private CustomerOrder order;
	
	private FishBatch fishBatchSelected;
	
	private Integer weightSelected;
	
	public ShoppingCartBean() {
		order = new CustomerOrder();
	}
	
	public void addToCart() {
		order.addFishBatch(fishBatchSelected, weightSelected);
		weightSelected = null;
	}
	
	public String removeFromCart(int fishBatchId) {
		order.removeFishBatch(fishBatchId);
		return "shoppingCart.xhtml?faces-redirect=true";
		
	}

	public String submitOrder() {
		if (sessionData.getLoggedInCustomer() == null) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Submit error", "Please login to submit an order.");
			RequestContext.getCurrentInstance().showMessageInDialog(message);
		} else {
			order.setCustomer(sessionData.getLoggedInCustomer());
			customerOrderService.save(order);
			order = new CustomerOrder();
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Submitting..", "Submit succesful!.");
			RequestContext.getCurrentInstance().showMessageInDialog(message);
			return "customerOrders.xhtml?faces-redirect=true";
		}
		
		return null;
	}
	
	public CustomerOrder getOrder() {
		return order;
	}

	public void setOrder(CustomerOrder order) {
		this.order = order;
	}

	public Integer getWeightSelected() {
		return weightSelected;
	}

	public void setWeightSelected(Integer weightSelected) {
		this.weightSelected = weightSelected;
	}

	public FishBatch getFishBatchSelected() {
		return fishBatchSelected;
	}

	public void setFishBatchSelected(FishBatch fishBatchId) {
		this.fishBatchSelected = fishBatchId;//fishBatchService.findById(fishBatchId);
		weightSelected = null;
	}
}
