package org.genia.fishstore.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.genia.fishstore.entities.CompanyOrderItem;
import org.springframework.stereotype.Repository;

@Repository
public class CompanyOrderItemDaoImpl extends GenericDaoImpl<CompanyOrderItem> implements CompanyOrderItemDao {

	public CompanyOrderItemDaoImpl() {
		super(CompanyOrderItem.class);
	}
	@Override
	public List<CompanyOrderItem> getAvailableItems(int id) {
		TypedQuery<CompanyOrderItem> query =  em.createQuery("select coi from CompanyOrderItem coi where coi.id = :orderId", 
				entityClass);
		query.setParameter("orderId", id);
		return query.getResultList();
	}

}
