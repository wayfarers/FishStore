package org.genia.fishstore.web;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.genia.fishstore.CustomerOrderFilter;
import org.genia.fishstore.entities.CustomerOrder;
import org.genia.fishstore.entities.CustomerOrderItem;
import org.genia.fishstore.entities.OrderStatus;
import org.genia.fishstore.services.CustomerOrderService;
import org.genia.fishstore.services.FishBatchService;
import org.primefaces.context.RequestContext;
import org.springframework.context.annotation.Scope;
import org.springframework.transaction.annotation.Transactional;

@Named
@Scope("session")
public class AccountantBean {
	
	@Inject
	CustomerOrderService customerOrderService;
	@Inject
	FishBatchService fishbatchService;
	@Inject
	SessionDataBean sessionData;
	
	private CustomerOrder selectedOrder;
	
	public AccountantBean() {
		selectedOrder = new CustomerOrder();
	}
	
	CustomerOrderFilter filter = new CustomerOrderFilter();
	public List<CustomerOrder> getUnpaidOrders() {
//		filter.setUnPayed(true);
		return customerOrderService.findByFilter(filter).getResultList();
	}
	
	public CustomerOrder getSelectedOrder() {
		return selectedOrder;
	}
	public void setSelectedOrder(CustomerOrder selectedOrder) {
		this.selectedOrder = selectedOrder;
		RequestContext.getCurrentInstance().execute("PF('edit_dlg').show()");
	}
	
	public void saveOrder() {
		customerOrderService.save(selectedOrder);
		RequestContext.getCurrentInstance().execute("PF('edit_dlg').hide()");
	}
	
	public void approve(CustomerOrder order) {
		customerOrderService.approveOrder(order, sessionData.getLoggedInEmployee());
	}
	
	public boolean isPayedEnough(CustomerOrder order) {
		return (order.getTotalSum() * order.getCustomer().getPrepaymentRights() / 100 >= order.getSumPayed());
	}
}
