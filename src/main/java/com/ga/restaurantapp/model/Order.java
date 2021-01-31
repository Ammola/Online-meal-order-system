package com.ga.restaurantapp.model;
import java.sql.Date;
import java.util.Set;
import javax.persistence.*;
import java.time.LocalDateTime;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name="orders")
public class Order {
	
	@Id
	@GeneratedValue
	@Column(length = 3)
	private int orderId;
	
	private int quantity ,price;
	
	private Date orderDate;
	
	private String customerName;
	@Column(length = 10)
	private int customerPhone;
	
	@ManyToOne
	@JoinColumn(name="FK_CustomerId")
	private User customerId;

	
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
		this.price = price;
	}

	
	public Set<Meal> getMeals() {
		return meals;
	}

	public void setMeals(Set<Meal> meals) {
		this.meals = meals;
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

	
}
