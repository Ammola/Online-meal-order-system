package com.ga.restaurantapp.model;

import java.sql.Date;
//ADD LOCALDATE
import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.*;


@Entity
@Table(name="Orders")
public class Order {

	@Id
	@GeneratedValue
	private int Orderid;

	private Date OrderDate;
	
	private int Quantity;
	
	private int price;
	
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public LocalDateTime getCreateAt() {
		return createAt;
	}

	public void setCreateAt(LocalDateTime createAt) {
		this.createAt = createAt;
	}

	public LocalDateTime getUpdateAt() {
		return updateAt;
	}

	public void setUpdateAt(LocalDateTime updateAt) {
		this.updateAt = updateAt;
	}

	private int CustomerID;
	
	@Column(name="createdAt", nullable = false, updatable = false)
	private LocalDateTime createAt;
	
	@Column(name="updatedat", nullable = false, updatable = true)
	private LocalDateTime updateAt;

	

	@ManyToMany
	@JoinTable(name = "meal_order",
				joinColumns = { @JoinColumn(name = "order_id") },
				inverseJoinColumns = { @JoinColumn(name = "meal_id")})

	
	
	private Set<Meal> meal;

	
	
	// getter and setter
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
