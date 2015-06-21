package org.genia.fishstore.dao;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.TypedQuery;

import org.apache.commons.lang3.StringUtils;
import org.genia.fishstore.ParcelFilter;
import org.genia.fishstore.entities.FishBatch;
import org.genia.fishstore.entities.PaginatedResult;
import org.springframework.stereotype.Repository;

@Repository
public class FishBatchDaoImpl extends GenericDaoImpl<FishBatch> implements FishBatchDao {

	public FishBatchDaoImpl() {
		super(FishBatch.class);
	}
	
	@Override
	public List<FishBatch> getAvailableItems() {
		return em.createQuery("select fb from FishBatch fb where fb.onSale = true", 
				FishBatch.class).getResultList();
	}
	
	@Override
	public PaginatedResult<FishBatch> findByFilter(ParcelFilter filter) {
		
		String sql = "select fb from FishBatch fb";
		String countSql = "select count(fb.id) from FishBatch fb";
		String sqlFilter;
		long resultCount;
		
		List<String> conditions = new ArrayList<>();
		
		if (filter != null) {
			if (filter.getOnStockOnly()) {
				conditions.add("fb.onSale = true");
			}
			if (filter.getMaxPrice() != null) {
				conditions.add("fb.salePrice <= " + filter.getMaxPrice());
			}
			if (filter.getFishType() != null && !filter.getFishType().equals("")) {
				conditions.add("fb.fishType.name like " + "'%" + filter.getFishType() + "%'");
			}
			if (filter.getMaxAgeInDays() != null) {
				conditions.add("fb.order.dateArrived >= :maxAgeDate");
			}

		}
		if (conditions.size() == 0) {
			sqlFilter = "";
		} else {
			sqlFilter = " where " + StringUtils.join(conditions, " and ");
		}

		TypedQuery<FishBatch> query = em.createQuery(sql + sqlFilter, FishBatch.class);
		TypedQuery<Long> countQuery = em.createQuery(countSql + sqlFilter, long.class);
		
		if (filter != null) {
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
		}
		resultCount = countQuery.getSingleResult();
		return new PaginatedResult<> (resultCount, query.getResultList());
	}
}
