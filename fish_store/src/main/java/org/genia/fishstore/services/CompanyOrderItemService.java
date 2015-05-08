package org.genia.fishstore.services;

import java.util.List;

import org.genia.fishstore.entities.CompanyOrderItem;

public interface CompanyOrderItemService {
	public List<CompanyOrderItem> getAvailableItems(int id);
}
