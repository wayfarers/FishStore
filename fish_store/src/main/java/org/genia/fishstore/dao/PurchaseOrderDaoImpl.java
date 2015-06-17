package org.genia.fishstore.dao;

import java.util.List;

import org.genia.fishstore.entities.PurchaseOrder;
import org.genia.fishstore.entities.FishBatch;
import org.springframework.stereotype.Repository;

@Repository
public class PurchaseOrderDaoImpl extends GenericDaoImpl<PurchaseOrder> implements PurchaseOrderDao {

	public PurchaseOrderDaoImpl() {
		super(PurchaseOrder.class);
	}
	
	//TODO is it needed?
	@Override
	public List<FishBatch> getOrderItems(int orderId) {
		return em.createQuery("select fb from FishBatch fb where fb.order.id = :orderId", FishBatch.class)
				.setParameter("orderId", orderId)
				.getResultList();
	}

	@Override
	public List<PurchaseOrder> getOrders() {
		return em.createQuery("select coi from PurchaseOrder coi", PurchaseOrder.class).getResultList();
	}
	
}
