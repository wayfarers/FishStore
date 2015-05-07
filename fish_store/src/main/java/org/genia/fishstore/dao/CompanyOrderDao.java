package org.genia.fishstore.dao;

import java.util.List;

import org.genia.fishstore.entities.CompanyOrder;
import org.genia.fishstore.entities.CompanyOrderItem;

public interface CompanyOrderDao extends GenericDao<CompanyOrder> {
	public List<CompanyOrderItem> getAvailableItems();
	public void putOnSale(CompanyOrderItem item);			//mark as available for sale
	public void removeFromSale(CompanyOrderItem item);		//mark as not available for sale
	public void acceptOnStore(CompanyOrderItem item);		//accept order item to store as is.
	public void writeOffOrderItem(CompanyOrderItem item);	//write-off the rest
	public String generateReportByDates();
	public String generateReportByFishTypes();
}
