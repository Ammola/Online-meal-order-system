package com.ga.restaurantapp.dao;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.ga.restaurantapp.model.Cart;

public interface CartDao extends CrudRepository<Cart, Integer> {
	public Cart findById(int cartId);
	

	@Modifying
	@Query(value = "DELETE FROM meal_cart WHERE cart_id =:cart_id AND meal_id =:meal_id", nativeQuery = true)
	void deleteByMealIdAndCartId(@Param("meal_id") int mealId, @Param("cart_id") int cartId);
	
	@Modifying
	@Query(value = "DELETE FROM meal_cart WHERE cart_id =:cart_id", nativeQuery = true)
	void deleteByCartId(@Param("cart_id") int cartId);

}
