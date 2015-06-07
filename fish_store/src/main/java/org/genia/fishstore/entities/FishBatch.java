package org.genia.fishstore.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class FishBatch {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "fishBatchId")
	private Integer id;
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
	@JoinColumn(name = "purchaseOrderId")
	private PurchaseOrder order;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getQuality() {
		return quality;
	}

	public void setQuality(String quality) {
		this.quality = quality;
	}

	public int getWeightOrdered() {
		return weightOrdered;
	}

	public void setWeightOrdered(int weightOrdered) {
		this.weightOrdered = weightOrdered;
	}

	public int getWeightArrived() {
		return weightArrived;
	}

	public void setWeightArrived(int weightArrived) {
		this.weightArrived = weightArrived;
	}

	public int getWeightLeft() {
		return weightLeft;
	}

	public void setWeightLeft(int weightLeft) {
		this.weightLeft = weightLeft;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public boolean isWrittenOff() {
		return writtenOff;
	}

	public void setWrittenOff(boolean writtenOff) {
		this.writtenOff = writtenOff;
	}

	public double getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(double salePrice) {
		this.salePrice = salePrice;
	}

	public boolean isOnSale() {
		return onSale;
	}

	public void setOnSale(boolean onSale) {
		this.onSale = onSale;
	}

	public FishType getFishType() {
		return fishType;
	}

	public void setFishType(FishType fishType) {
		this.fishType = fishType;
	}

	public PurchaseOrder getOrder() {
		return order;
	}

	public void setOrder(PurchaseOrder order) {
		this.order = order;
	}
}
