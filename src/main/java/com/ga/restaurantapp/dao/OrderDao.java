package com.ga.restaurantapp.dao;

import org.springframework.data.repository.CrudRepository;
<<<<<<< HEAD

import com.ga.restaurantapp.model.Order;

public interface OrderDao extends CrudRepository<Order, Integer> {
=======
>>>>>>> master

import com.ga.restaurantapp.model.Order;

public interface OrderDao extends CrudRepository<Order, Integer> {
	public Order findById(int id);
}