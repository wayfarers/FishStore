package org.genia.fishstore.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;

import org.apache.commons.lang3.StringUtils;
import org.genia.fishstore.CustomerOrderFilter;
import org.genia.fishstore.entities.CustomerOrder;
import org.genia.fishstore.entities.PaginatedResult;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerOrderDaoImpl extends GenericDaoImpl<CustomerOrder> implements CustomerOrderDao {

	public CustomerOrderDaoImpl() {
		super(CustomerOrder.class);
	}

	@Override
	public List<CustomerOrder> getCustomerOrders(int customerId) {
		return em.createQuery("select co from CustomerOrder co where co.id = :id", CustomerOrder.class)
		.setParameter("id", customerId)
		.getResultList();
		
	}

	@Override
	public PaginatedResult<CustomerOrder> findByFilter(
			CustomerOrderFilter filter) {
		String sql = "select ord from CompanyOrder ord";
		String countSql = "select count(*) from CompanyOrder";
		String sqlFilter;
		
		List<String> conditions = new ArrayList<>();
		
		if (filter.getFromDate() != null) {
			conditions.add("ord.date >= :fromDate");
		}
		if (filter.getTillDate() != null) {
			conditions.add("ord.date <= :tillDate");
		}
		if (filter.getStatus() != null) {
			conditions.add("ord.status = " + filter.getStatus().getValue());
		}
		if (filter.isUnPayed()) {
			conditions.add("ord.sum <> ord.sumPayed");
		}

		sqlFilter = " where " + StringUtils.join(conditions, " and ");
		
		int resultCount = em.createQuery(countSql + sqlFilter, int.class).getSingleResult();
		
		TypedQuery<CustomerOrder> query = em.createQuery(sql + sqlFilter, CustomerOrder.class);
		
		if (filter.getFromDate() != null) {
			query.setParameter("fromDate", filter.getFromDate());
		}
		if (filter.getTillDate() != null) {
			query.setParameter("tillDate", filter.getTillDate());
		}
		if (filter.getPaginator() != null) {
			filter.getPaginator().updateQueryPageInfo(query);
		}
		
		return new PaginatedResult<CustomerOrder>(resultCount, query.getResultList());
	}

}
