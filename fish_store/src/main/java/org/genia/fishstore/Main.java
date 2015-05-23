package org.genia.fishstore;

import java.util.List;

import org.genia.fishstore.dao.CompanyOrderItemDao;
import org.genia.fishstore.entities.CompanyOrderItem;
import org.genia.fishstore.entities.Customer;
import org.genia.fishstore.entities.CustomerOrder;
import org.genia.fishstore.services.CustomerService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		CustomerService customerService = context.getBean(CustomerService.class);
		CompanyOrderItemDao companyDao = context.getBean(CompanyOrderItemDao.class);

//		List<Customer> list = customerService.findAll();
//
//		for (Customer customer : list) {
//			System.out.println(customer);
//			for (CustomerOrder customerOrder : customer.getOrders()) {
//				System.out.println("\t" + customerOrder);
//			}
//		}
		
		ParcelFilter filter = new ParcelFilter();
		filter.setPaginator(new PageInfo(2));
		filter.setMaxPrice(300);
		filter.setOnStockOnly(true);
		filter.setFishType("ka");
		filter.setMaxAgeInDays(1000);
		
		for (int i = 1; i <= 5; i++) {
			filter.getPaginator().setCurrentPage(i);
			
			List<CompanyOrderItem> parties = companyDao.findByFilter(filter);
			
			System.out.println("\nPage " + i + ": \n");
			for (CompanyOrderItem coi : parties) {
				System.out.println("id = " + coi.getId()  + "; " + coi.getFishType().getName());
			}
		}
		
	}
}
