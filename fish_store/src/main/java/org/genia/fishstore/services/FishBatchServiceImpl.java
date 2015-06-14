package org.genia.fishstore.services;

import java.util.List;

import javax.inject.Inject;

import org.genia.fishstore.ParcelFilter;
import org.genia.fishstore.dao.FishBatchDao;
import org.genia.fishstore.entities.FishBatch;
import org.genia.fishstore.entities.FishType;
import org.genia.fishstore.entities.PaginatedResult;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class FishBatchServiceImpl extends GenericServiceImpl<FishBatch> implements FishBatchService {

	private FishBatchDao dao;
	
	@Inject
	public FishBatchServiceImpl(FishBatchDao dao) {
		super(dao, FishBatch.class);
		this.dao = dao;
	}
	
	@Override
	public PaginatedResult<FishBatch> findByFilter(ParcelFilter filter) {
		return dao.findByFilter(filter);
	}

	@Override
	public List<String> getFishNames() {
		return dao.getFishNames();
	}

	@Override
	public List<FishType> getFishList() {
		return dao.getFishList();
	}
}
