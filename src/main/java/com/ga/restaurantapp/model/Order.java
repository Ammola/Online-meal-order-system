package com.ga.restaurantapp.model;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.Set;
import javax.persistence.*;

<<<<<<< HEAD
import java.time.LocalDateTime;
=======
>>>>>>> Ibrahim-dev
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
	@JoinTable(name = "meal_orders",
				joinColumns = { @JoinColumn(name = "order_id") },
				inverseJoinColumns = { @JoinColumn(name = "meal_id")})
	private Set<Meal> meals;
<<<<<<< HEAD

=======
	@Column(name="createdAt", nullable = false, updatable = false)
	@CreationTimestamp
	private LocalDateTime createAt;
	@Column(name="updatedat", nullable = false, updatable = true)
	@UpdateTimestamp
	private LocalDateTime updateAt;
>>>>>>> Ibrahim-dev
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderid) {
<<<<<<< HEAD
		orderId = orderid;

=======
		this.orderId = orderid;
>>>>>>> Ibrahim-dev
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
	public User getCustomerId() {
		return customerId;
	}
	public void setCustomerId(User customerId) {
		this.customerId = customerId;
	}
	public Set<Meal> getMeals() {
		return meals;
	}
<<<<<<< HEAD
=======
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
	
	
	
	
>>>>>>> Ibrahim-dev
	
}
















