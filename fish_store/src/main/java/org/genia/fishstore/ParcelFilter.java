package org.genia.fishstore;

public class ParcelFilter {
	private PageInfo paginator;
	
	private int maxAgeInDays;
	private boolean onStock;
	private int maxPrice;
	private String fishType;
	
	public ParcelFilter() {
		//if '-1' or 'null' - parameter is inactive
		maxAgeInDays = -1; 		
		onStock = true;
		maxPrice = -1;
		fishType = null;
	}
	
	public String getAdditionalSql() {
		String sql = "";
		if(onStock = false) {
			sql += " coi.onStock = false ";
		}
		if (maxPrice > 0) {
			sql += "coi.price >= " + maxPrice;
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
		return onStock;
	}
	public void setOnStock(boolean onStock) {
		this.onStock = onStock;
	}
	public int getMaxPrice() {
		return maxPrice;
	}
	public void setMaxPrice(int maxPrice) {
		this.maxPrice = maxPrice;
	}
	public String getFishType() {
		return fishType;
	}
	public void setFishType(String fishType) {
		this.fishType = fishType;
	}

}
