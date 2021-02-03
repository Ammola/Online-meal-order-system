package com.ga.restaurantapp.model;
import java.sql.Date;
import java.util.Set;
import javax.persistence.*;
@Entity
@Table(name="Orders")
public class Order {
	@Id
	@GeneratedValue
	private int orderId;
	private Date orderDate;
	
	private int quantity;
	
	private int customerID;
	
	
	@ManyToOne
	@JoinColumn(name="FK_CustomerId")
	private User customerId;
	
	
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
	public void setMeal(Set<Meal> meal) {
		this.meals = meal;
	}
	
	
	
}