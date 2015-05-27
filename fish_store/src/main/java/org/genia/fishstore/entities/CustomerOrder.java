package org.genia.fishstore.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class CustomerOrder {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "customerOrderId")
	private int id;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	
	private double sum;
	private OrderStatus status;
	private String comment;
	private double sumPayed;
	
	@ManyToOne
	@JoinColumn(name = "approvedBy")
	private Employee accountant;
	
	@ManyToOne
	@JoinColumn(name = "customerId")
	private Customer customer;
	
	@OneToMany(mappedBy = "order")
	private List<CustomerOrderItem> orderItems = new ArrayList<>();

	
	
	@Override
	public String toString() {
		return String.format("Comment: %s, sum: %f", comment, sum);
	}
	
	
	public List<CustomerOrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<CustomerOrderItem> orderItems) {
		this.orderItems = orderItems;
	}
	
	public double getSumPayed() {
		return sumPayed;
	}

	public void setSumPayed(double sumPayed) {
		this.sumPayed = sumPayed;
	}



	public Employee getAccountant() {
		return accountant;
	}



	public void setAccountant(Employee accountant) {
		this.accountant = accountant;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getSum() {
		return sum;
	}

	public void setSum(double sum) {
		this.sum = sum;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
}
