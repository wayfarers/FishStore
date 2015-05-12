package org.genia.fishstore;

import java.util.List;

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

		List<Customer> list = customerService.findAll();

		for (Customer customer : list) {
			System.out.println(customer);
			for (CustomerOrder customerOrder : customer.getOrders()) {
				System.out.println("\t" + customerOrder);
			}
		}
	}
}
