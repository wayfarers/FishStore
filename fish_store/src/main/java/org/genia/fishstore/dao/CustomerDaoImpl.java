package org.genia.fishstore.dao;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.genia.fishstore.entities.Customer;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerDaoImpl extends GenericDaoImpl<Customer> implements
		CustomerDao {

	public CustomerDaoImpl() {
		super(Customer.class);
	}

	@Override
	public Customer findByLogin(String login) {
		TypedQuery<Customer> query = em.createQuery(
				"select cust from Customer cust where cust.login = :login",
				Customer.class);
		query.setParameter("login", login);
		try {
			return query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	@Override
	public List<Customer> findAll() {
		return em.createQuery("select cust from Customer cust", Customer.class).getResultList();
	}
}
