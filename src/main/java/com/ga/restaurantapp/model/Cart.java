package com.ga.restaurantapp.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Cart")
public class Cart {
	
	@Id
	@GeneratedValue
	private int id;
	
	private int total;
	
	private int quantity; 
	
	@OneToOne(mappedBy ="cart")
	private User user;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "meal_cart",
				joinColumns = { @JoinColumn(name = "cart_id") },
				inverseJoinColumns = { @JoinColumn(name = "meal_id")})
	private Set<Meal> cartMeals;
	
	public Set<Meal> getCartMeals() {
		return cartMeals;
	}

	public void setCartMeals(Set<Meal> cartMeals) {
		this.cartMeals = cartMeals;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	

}