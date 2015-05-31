package org.genia.fishstore.services;

import org.genia.fishstore.ParcelFilter;
import org.genia.fishstore.entities.CompanyOrderItem;
import org.genia.fishstore.entities.PaginatedResult;

public interface CompanyOrderItemService extends GenericService<CompanyOrderItem> {
	// TODO: Implement query useful for a customer. Order does not make sense for him.
	public PaginatedResult<CompanyOrderItem> findByFilter(ParcelFilter filter);
}
