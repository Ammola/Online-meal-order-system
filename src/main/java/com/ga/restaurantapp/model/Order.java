package com.ga.restaurantapp.model;
import java.sql.Date;
import java.util.Set;
import javax.persistence.*;

import java.time.LocalDateTime;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
@Entity
@Table(name="Orders")
public class Order {
	@Id
	@GeneratedValue

	private int orderId;
	private Date orderDate;
	
	private int quantity;
	
	private int customerID;
	
	private Date OrderDate;
	
	private String CustomerName;
	@Column(length = 10)
	private int CustomerPhone;

	@ManyToOne
	@JoinColumn(name="FK_CustomerId")
	private User customerId;


	
	public String getCustomerName() {
		return CustomerName;
	}

	public void setCustomerName(String customerName) {
		CustomerName = customerName;
	}

	public int getCustomerPhone() {
		return CustomerPhone;
	}

	public void setCustomerPhone(int customerPhone) {
		this.CustomerPhone = customerPhone;
	}

	public User getCustomerId() {
		return customerId;
	}

	public void setCustomerId(User customerId) {
		this.customerId = customerId;
	}


	@ManyToMany
	@JoinTable(name = "meal_order",
				joinColumns = { @JoinColumn(name = "order_id") },
				inverseJoinColumns = { @JoinColumn(name = "meal_id")})
	private Set<Meal> meals;

	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderid) {
		orderId = orderid;

	}
	

	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {

		this.orderDate = orderDate;

	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {

		this.quantity = quantity;
	}
	public int getCustomerID() {
		return customerID;
	}
	public void setCustomerID(int customerID) {
		this.customerID = customerID;

	}
	public Set<Meal> getMeal() {
		return meals;
	}
	
}
















