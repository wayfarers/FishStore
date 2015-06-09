package org.genia.fishstore.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.TypedQuery;

import org.apache.commons.lang3.StringUtils;
import org.genia.fishstore.CustomerOrderFilter;
import org.genia.fishstore.entities.CustomerOrder;
import org.genia.fishstore.entities.FishType;
import org.genia.fishstore.entities.IncomeReport;
import org.genia.fishstore.entities.PaginatedResult;
import org.genia.fishstore.entities.ReportLine;
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
		String sql = "select ord from CustomerOrder ord";
		String countSql = "select count(ord.id) from CustomerOrder ord";
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

		if (conditions.size() == 0) {
			sqlFilter = "";
		} else {
			sqlFilter = " where " + StringUtils.join(conditions, " and ");
		}
		
		long resultCount = em.createQuery(countSql + sqlFilter, long.class).getSingleResult();
		
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

	@Override
	public IncomeReport<Date> generateReportByDates() {
		String sql = "select new org.genia.fishstore.entities.ReportLine(co.date, SUM(coi.sum)) from CustomerOrder co, CustomerOrderItem coi where co.id = coi.order.id group by co.date";
//		String sql = "select new org.genia.fishstore.entities.ReportLine(co.date, SUM(co.sum)) from CustomerOrder co group by co.date";
		IncomeReport<Date> report = new IncomeReport<>();
		List<ReportLine> list = em.createQuery(sql, ReportLine.class).getResultList();
		report.setLines(list);
		return report;
	}

	@Override
	public IncomeReport<FishType> generateReportByFishTypes() {
		String sql = "select new org.genia.fishstore.entities.ReportLine(coi.fishBatch.fishType, SUM(coi.sum)) from CustomerOrderItem coi group by coi.fishBatch.fishType";
		IncomeReport<FishType> report = new IncomeReport<>();
		List<ReportLine> list = em.createQuery(sql, ReportLine.class).getResultList();
		report.setLines(list);
		return report;
	}

}
