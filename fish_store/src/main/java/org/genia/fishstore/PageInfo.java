package org.genia.fishstore;

import javax.persistence.TypedQuery;

public class PageInfo {
	private int itemsPerPage;
	private int currentPage;

	
	public PageInfo(int itemsPerPage) {
		this.itemsPerPage = itemsPerPage;
		currentPage = 1;
	}
	
	public int getOffset() {
		return itemsPerPage * (currentPage - 1);
	}

	public int getItemsPerPage() {
		return itemsPerPage;
	}

	public void setItemsPerPage(int itemsPerPage) {
		this.itemsPerPage = itemsPerPage;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	
	public <T> void updateQueryPageInfo(TypedQuery<T> query) {
		query.setFirstResult(getOffset()).setMaxResults(getItemsPerPage());
	}
}
