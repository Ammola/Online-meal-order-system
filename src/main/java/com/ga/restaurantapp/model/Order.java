package com.ga.restaurantapp.model;
<<<<<<< HEAD

import java.sql.Date;
=======
import java.time.LocalDateTime;
>>>>>>> 3998b7c00df8fd3c58070cfd13d8bca15945ecfe
import java.util.Set;
import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;


@Entity
@Table(name="Orders")
public class Order {
	
	@Id
	@GeneratedValue



	private int orderId;	
	private Date orderDate;
	private int quantity;	
	private int customerID;
	private String CustomerName;

	@Column(length = 10)
	private int CustomerPhone;
	
	@Column(name="createdAt", nullable = false, updatable = false)
	@CreationTimestamp
	private LocalDateTime createAt;
		
	@ManyToOne
	@JoinColumn(name="FK_CustomerId")
	private User customer;

	@ManyToMany
	@JoinTable(name = "meal_order",
				joinColumns = { @JoinColumn(name = "order_id") },
				inverseJoinColumns = { @JoinColumn(name = "meal_id")})


	private Set<Meal> OrderedMeals;
	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public LocalDateTime getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDateTime orderDate) {
		this.orderDate = orderDate;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public int getCustomerPhone() {
		return CustomerPhone;
	}
	
	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public void setCustomerPhone(int customerPhone) {
		CustomerPhone = customerPhone;
	}

	public LocalDateTime getCreateAt() {
		return createAt;
	}

	public void setCreateAt(LocalDateTime createAt) {
		this.createAt = createAt;
	}

	public User getCustomer() {
		return customer;
	}

	public void setCustomer(User customer) {
		this.customer = customer;
	}

	public Set<Meal> getOrderedMeals() {
		return OrderedMeals;
	}

	public void setOrderedMeals(Set<Meal> orderedMeals) {
		OrderedMeals = orderedMeals;
	}
<<<<<<< HEAD
=======

	
>>>>>>> 3998b7c00df8fd3c58070cfd13d8bca15945ecfe
	
}