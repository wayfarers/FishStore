package org.genia.fishstore;

import java.util.Date;

import org.genia.fishstore.dao.FishBatchDao;
import org.genia.fishstore.entities.FishType;
import org.genia.fishstore.entities.IncomeReport;
import org.genia.fishstore.entities.ReportLine;
import org.genia.fishstore.services.CustomerOrderService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("\\spring\\application-config.xml");
//		CustomerService customerService = context.getBean(CustomerService.class);
		FishBatchDao companyDao = context.getBean(FishBatchDao.class);
		CustomerOrderService customerOrderService = context.getBean(CustomerOrderService.class);
		
//		List<Customer> list = customerService.findAll();
//
//		for (Customer customer : list) {
//			System.out.println(customer);
//			for (CustomerOrder customerOrder : customer.getOrders()) {
//				System.out.println("\t" + customerOrder);
//			}
//		}
		
//		ParcelFilter filter = new ParcelFilter();
//		filter.setPaginator(new PageInfo(2));
////		filter.setMaxPrice(300);
//		filter.setOnStockOnly(true);
//		//filter.setFishType("ka");
////		filter.setMaxAgeInDays(1000);
//		
//		for (int i = 1; i <= 5; i++) {
//			filter.getPaginator().setCurrentPage(i);
//			
//			List<FishBatch> parties = companyDao.findByFilter(filter).getResultList();
//			
//			System.out.println("\nPage " + i + ": \n");
//			for (FishBatch coi : parties) {
//				System.out.println("id = " + coi.getId()  + "; " + coi.getFishType().getName());
//			}
//		}
		
		System.out.println("Report by dates: \n");
		IncomeReport<Date> reportByDates = customerOrderService.generateReportByDates();
		for (ReportLine<Date> line : reportByDates.getLines()) {
			System.out.println(line);
		}
		System.out.println();
		System.out.println("Report by fish types: \n");
		IncomeReport<FishType> reportByFishes = customerOrderService.generateReportByFishTypes();
		for (ReportLine<FishType> line : reportByFishes.getLines()) {
			System.out.println(line);
		}
	}
}
