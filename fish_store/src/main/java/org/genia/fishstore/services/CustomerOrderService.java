package org.genia.fishstore.services;

import java.util.Date;
import java.util.List;

import org.genia.fishstore.CustomerOrderFilter;
import org.genia.fishstore.entities.CustomerOrder;
import org.genia.fishstore.entities.CustomerOrderItem;
import org.genia.fishstore.entities.FishType;
import org.genia.fishstore.entities.IncomeReport;
import org.genia.fishstore.entities.PaginatedResult;

public interface CustomerOrderService extends GenericService<CustomerOrder>{
//	public void updateOrderList(int orderId, List<CompanyOrderItem> items);		//implement later. There is a question bout type of parameters.
	public List<CustomerOrderItem> getOrderList(int orderId);
	public IncomeReport<Date> generateReportByDates();
	public IncomeReport<FishType> generateReportByFishTypes();
	public PaginatedResult<CustomerOrder> findByFilter(CustomerOrderFilter filter);
}
