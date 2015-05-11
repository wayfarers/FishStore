package org.genia.fishstore.services;

import java.util.List;

import org.genia.fishstore.entities.CompanyOrderItem;

public interface CompanyOrderItemService {
	// TODO: Implement query useful for a customer. Order does not make sense for him.
	public List<CompanyOrderItem> getAvailableItems(int id);
}
