package com.ga.restaurantapp.model;

import java.sql.Date;
import java.util.Set;

import javax.persistence.*;


@Entity
@Table(name="Order")
public class Order {

	@Id
	@GeneratedValue
	private int Orderid;

	private Date OrderDate;
	
	private int Quantity;
	
	private int CustomerID;
	
	

	@ManyToMany
	@JoinTable(name = "meal_order",
				joinColumns = { @JoinColumn(name = "order_id") },
				inverseJoinColumns = { @JoinColumn(name = "meal_id")})

	
	
	private Set<Meal> meal;

	
	
	
	public int getOrderid() {
		return Orderid;
	}

	public void setOrderid(int orderid) {
		Orderid = orderid;
	}

	public Date getOrderDate() {
		return OrderDate;
	}

	public void setOrderDate(Date orderDate) {
		OrderDate = orderDate;
	}

	public int getQuantity() {
		return Quantity;
	}

	public void setQuantity(int quantity) {
		Quantity = quantity;
	}

	public int getCustomerID() {
		return CustomerID;
	}

	public void setCustomerID(int customerID) {
		CustomerID = customerID;
	}

	public Set<Meal> getMeal() {
		return meal;
	}

	public void setMeal(Set<Meal> meal) {
		this.meal = meal;
	}

	
	
	
}
