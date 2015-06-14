package org.genia.fishstore.web;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.genia.fishstore.ParcelFilter;
import org.genia.fishstore.entities.FishBatch;
import org.genia.fishstore.entities.PaginatedResult;
import org.genia.fishstore.services.FishBatchService;
import org.genia.fishstore.services.FishTypeService;
import org.springframework.context.annotation.Scope;


@Named
@Scope("session")
public class ParcelBean implements Serializable {
	ParcelFilter filter;
	PaginatedResult<FishBatch> result;
	
	@Inject
	FishTypeService fishTypeService;
	
	@Inject
	FishBatchService fishBatchService;
	
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
	
	// TODO: Implement "No results found" notification
	public void applyFilter() {
		System.out.println(Thread.currentThread().getName());
		result = fishBatchService.findByFilter(filter);
	}
	
	public List<String> completeText(String query) {
		List<String> allFishTypes = fishTypeService.getFishNames();
		List<String> filteredNames = new ArrayList<>();
		for (String name : allFishTypes) {
			if (name.toLowerCase().contains(query)) {
				filteredNames.add(name);
			}
		}
		return filteredNames;
	}
}
