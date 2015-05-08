package org.genia.fishstore.services;

import java.util.List;

import org.genia.fishstore.entities.Customer;


public interface CustomerService extends GenericService<Customer> {
	public Customer findByLogin(String login);
	public List<Customer> getCustomerList();
	public List<Customer> findAll();
	
	
//	@Inject
//	private CustomerDao customerDao;
//	
//	public List<Customer> findAll() {
//		return customerDao.getCustomerList();
//	}
//	
//	public List<CustomerOrder> findOrdersById(int id) {
//		TypedQuery<CustomerOrder> query = em.createQuery("SELECT o FROM CustomerOrder o JOIN o.customer c WHERE c.id = " + id,
//				CustomerOrder.class);
//		return query.getResultList();
//	}
}
