package org.genia.fishstore.dao;

import java.util.List;

import org.genia.fishstore.entities.CompanyOrderItem;


public interface CompanyOrderItemDao extends GenericDao<CompanyOrderItem> {
	// TODO: Implement query useful for a customer. Order does not make sense for him.
	public List<CompanyOrderItem> getAvailableItems();
}
