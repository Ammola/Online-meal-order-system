package com.ga.restaurantapp.model;
import java.time.LocalDateTime;
import java.util.Set;
import javax.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
@Entity

@Table(name="Meal")

@Table(name="meals")
public class Meal {
	@Id
	@GeneratedValue

	private int MealId;
	private String MealName;
	@Column(length = 50)
	private int MealPrice;
	private int Calories;
	private String Description;
	
	@ManyToMany(mappedBy="meals")
	private Set<Order> orders;
	@Column(name="createdAt", nullable = false, updatable = false)
	@CreationTimestamp
	private LocalDateTime createAt;
	private int mealId;
	@Column(length = 50)
	private String mealName;
	private int mealPrice;
	@ManyToOne
	@JoinColumn(name="FK_AdmiId")
	private User admin;
	@ManyToMany(mappedBy="meals")
	private Set<Order> orders;
	@Column(name="createdAt", nullable = false, updatable = false)
	@CreationTimestamp
	private LocalDateTime createAt;
<<<<<<< HEAD
=======
	

>>>>>>> Ibrahim-dev
	@Column(name="updatedat", nullable = false, updatable = true)
	@UpdateTimestamp
	private LocalDateTime updateAt;
	public int getMealId() {

		return MealId;
	}

	public void setMealId(int mealId) {
		MealId = mealId;
	}

	public String getMealName() {
		return MealName;
	}

	public void setMealName(String mealName) {
		MealName = mealName;
	}

	public int getMealPrice() {
		return MealPrice;
	}

	public void setMealPrice(int mealPrice) {
		MealPrice = mealPrice;

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
<<<<<<< HEAD
=======

<
	public int getCalories() {
		return Calories;
	}

	public void setCalories(int calories) {
		Calories = calories;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}
	
>>>>>>> Ibrahim-dev
	public LocalDateTime getCreateAt() {
		return createAt;
	}
	public void setCreateAt(LocalDateTime createAt) {
		this.createAt = createAt;
	}
	public LocalDateTime getUpdateAt() {
		return updateAt;
	}
<<<<<<< HEAD
=======


>>>>>>> Ibrahim-dev
	public void setUpdateAt(LocalDateTime updateAt) {
		this.updateAt = updateAt;
	}
}
	