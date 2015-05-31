package org.genia.fishstore.dao;

import java.util.List;

import org.genia.fishstore.entities.CompanyOrder;
import org.genia.fishstore.entities.CompanyOrderItem;
import org.springframework.stereotype.Repository;

@Repository
public class CompanyOrderDaoImpl extends GenericDaoImpl<CompanyOrder> implements CompanyOrderDao {

	public CompanyOrderDaoImpl() {
		super(CompanyOrder.class);
	}
	
	@Override
	public List<CompanyOrderItem> getOrderItems(int orderId) {
		return em.createQuery("select coi from CompanyOrderItem coi where coi.id = :orderId", CompanyOrderItem.class)
				.setParameter("orderId", orderId)
				.getResultList();
	}

	@Override
	public List<CompanyOrder> getOrders() {
		return em.createQuery("select coi from CompanyOrderItem coi", CompanyOrder.class).getResultList();
	}
	
}
