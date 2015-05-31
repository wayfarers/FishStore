package org.genia.fishstore.services;

import java.util.Date;

import org.genia.fishstore.entities.PurchaseOrder;
import org.genia.fishstore.entities.FishType;
import org.genia.fishstore.entities.IncomeReport;

public interface PurchaseOrderService extends GenericService<PurchaseOrder> {
	
	//move to Managed Bean
//	public void putOnSale(CompanyOrderItem item);			//mark as available for sale
//	public void removeFromSale(CompanyOrderItem item);		//mark as not available for sale
//	public void writeOffOrderItem(CompanyOrderItem item);	//write-off the rest
//	public void acceptOnStore(int orderId, int coldStoreManagerId);		//accept order to store.
	
	public IncomeReport<Date> generateReportByDates();
	public IncomeReport<FishType> generateReportByFishTypes();
}

// TODO: Fish profile page
// URL: /fish/345 - ID, name, later - some statistics about sales

// TODO: Client profile
// URL: /client/4545 - Client info, statistics, last login date
