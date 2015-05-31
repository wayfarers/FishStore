package org.genia.fishstore.services;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.genia.fishstore.dao.CompanyOrderDao;
import org.genia.fishstore.entities.CompanyOrder;
import org.genia.fishstore.entities.FishType;
import org.genia.fishstore.entities.IncomeReport;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CompanyOrderServiceImpl extends GenericServiceImpl<CompanyOrder> implements CompanyOrderService {

	private CompanyOrderDao dao;
	
	@Inject
	public CompanyOrderServiceImpl(CompanyOrderDao dao) {
		super(dao, CompanyOrder.class);
		this.dao = dao;
	}
	
	@Override
	public CompanyOrder findById(int id) {
		return dao.findById(id);
	}

	@Override
	public void save(CompanyOrder entity) {
		dao.save(entity);
	}

	@Override
	public IncomeReport<Date> generateReportByDates() {
		// TODO Income report by dates
		return null;
	}

	@Override
	public IncomeReport<FishType> generateReportByFishTypes() {
		// TODO Income report by fishes
		return null;
	}

}
