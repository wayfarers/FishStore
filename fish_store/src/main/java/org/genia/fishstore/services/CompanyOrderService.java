package org.genia.fishstore.services;

import org.genia.fishstore.entities.CompanyOrder;
import org.genia.fishstore.entities.CompanyOrderItem;
import org.genia.fishstore.entities.IncomeReport;

public interface CompanyOrderService extends GenericService<CompanyOrder> {
	public void putOnSale(CompanyOrderItem item);			//mark as available for sale
	public void removeFromSale(CompanyOrderItem item);		//mark as not available for sale
	public void writeOffOrderItem(CompanyOrderItem item);	//write-off the rest
	public void acceptOnStore(int orderId, int coldStoreManagerId);		//accept order to store.
	
	public IncomeReport generateReportByDates();
	public IncomeReport generateReportByFishTypes();
}
