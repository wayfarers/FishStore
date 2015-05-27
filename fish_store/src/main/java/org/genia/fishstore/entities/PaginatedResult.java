package org.genia.fishstore.entities;

import java.util.List;

public class PaginatedResult <T> {
	long countOfItems;
	List<T> resultList;
	
	public PaginatedResult() {
	}
	
	public PaginatedResult(long count, List<T> items) {
		countOfItems = count;
		resultList = items;
	}

	public long getCountOfItems() {
		return countOfItems;
	}

	public void setCountOfItems(long countOfItems) {
		this.countOfItems = countOfItems;
	}

	public List<T> getResultList() {
		return resultList;
	}

	public void setResultList(List<T> resultList) {
		this.resultList = resultList;
	}
	
	
}
