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
	
	@ManyToOne
	@JoinColumn(name = "companyOrderItemId")
	private CompanyOrderItem companyOrderItem; 		
	
	@ManyToOne
	@JoinColumn(name = "customerOrderId")
	private CustomerOrder order; 		//Is in needed?

		
}
