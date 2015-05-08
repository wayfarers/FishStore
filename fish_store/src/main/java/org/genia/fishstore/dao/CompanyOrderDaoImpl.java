package org.genia.fishstore.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.genia.fishstore.entities.CompanyOrder;
import org.genia.fishstore.entities.CompanyOrderItem;
import org.springframework.stereotype.Repository;

@Repository
public class CompanyOrderDaoImpl implements CompanyOrderDao {

	@PersistenceContext
	EntityManager em;
	
	@Override
	public List<CompanyOrderItem> getAvailableItems() {
		return em.createQuery("select coi from CompanyOrderItem coi", CompanyOrderItem.class).getResultList();
	}

	@Override
	public CompanyOrder findById(int id) {
		return em.find(CompanyOrder.class, id);
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

	@Override
	public String generateReportByDates() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String generateReportByFishTypes() {
		// TODO Auto-generated method stub
		return null;
	}
}
