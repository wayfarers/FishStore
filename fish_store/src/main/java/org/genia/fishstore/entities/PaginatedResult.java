package org.genia.fishstore.entities;

import java.util.List;

public class PaginatedResult <T> {
	int countOfItems;
	List<T> resultList;
	
	public PaginatedResult() {
	}
	
	public PaginatedResult(int count, List<T> items) {
		countOfItems = count;
		resultList = items;
	}

	public int getCountOfItems() {
		return countOfItems;
	}

	public void setCountOfItems(int countOfItems) {
		this.countOfItems = countOfItems;
	}

	public List<T> getResultList() {
		return resultList;
	}

	public void setResultList(List<T> resultList) {
		this.resultList = resultList;
	}
	
	
}
