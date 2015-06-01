package org.genia.fishstore.entities;


public class ReportLine<T> {
	T date;
	Double income;
	
	public ReportLine(T date, Double income) {
		this.date = date;
		this.income = income;
	}

	public T getDate() {
		return date;
	}

	public void setDate(T date) {
		this.date = date;
	}

	public Double getIncome() {
		return income;
	}

	public void setIncome(Double income) {
		this.income = income;
	}

	@Override
	public String toString() {
		return "" + date + " - " + income;
	}
}
