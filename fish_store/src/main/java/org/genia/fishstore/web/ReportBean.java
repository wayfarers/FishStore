package org.genia.fishstore.web;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.genia.fishstore.entities.FishType;
import org.genia.fishstore.entities.IncomeReport;
import org.genia.fishstore.services.CustomerOrderService;
import org.springframework.context.annotation.Scope;

@Named
@Scope("request")
public class ReportBean {
	
	private IncomeReport<Date> dateReport;
	private IncomeReport<FishType> fishReport;
	
	@PostConstruct
	private void init() {
		dateReport = customerOrderService.generateReportByDates();
		fishReport = customerOrderService.generateReportByFishTypes();
	}
	
	@Inject
	CustomerOrderService customerOrderService;
	
	public void generateReportByDates() {
		dateReport = customerOrderService.generateReportByDates();
	}
	
	public void generateReportByFishes() {
		fishReport = customerOrderService.generateReportByFishTypes();
	}

	public IncomeReport<Date> getDateReport() {
		return dateReport;
	}

	public void setDateReport(IncomeReport<Date> dateReport) {
		this.dateReport = dateReport;
	}

	public IncomeReport<FishType> getFishReport() {
		return fishReport;
	}

	public void setFishReport(IncomeReport<FishType> fishReport) {
		this.fishReport = fishReport;
	}
}
