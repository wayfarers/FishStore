package org.genia.fishstore.entities;

import java.util.Map;

public class IncomeReport<T> {
	public Map<T, Double> earnings;
	
	
	public void addEarning(T grouping, double value) {
//		earnings.put(grouping, value);
	}
	
	public void getEarning(T period) {
		earnings.get(period);
	}
	
	public double getTotalEarnings() {
		Double totals = null;
//		for (T t : earnings.keySet()) {
//			totals += earnings.get(t);
//		}
		
		return totals;
	}
 }

/**
 * 
 * IncomeReport<FishType, Double>
 * IncomeReport<Date, Double>
 * IncomeReport<FishType, IncomeReport<Date, Double>>
 * IncomeReport<Date, IncomeReport<FishType, Double>>
 * 
 * 
 * fishType - income (double)
 * 
 * fishType: revenue, cost, income (RevenueItem)
 * 
 * fish1 0.5
 *   dat1 0.2
 *   dat2 0.3
 * fish2 0.3
 *   dat1 0.1
 *   dat2 0.2
 * -------------
 * totals 0.8
 *   dat1 0.3
 *   dat2 0.5
 * 
 * PurchaseOrder > FishBatch     SellOrder > SellOrderItem
 */

interface Summable {
	public Summable addTo(Summable s);
}
