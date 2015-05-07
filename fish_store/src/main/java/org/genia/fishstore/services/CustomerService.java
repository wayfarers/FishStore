package org.genia.fishstore.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.genia.fishstore.entities.Customer;
import org.genia.fishstore.entities.CustomerOrder;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
	@PersistenceContext
	private EntityManager em;
	
	public List<Customer> findAll() {
		TypedQuery<Customer> query = em.createQuery("SELECT c FROM Customer c",
				Customer.class);
		return query.getResultList();
	}
	
	public List<CustomerOrder> findOrdersById(int id) {
		TypedQuery<CustomerOrder> query = em.createQuery("SELECT o FROM CustomerOrder o JOIN o.customer c WHERE c.id = " + id,
				CustomerOrder.class);
		return query.getResultList();
	}
}
