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
	double sum;
	
//	private double primeCost;
	
	@ManyToOne
	@JoinColumn(name = "fishBatchId")
	private FishBatch fishBatch; 		
	
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

	public FishBatch getCompanyOrderItem() {
		return fishBatch;
	}

	public void setCompanyOrderItem(FishBatch fishBatch) {
		this.fishBatch = fishBatch;
	}

	public CustomerOrder getOrder() {
		return order;
	}

	public void setOrder(CustomerOrder order) {
		this.order = order;
	}

	public double getSum() {
		return sum;
	}

	public void setSum(double sum) {
		this.sum = sum;
	}
}
