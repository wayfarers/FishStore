package org.genia.fishstore.dao;

import java.util.Date;
import java.util.List;

import org.genia.fishstore.CustomerOrderFilter;
import org.genia.fishstore.entities.CustomerOrder;
import org.genia.fishstore.entities.FishType;
import org.genia.fishstore.entities.IncomeReport;
import org.genia.fishstore.entities.PaginatedResult;

public interface CustomerOrderDao extends GenericDao<CustomerOrder>{
	public List<CustomerOrder> getCustomerOrders(int customerId);
	public PaginatedResult<CustomerOrder> findByFilter(CustomerOrderFilter filter);
	public IncomeReport<Date> generateReportByDates();
	public IncomeReport<FishType> generateReportByFishTypes();
}
