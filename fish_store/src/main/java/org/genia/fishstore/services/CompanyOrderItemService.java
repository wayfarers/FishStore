package org.genia.fishstore.services;

import java.util.List;

import org.genia.fishstore.ParcelFilter;
import org.genia.fishstore.entities.CompanyOrderItem;
import org.genia.fishstore.entities.PaginatedResult;

public interface CompanyOrderItemService extends GenericService<CompanyOrderItem> {
	// TODO: Implement query useful for a customer. Order does not make sense for him.
	public List<CompanyOrderItem> getAvailableItems(int id);
	public PaginatedResult<CompanyOrderItem> findByFilter(ParcelFilter filter);
}
