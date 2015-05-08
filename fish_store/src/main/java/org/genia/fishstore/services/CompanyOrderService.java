package org.genia.fishstore.services;

import org.genia.fishstore.entities.CompanyOrderItem;

public interface CompanyOrderService {
	public void putOnSale(CompanyOrderItem item);			//mark as available for sale
	public void removeFromSale(CompanyOrderItem item);		//mark as not available for sale
	public void writeOffOrderItem(CompanyOrderItem item);	//write-off the rest
	public void acceptOnStore(int orderId, int coldStoreManagerId);		//accept order to store.
	public String generateReportByDates();
	public String generateReportByFishTypes();
}
