package org.genia.fishstore.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.genia.fishstore.entities.CompanyOrder;
import org.genia.fishstore.entities.CompanyOrderItem;
import org.springframework.stereotype.Repository;

@Repository
public class CompanyOrderDaoImpl extends GenericDaoImpl<CompanyOrder> implements CompanyOrderDao {

	public CompanyOrderDaoImpl() {
		super(CompanyOrder.class);
	}
	
	@Override
	public List<CompanyOrderItem> getAllItems(int id) {
		return em.createQuery("select coi from CompanyOrderItem coi", CompanyOrderItem.class).getResultList();
	}

	@Override
	public CompanyOrder findById(int id) {
		return em.find(entityClass, id);
	}

	@Override
	public void save(CompanyOrder entity) {
		em.persist(entity);
	}
	//---move to service---
//	@Override
//	public void acceptOnStore(int orderId, int coldStoreManagerId) {
//		CompanyOrder order = em.find(CompanyOrder.class, orderId);
//		
//		order.set
//	}
}
