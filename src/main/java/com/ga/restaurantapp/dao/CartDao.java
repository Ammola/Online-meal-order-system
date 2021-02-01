package com.ga.restaurantapp.dao;
import org.springframework.data.repository.CrudRepository;
import com.ga.restaurantapp.model.Cart;

public interface CartDao extends CrudRepository<Cart, Integer> {
	public Cart findById(int cartId);
}
