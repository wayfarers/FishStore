package org.genia.fishstore.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Named;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Named
@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "customerId")
	private Integer id;
	private String name;
	private String email;
	private String login;
	private String password;
	private int prepaymentRights;		// in %
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date registrationDate;
	
	
	@OneToMany(mappedBy = "customer")
	private List<CustomerOrder> orders = new ArrayList<>();
	
	
	public int getPrepaymentRights() {
		return prepaymentRights;
	}

	public void setPrepaymentRights(int prepaymentRights) {
		this.prepaymentRights = prepaymentRights;
	}

	public List<CustomerOrder> getOrders() {
		return orders;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getRegistrationDate() {
		return registrationDate;
	}
	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}
	
	@Override
	public String toString() {
		return String.format("Name: %s, email: %s", name, email);
	}
}
