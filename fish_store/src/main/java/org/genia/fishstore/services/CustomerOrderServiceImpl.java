package org.genia.fishstore.services;

import java.util.List;

import javax.inject.Inject;

import org.genia.fishstore.dao.CustomerOrderDao;
import org.genia.fishstore.entities.CompanyOrderItem;
import org.genia.fishstore.entities.CustomerOrder;
import org.genia.fishstore.entities.CustomerOrderItem;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CustomerOrderServiceImpl extends GenericServiceImpl<CustomerOrder> implements CustomerOrderService {

	@Inject
	CustomerOrderDao dao;
	
	@Inject
	public CustomerOrderServiceImpl(CustomerOrderDao dao) {
		super(dao, CustomerOrder.class);
	}
	

	@Override
	public void updateOrderList(List<CompanyOrderItem> items) {
		CustomerOrder order = dao
	}

	@Override
	public List<CustomerOrderItem> getOrderDetails() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeItemById(int id) {
		// TODO Auto-generated method stub
		
	}
	
	
//	@RequestMappinog("/saveOrder")
//	public void saveOrder(Long orderId, Long[] itemIds, Long[] qty, Long[] companyOrderItemIds, boolean[] isDeleted) {
//		// Option 1
//		service.saveOrder(orderId, itemIds, qty, companyOrderItemIds);
//		
//		// Option 2
//		Order order = service.findById(orderId);
//		for (int i = 0; i < itemIds.length; i++) {
//			if (isDeleted[i]) {
//				service.removeItemById(itemIds[i]);
//			} else {
//				OrderItem item = order.findItemById(itemIds[i]);
//				item.qty = qty[i];
//			}
//		}
//		
//	}
	

}
