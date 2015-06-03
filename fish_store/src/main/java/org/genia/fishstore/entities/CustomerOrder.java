package org.genia.fishstore.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
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
	private List<CustomerOrderItem> items = new ArrayList<>();
	
	public void addFishBatch(FishBatch fishBatch, int weight) {
		CustomerOrderItem item = findItemForBatch(fishBatch.getId());
		if (item != null) {
			item.setWeight(weight);
		} else {
			item = new CustomerOrderItem();
			item.setWeight(weight);
			item.setFishBatch(fishBatch);
			addItem(item);
		}
	}
	
	private CustomerOrderItem findItemForBatch(int fishBatchId) {
		for (CustomerOrderItem customerOrderItem : items) {
			if (customerOrderItem.getFishBatch().getId() == fishBatchId) {
				return customerOrderItem;
			}
		}
		
		return null;
	}

	
	public void removeFishBatch(int fishBatchId) {
		Iterator<CustomerOrderItem> iterator = items.iterator();
		while (iterator.hasNext()) {
			if (iterator.next().getFishBatch().getId() == fishBatchId) {
				iterator.remove();
			}
		}
	}
	
	
	@Override
	public String toString() {
		return String.format("Comment: %s, sum: %f", comment, getTotalSum());
	}
	
	
	public List<CustomerOrderItem> getOrderItems() {
		return items;
	}

	public void setOrderItems(List<CustomerOrderItem> orderItems) {
		this.items = orderItems;
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
	
	public double getTotalSum() {
		double sum = 0;
		for (CustomerOrderItem item : items) {
			sum += item.getSum();
		}
		return sum;
	}
	
	public void addItem(CustomerOrderItem item) {
		item.setOrder(this);
		items.add(item);
	}
	
	
}
