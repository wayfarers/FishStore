package org.genia.fishstore.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class CompanyOrderItem {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "companyOrderItemId")
	private int id;
	private String quality;
	private int weightOrdered;
	private int weightArrived;
	private int weightLeft;
	private double cost;
	private boolean writtenOff;
	private double salePrice;
	private boolean onSale;
	
	@ManyToOne
	@JoinColumn(name = "fishTypeId")
	private FishType fishType;
	
	@ManyToOne
	@JoinColumn(name = "companyOrderId")
	private CompanyOrder order;
}
