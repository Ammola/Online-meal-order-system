package com.ga.restaurantapp.dao;

import org.springframework.data.repository.CrudRepository;

import com.ga.restaurantapp.model.Meal;

public interface MealDao extends CrudRepository <Meal, Integer>{

	public Meal findById(int MealId);
}
