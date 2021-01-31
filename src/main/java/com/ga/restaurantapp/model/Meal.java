package com.ga.restaurantapp.model;
import java.time.LocalDateTime;
import java.util.Set;
import javax.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
@Entity
@Table(name="Meals")
public class Meal {
	
	@Id
	@GeneratedValue
	private int mealId;
	private String mealName;
	@Column(length = 50)
	private int mealPrice;
	private int calories;
	private String description;
	
	@ManyToOne
	@JoinColumn(name="FK_AdmiId")
	private User admin;

	
	@ManyToMany(mappedBy="meals")
	private Set<Order> orders;
	@Column(name="createdAt", nullable = false, updatable = false)
	@CreationTimestamp
	private LocalDateTime createAt;
	@Column(name="updatedat", nullable = false, updatable = true)
	@UpdateTimestamp
	private LocalDateTime updateAt;
	public int getMealId() {
		return mealId;
	}
	public void setMealId(int mealId) {
		this.mealId = mealId;
	}
	public String getMealName() {
		return mealName;
	}
	public void setMealName(String mealName) {
		this.mealName = mealName;
	}
	public int getMealPrice() {
		return mealPrice;
	}
	public void setMealPrice(int mealPrice) {
		this.mealPrice = mealPrice;
	}
	public Set<Order> getOrders() {
		return orders;
	}
	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}
	
	public int getCalories() {
		return calories;
	}
	public void setCalories(int calories) {
		this.calories = calories;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
	