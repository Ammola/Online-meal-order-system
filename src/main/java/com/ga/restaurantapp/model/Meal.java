package com.ga.restaurantapp.model;
import java.time.LocalDateTime;
import java.util.Set;
import javax.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


@Entity
@Table(name="Meal")
public class Meal {
	
	@Id
	@GeneratedValue
	private int MealId;
	private String MealName;
	@Column(length = 50)
	private int MealPrice;
	
//	@ManyToMany(mappedBy="meals")
//	private Set<Order> orders;
//	@Column(name="createdAt", nullable = false, updatable = false)
//	@CreationTimestamp
//	private LocalDateTime createAt;
//	@Column(name="updatedat", nullable = false, updatable = true)
//	@UpdateTimestamp
//	private LocalDateTime updateAt;
//	@ManyToMany
//	@JoinTable(name = "OrderMeals", joinColumns = { @JoinColumn(name = "MealId")}
//	, inverseJoinColumns = { @JoinColumn(name ="OrderId")})
	
//	private Set<Order> orders;

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
	}

//	public Set<Order> getOrders() {
//		return orders;
//	}
//
//	public void setOrders(Set<Order> orders) {
//		this.orders = orders;
//	}
	

}
	