package org.genia.fishstore.dao;

import java.util.List;

import org.genia.fishstore.entities.CompanyOrder;
import org.genia.fishstore.entities.CompanyOrderItem;
import org.genia.fishstore.entities.CustomerOrder;

public class CustomerOrderDaoImpl extends GenericDaoImpl<CustomerOrder> implements CustomerOrderDao {

	public CustomerOrderDaoImpl() {
		super(CustomerOrder.class);
	}
	
//		---move to service---
//	@Override
//	public List<CustomerOrderItem> getOrderDetails() {
//		// TODO Auto-generated method stub
//		return null;
//	}

//	@Override
//	public void removeItemById(int id) {
//		// TODO Auto-generated method stub
//	}

	@Override
	public void removeOrderById(int id) {
		CustomerOrder order = em.find(entityClass, id);
		em.remove(order);
	}

	@Override
	public void updateOrderList(List<CompanyOrderItem> items) {
		
	}

}
