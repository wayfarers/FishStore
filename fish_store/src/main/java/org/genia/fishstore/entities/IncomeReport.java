package org.genia.fishstore.entities;

import java.util.List;
import java.util.Map;

public class IncomeReport<T> {
	
	List<ReportLine> lines;
	public List<ReportLine> getLines() {
		return lines;
	}

	public void setLines(List<ReportLine> lines) {
		this.lines = lines;
	}

	
	
	public double getTotalIncome() {
		Double totals = 0.0;
		for (ReportLine line : lines) {
			totals += line.getIncome();
		}
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
