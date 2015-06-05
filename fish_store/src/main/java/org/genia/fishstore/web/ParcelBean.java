package org.genia.fishstore.web;

import java.io.Serializable;

import javax.inject.Inject;
import javax.inject.Named;

import org.genia.fishstore.ParcelFilter;
import org.genia.fishstore.dao.FishBatchDao;
import org.genia.fishstore.entities.FishBatch;
import org.genia.fishstore.entities.PaginatedResult;
import org.springframework.context.annotation.Scope;


@Named
@Scope("session")
public class ParcelBean implements Serializable {
	ParcelFilter filter;
	PaginatedResult<FishBatch> result;
	
	@Inject
	private FishBatchDao orderService; 	//temporary
	
	public ParcelBean() {
		filter = new ParcelFilter();
	}

	public ParcelFilter getFilter() {
		return filter;
	}

	public void setFilter(ParcelFilter filter) {
		this.filter = filter;
	}

	public PaginatedResult<FishBatch> getResult() {
		return result;
	}

	public void setResult(PaginatedResult<FishBatch> result) {
		this.result = result;
	}
	
	public String applyFilter() {
		result = orderService.findByFilter(filter);
		return "resultList";
	}
}
