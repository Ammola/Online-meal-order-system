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
	private int Orderid;
	
	private int Quantity ,Price;
	
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
	public int getOrderid() {
		return Orderid;
	}
	
	
	@Column(name="createdAt", nullable = false, updatable = false)
	@CreationTimestamp
	private LocalDateTime createAt;

	@Column(name="updatedat", nullable = false, updatable = true)
	@UpdateTimestamp
	private LocalDateTime updateAt;

	public int getOrderId() {
		return Orderid;
	}

	public void setOrderid(int orderid) {
		Orderid = orderid;
	}
	
	public Date getOrderDate() {
		return OrderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.OrderDate = orderDate;
	}

	public int getQuantity() {
		return Quantity;
	}

	public void setQuantity(int quantity) {
		this.Quantity = quantity;
	}

	public int getPrice() {
		return Price;
	}

	public void setPrice(int price) {
		this.Price = price;
	}

	public Set<Meal> getMeal() {
		return meals;
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
