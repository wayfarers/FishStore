package org.genia.fishstore.dao;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.TypedQuery;

import org.apache.commons.lang3.StringUtils;
import org.genia.fishstore.ParcelFilter;
import org.genia.fishstore.entities.CompanyOrderItem;
import org.genia.fishstore.entities.PaginatedResult;
import org.springframework.stereotype.Repository;

@Repository
public class CompanyOrderItemDaoImpl extends GenericDaoImpl<CompanyOrderItem> implements CompanyOrderItemDao {

	public CompanyOrderItemDaoImpl() {
		super(CompanyOrderItem.class);
	}
	
	@Override
	public List<CompanyOrderItem> getAvailableItems() {
		return em.createQuery("select coi from CompanyOrderItem coi where coi.onSale = true", 
				CompanyOrderItem.class).getResultList();
	}
	
	@Override
	public PaginatedResult<CompanyOrderItem> findByFilter(ParcelFilter filter) {
		String sql = "select coi from CompanyOrderItem coi";
		String countSql = "select count(coi.id) from CompanyOrderItem coi";
		String sqlFilter;
		long resultCount;
		
		List<String> conditions = new ArrayList<>();
		
		if (filter.getOnStockOnly()) {
			conditions.add("coi.onSale = true");
		}
		if (filter.getMaxPrice() != null) {
			conditions.add("coi.salePrice >= " + filter.getMaxPrice());
		}
		if (filter.getFishType() != null) {
			conditions.add("coi.fishType.name like " + "'%" + filter.getFishType() + "%'");
		}
		if (filter.getMaxAgeInDays() != null) {
			conditions.add("coi.order.dateArrived >= :maxAgeDate");
		}
		
		sqlFilter = " where " + StringUtils.join(conditions, " and ");
		
		TypedQuery<CompanyOrderItem> query = em.createQuery(sql + sqlFilter, CompanyOrderItem.class);
		TypedQuery<Long> countQuery = em.createQuery(countSql + sqlFilter, long.class);
		
		if (filter.getMaxAgeInDays() != null) {
			Calendar calendar = Calendar.getInstance();
			calendar.add(Calendar.DAY_OF_YEAR, -filter.getMaxAgeInDays());
			Date maxAgeDate = calendar.getTime();
			query.setParameter("maxAgeDate", maxAgeDate);
			countQuery.setParameter("maxAgeDate", maxAgeDate);
		}
		
		if (filter.getPaginator() != null) {
			filter.getPaginator().updateQueryPageInfo(query);
		}
		
		resultCount = countQuery.getSingleResult();
		return new PaginatedResult<> (resultCount, query.getResultList());
	}

}
