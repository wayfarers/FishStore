package org.genia.fishstore.entities;


public class ReportLine<T> {
	T type;
	Double income;
	
	public ReportLine(T type, Double income) {
		this.type = type;
		this.income = income;
	}

	public T getType() {
		return type;
	}

	public void setType(T type) {
		this.type = type;
	}

	public Double getIncome() {
		return income;
	}

	public void setIncome(Double income) {
		this.income = income;
	}

	@Override
	public String toString() {
		return "" + type + " - " + income;
	}
}
