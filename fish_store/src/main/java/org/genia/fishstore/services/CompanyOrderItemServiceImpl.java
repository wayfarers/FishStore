package org.genia.fishstore.services;

import javax.inject.Inject;

import org.genia.fishstore.ParcelFilter;
import org.genia.fishstore.dao.CompanyOrderItemDao;
import org.genia.fishstore.entities.CompanyOrderItem;
import org.genia.fishstore.entities.PaginatedResult;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CompanyOrderItemServiceImpl extends GenericServiceImpl<CompanyOrderItem> implements CompanyOrderItemService {

	private CompanyOrderItemDao dao;
	
	@Inject
	public CompanyOrderItemServiceImpl(CompanyOrderItemDao dao) {
		super(dao, CompanyOrderItem.class);
		this.dao = dao;
	}
	
	@Override
	public PaginatedResult<CompanyOrderItem> findByFilter(ParcelFilter filter) {
		return dao.findByFilter(filter);
	}

}
