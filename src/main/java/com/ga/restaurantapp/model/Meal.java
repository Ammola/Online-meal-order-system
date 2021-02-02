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
	private int mealPrice;
	private int calories;
	private String description;
	private String mealImg;

	@ManyToOne
	@JoinColumn(name="FK_AdmniId")
	private User admin;
	
	@ManyToMany(mappedBy="OrderedMeals")
	private Set<Order> orders;
	
	@ManyToMany(mappedBy="cartMeals")
	private Set<Cart> carts;
	
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
	public String getMealImg() {
		return mealImg;
	}
	public void setMealImg(String mealImg) {
		this.mealImg = mealImg;
	}
	public User getAdmin() {
		return admin;
	}
	public void setAdmin(User admin) {
		this.admin = admin;
	}
	public Set<Cart> getCarts() {
		return carts;
	}
	public void setCarts(Set<Cart> carts) {
		this.carts = carts;
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
