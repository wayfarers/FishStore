package org.genia.fishstore.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.genia.fishstore.entities.Customer;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerDaoImpl extends GenericDaoImpl<Customer> implements CustomerDao {

	public CustomerDaoImpl() {
		super(Customer.class);
	}
	@Override
	public Customer findByLogin(String login) {
		TypedQuery<Customer> query = em.createQuery("select cust from Customer cust where cust.login = :login", entityClass);
		query.setParameter("login", login);
		return query.getSingleResult();
	}

	@Override
	public List<Customer> getCustomerList() {
		return em.createQuery("select cust from Customer cust", entityClass).getResultList();
	}
	
	
}
