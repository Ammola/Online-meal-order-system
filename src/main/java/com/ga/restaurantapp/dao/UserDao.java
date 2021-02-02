package com.ga.restaurantapp.dao;

import org.springframework.data.repository.CrudRepository;

import com.ga.restaurantapp.model.User;


public interface UserDao extends CrudRepository<User, Integer> {
	public User findByEmailAddress(String emailAddress);
	public User findById(int id);
}