package org.genia.fishstore.services;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;

import org.genia.fishstore.CustomerOrderFilter;
import org.genia.fishstore.dao.CustomerOrderDao;
import org.genia.fishstore.entities.CustomerOrder;
import org.genia.fishstore.entities.CustomerOrderItem;
import org.genia.fishstore.entities.Employee;
import org.genia.fishstore.entities.FishType;
import org.genia.fishstore.entities.IncomeReport;
import org.genia.fishstore.entities.OrderStatus;
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
	public void approveOrder(CustomerOrder order, Employee approvedBy) {
		order = dao.getFreshCopy(order);
		
		Iterator<CustomerOrderItem> itr = order.getItems().iterator();
		while (itr.hasNext()) {
			CustomerOrderItem item = itr.next();
			int weightLeft = item.getFishBatch().getWeightLeft();
			if (weightLeft >= item.getWeight()) {
				item.getFishBatch().setWeightLeft(weightLeft - item.getWeight());
			} else {
				String newComment = String.format("/nSorry, %s is unavailable. $ %.2f will be returned.", 
						item.getFishBatch().getFishType().getName(), item.getSum());
				order.setComment(order.getComment() + newComment);
				itr.remove();
			}
		}
		
		order.setAccountant(approvedBy);
		order.setStatus(OrderStatus.APPROVED_FOR_SHIPPMENT);
	}

	@Override
	public List<CustomerOrder> getCustomerOrders(int customerId) {
		return dao.getCustomerOrders(customerId);
	}
}
