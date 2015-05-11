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
	public List<CompanyOrderItem> getAvailableItems() {
		return em.createQuery("select coi from CompanyOrderItem coi where coi.onSale = true", 
				CompanyOrderItem.class).getResultList();
	}

}
