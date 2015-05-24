package org.genia.fishstore.dao;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.TypedQuery;

import org.apache.commons.lang3.StringUtils;
import org.genia.fishstore.ParcelFilter;
import org.genia.fishstore.entities.CompanyOrderItem;
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
	public List<CompanyOrderItem> findByFilter(ParcelFilter filter) {
		String sql = "select coi from CompanyOrderItem coi";
		
		List<String> conditions = new ArrayList<>();
		
//		Calendar calendar = Calendar.getInstance().add(Calendar.DAY_OF_YEAR, -filter.getMaxAgeInDays());
		
		
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
		
		String sqlFilter = " where " + StringUtils.join(conditions, " and ");
		
		TypedQuery<CompanyOrderItem> query = em.createQuery(sql + sqlFilter, CompanyOrderItem.class);
		
		if (filter.getMaxAgeInDays() != null) {
			Calendar calendar = Calendar.getInstance();
			calendar.add(Calendar.DAY_OF_YEAR, -filter.getMaxAgeInDays());
			Date maxAgeDate = calendar.getTime();
			query.setParameter("maxAgeDate", maxAgeDate);
		}
		
		if (filter.getPaginator() != null) {
//			query.setFirstResult(filter.getPaginator().getOffset()).setMaxResults(filter.getPaginator().getItemsPerPage());
			filter.updateQueryPageIngo(query);
		}
		return query.getResultList();
	}

}
