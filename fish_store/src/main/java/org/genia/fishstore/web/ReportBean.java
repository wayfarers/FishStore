package org.genia.fishstore.web;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.genia.fishstore.entities.ReportLine;
import org.genia.fishstore.services.CustomerOrderService;
import org.springframework.context.annotation.Scope;

@Named
@Scope("session")
public class ReportBean {
	
	List<ReportLine> reportList;
	
	@Inject
	CustomerOrderService customerOrderService;
	
	public List<ReportLine> reportByDates() {
		return customerOrderService.generateReportByDates().getLines();
	}
	
	public List<ReportLine> reportByFishTypes() {
		return customerOrderService.generateReportByFishTypes().getLines();
	}
}
