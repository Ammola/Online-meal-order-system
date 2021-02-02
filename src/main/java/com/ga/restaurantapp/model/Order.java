package com.ga.restaurantapp.model;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.Set;
import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name="Orders")
public class Order {
	@Id
	@GeneratedValue

	@Column(length = 3)
	private int orderId;
	
	private Date orderDate;
	
	private int quantity ,price;
	
	//private int customerID;
	
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public int getCustomerPhone() {
		return customerPhone;
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
	public LocalDateTime getUpdateAt() {
		return updateAt;
	}
	public void setUpdateAt(LocalDateTime updateAt) {
		this.updateAt = updateAt;
	}
	public User getCustomer() {
		return customer;
	}
	private String customerName;

	@Column(length = 10)

	private int customerPhone;
	

	@ManyToOne
	@JoinColumn(name="FK_CustomerId")

	//private User customerId;
	private User customer;

	@ManyToMany
	@JoinTable(name = "meal_order",
				joinColumns = { @JoinColumn(name = "order_id") },
				inverseJoinColumns = { @JoinColumn(name = "meal_id")})
	private Set<Meal> OrderedMeals;

	@Column(name="createdAt", nullable = false, updatable = false)
	@CreationTimestamp
	private LocalDateTime createAt;

	@Column(name="updatedat", nullable = false, updatable = true)
	@UpdateTimestamp
	private LocalDateTime updateAt;

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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price ;
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
















