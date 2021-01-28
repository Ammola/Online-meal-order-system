package com.ga.restaurantapp.model;

import java.util.Set;

import javax.persistence.*;


@Entity
@Table(name="Meal")
public class Meal {
	
	@Id
	@GeneratedValue
	private int MealId;
	private String MealName;
	@Column(length = 50)
	private int MealPrice;
	
	//@ManyToMany(mappedBy="Order")
	//private Set<Order> orders;

}
	