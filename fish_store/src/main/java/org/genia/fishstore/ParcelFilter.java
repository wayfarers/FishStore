package org.genia.fishstore;

import javax.persistence.TypedQuery;

public class ParcelFilter {
	private PageInfo paginator;
	
	private Integer maxAgeInDays;
	private boolean onStockOnly;
	private Integer maxPrice;
	private String fishTypeName;
	
	public ParcelFilter() {
	}
	
	public String getAdditionalSql() {
		String sql = null;
		
//		if (maxAgeInDays > 0) {
//			sql += " ";
//		}
		
		// WHERE CON1 AND COND2 AND COND3
		
		// "where " + StringUtils.join(conditions, " and ") // apache-commons
		// coi.date > :coupleOfDaysAgo
		
		
		if (paginator != null) {
			sql += "limit " + paginator.getOffset() + ", " + paginator.getItemsPerPage(); // TODO += paginator.getSql()
		}
		
		return sql;
	}
	
	public PageInfo getPaginator() {
		return paginator;
	}
	public void setPaginator(PageInfo paginator) {
		this.paginator = paginator;
	}
	public Integer getMaxAgeInDays() {
		return maxAgeInDays;
	}
	public void setMaxAgeInDays(int maxAgeInDays) {
		this.maxAgeInDays = maxAgeInDays;
	}
	public boolean getOnStockOnly() {
		return onStockOnly;
	}
	public void setOnStockOnly(boolean onStock) {
		this.onStockOnly = onStock;
	}
	public Integer getMaxPrice() {
		return maxPrice;
	}
	public void setMaxPrice(int maxPrice) {
		this.maxPrice = maxPrice;
	}
	public String getFishType() {
		return fishTypeName;
	}
	public void setFishType(String fishType) {
		this.fishTypeName = fishType;
	}
	
	public <T> void updateQueryPageIngo(TypedQuery<T> query) {
		if (paginator != null)
		query.setFirstResult(paginator.getOffset()).setMaxResults(paginator.getItemsPerPage());
	}

}
