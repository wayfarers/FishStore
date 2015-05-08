package org.genia.fishstore.dao;

import java.util.List;

import org.genia.fishstore.entities.CompanyOrderItem;


public interface CompanyOrderItemDao extends GenericDao<CompanyOrderItem> {
//	public void updateOrder();
	public List<CompanyOrderItem> getAvailableItems(int id);
}
