package com.ga.restaurantapp.model;
import java.time.LocalDateTime;
import java.util.Set;
import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;


@Entity
@Table(name="Orders")
public class Order {
	
	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	@Id
	@GeneratedValue
	private int orderId;
	
	private String customerName;
	private LocalDateTime orderDate;
	
	private int total;
	
	@Column(length = 10)
	private int customerPhone;
	
	@Column(name="createdAt", nullable = false, updatable = false)
	@CreationTimestamp
	private LocalDateTime createAt;
		
	@ManyToOne
	@JoinColumn(name="FK_CustomerId")
	private User customer;

	@ManyToMany(fetch = FetchType.EAGER)
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
	public int getCustomerPhone() {
		return customerPhone;
	}
	
	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public void setCustomerPhone(int customerPhone) {
		this.customerPhone = customerPhone;
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

	
	
}



	
