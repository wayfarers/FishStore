package org.genia.fishstore.services;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.genia.fishstore.CustomerOrderFilter;
import org.genia.fishstore.dao.CustomerOrderDao;
import org.genia.fishstore.entities.CustomerOrder;
import org.genia.fishstore.entities.CustomerOrderItem;
import org.genia.fishstore.entities.FishType;
import org.genia.fishstore.entities.IncomeReport;
import org.genia.fishstore.entities.PaginatedResult;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CustomerOrderServiceImpl extends GenericServiceImpl<CustomerOrder> implements CustomerOrderService {

	@Inject
	CustomerOrderDao dao;
	
	@Inject
	public CustomerOrderServiceImpl(CustomerOrderDao dao) {
		super(dao, CustomerOrder.class);
	}
	
	@Override
	public List<CustomerOrderItem> getOrderList(int orderId) {
		return dao.findById(orderId).getItems();
	}

	@Override
	public IncomeReport<Date> generateReportByDates() {
		return dao.generateReportByDates();
	}

	@Override
	public IncomeReport<FishType> generateReportByFishTypes() {
		return dao.generateReportByFishTypes();
	}

	@Override
	public PaginatedResult<CustomerOrder> findByFilter(
			CustomerOrderFilter filter) {
		return dao.findByFilter(filter);
	}

	@Override
	public void approveOrder(CustomerOrder order) {
		// TODO Auto-generated method stub
		
	}
}
