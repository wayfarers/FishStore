package org.genia.fishstore.services;

import org.genia.fishstore.ParcelFilter;
import org.genia.fishstore.entities.FishBatch;
import org.genia.fishstore.entities.PaginatedResult;

public interface FishBatchService extends GenericService<FishBatch> {
	// TODO: Implement query useful for a customer. Order does not make sense for him.
	public PaginatedResult<FishBatch> findByFilter(ParcelFilter filter);
}
