package com.ga.restaurantapp.dao;

import org.springframework.data.repository.CrudRepository;

import com.ga.restaurantapp.model.Order;

public interface OrderDao extends CrudRepository<Order, Integer> {

}
