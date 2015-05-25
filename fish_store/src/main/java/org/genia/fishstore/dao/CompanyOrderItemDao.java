package org.genia.fishstore.dao;

import java.util.List;

import org.genia.fishstore.ParcelFilter;
import org.genia.fishstore.entities.CompanyOrderItem;
import org.genia.fishstore.entities.GenericResult;


public interface CompanyOrderItemDao extends GenericDao<CompanyOrderItem> {
	// TODO: Implement query useful for a customer. Order does not make sense for him.
	public List<CompanyOrderItem> getAvailableItems();
	
	public GenericResult<CompanyOrderItem> findByFilter(ParcelFilter filter);
}
