package org.genia.fishstore.services;

import java.util.List;

import javax.inject.Inject;

import org.genia.fishstore.dao.FishTypeDao;
import org.genia.fishstore.entities.FishType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class FishTypeServiceImpl extends GenericServiceImpl<FishType> implements FishTypeService {
	
	@Inject
	FishTypeDao dao;
	
	@Inject
	public FishTypeServiceImpl(FishTypeDao dao) {
		super(dao, FishType.class);
		this.dao = dao;
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
