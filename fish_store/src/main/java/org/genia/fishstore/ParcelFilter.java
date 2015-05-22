package org.genia.fishstore;

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
		
		if (onStockOnly) { // WTF
			if (sql == null) {
				sql = " where " + sql;
			} 
			sql += " coi.onStock = false";
		}
		if (maxPrice != null) {
			if (sql == null) {
				sql = " where " + sql; // WTF
			} else {
				sql = " and " + sql;
			}
			sql += " coi.price >= " + maxPrice;
		}
		if (fishTypeName != null) {
			if (sql == null) {
				sql = " where " + sql;
			} else {
				sql = " and " + sql;
			}
			sql += " coi.fishType.name like " + fishTypeName;
		}
		
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
	public int getMaxAgeInDays() {
		return maxAgeInDays;
	}
	public void setMaxAgeInDays(int maxAgeInDays) {
		this.maxAgeInDays = maxAgeInDays;
	}
	public boolean isOnStock() {
		return onStockOnly;
	}
	public void setOnStock(boolean onStock) {
		this.onStockOnly = onStock;
	}
	public int getMaxPrice() {
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

}
