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
	
	private String CustomerName;
	@Column(length = 10)
	private int CustomerPhone;

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
		CustomerPhone = customerPhone;
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