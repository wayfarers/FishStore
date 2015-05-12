package org.genia.fishstore.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class CustomerOrderItem {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "customerOrderItemId")
	private int id;
	private int weight;
	
//	private double primeCost;
	
	@ManyToOne
	@JoinColumn(name = "companyOrderItemId")
	private CompanyOrderItem companyOrderItem; 		
	
	@ManyToOne
	@JoinColumn(name = "customerOrderId")
	private CustomerOrder order; 		//Is in needed?


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public CompanyOrderItem getCompanyOrderItem() {
		return companyOrderItem;
	}

	public void setCompanyOrderItem(CompanyOrderItem companyOrderItem) {
		this.companyOrderItem = companyOrderItem;
	}

	public CustomerOrder getOrder() {
		return order;
	}

	public void setOrder(CustomerOrder order) {
		this.order = order;
	}

	
}
