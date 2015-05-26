package org.genia.fishstore;


public class ParcelFilter {
	private PageInfo paginator;
	
	private Integer maxAgeInDays;
	private boolean onStockOnly;
	private Integer maxPrice;
	private String fishTypeName;
	
	public ParcelFilter() {
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


}
