package org.genia.fishstore;

public class PageInfo {
	private int itemsPerPage;
	private int currentPage;

	public int getOffset() {
		return itemsPerPage * (currentPage - 1);
	}
}
