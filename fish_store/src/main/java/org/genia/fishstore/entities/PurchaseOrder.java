package org.genia.fishstore.entities;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class PurchaseOrder {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "purchaseOrderId")
	private Integer id;
	
	@Temporal(TemporalType.DATE)
	private Date dateOrdered;
	
	@Temporal(TemporalType.DATE)
	private Date dateArrived;
	
	@ManyToOne
	@JoinColumn(name = "acceptedToStoreBy")
	private Employee coldStoreManager;
	
	public PurchaseOrder() {
		dateOrdered = Calendar.getInstance().getTime();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDateOrdered() {
		return dateOrdered;
	}

	public void setDateOrdered(Date dateOrdered) {
		this.dateOrdered = dateOrdered;
	}

	public Date getDateArrived() {
		return dateArrived;
	}

	public void setDateArrived(Date dateArrived) {
		this.dateArrived = dateArrived;
	}

	public Employee getColdStoreManager() {
		return coldStoreManager;
	}

	public void setColdStoreManager(Employee coldStoreManager) {
		this.coldStoreManager = coldStoreManager;
	}
	
	
}
