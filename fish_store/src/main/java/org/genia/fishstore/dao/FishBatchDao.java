package org.genia.fishstore.dao;

import java.util.List;

import org.genia.fishstore.ParcelFilter;
import org.genia.fishstore.entities.FishBatch;
import org.genia.fishstore.entities.PaginatedResult;


public interface FishBatchDao extends GenericDao<FishBatch> {
	// TODO: Implement query useful for a customer. Order does not make sense for him.
	public List<FishBatch> getAvailableItems();
	public PaginatedResult<FishBatch> findByFilter(ParcelFilter filter);
	
	
}
