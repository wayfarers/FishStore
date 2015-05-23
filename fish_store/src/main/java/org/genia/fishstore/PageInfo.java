package org.genia.fishstore;

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
}
