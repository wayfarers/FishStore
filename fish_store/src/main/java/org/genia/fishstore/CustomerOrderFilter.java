package org.genia.fishstore;

import java.util.Date;

import org.genia.fishstore.entities.OrderStatus;


public class CustomerOrderFilter {
	private PageInfo paginator;
	private Date fromDate;
	private Date tillDate;
	private OrderStatus status;
	private boolean unPayed;
	
	public CustomerOrderFilter() {
	}

	public PageInfo getPaginator() {
		return paginator;
	}

	public void setPaginator(PageInfo paginator) {
		this.paginator = paginator;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getTillDate() {
		return tillDate;
	}

	public void setTillDate(Date tillDate) {
		this.tillDate = tillDate;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public boolean isUnPayed() {
		return unPayed;
	}

	public void setUnPayed(boolean unPayed) {
		this.unPayed = unPayed;
	}
}
