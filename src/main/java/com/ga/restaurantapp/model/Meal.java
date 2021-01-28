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
	private int mealId;
	private String mealName;
	@Column(length = 50)
	private int mealPrice;
	
	@ManyToMany(mappedBy="meals")
	private Set<Order> orders;
	
	@Column(name="createdAt", nullable = false, updatable = false)
	@CreationTimestamp
	private LocalDateTime createAt;
	
	@Column(name="updatedat", nullable = false, updatable = true)
	@UpdateTimestamp
	private LocalDateTime updateAt;


}
	