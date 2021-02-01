package com.ga.restaurantapp.controller;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ga.restaurantapp.dao.CartDao;
import com.ga.restaurantapp.dao.MealDao;
import com.ga.restaurantapp.dao.UserDao;
import com.ga.restaurantapp.model.Cart;
import com.ga.restaurantapp.model.Meal;

@Controller
public class CartController {
	@Autowired
	private Environment env;
	
	@Autowired
	private UserDao dao;
	
	@Autowired
	private MealDao mealDao;
	
	@Autowired
	private CartDao cartDao;
	
	@Autowired
	HttpServletRequest request;
	
	@Autowired
	private UserController uc;
	
	Set<Meal> cartMeals = new HashSet<Meal>();
	
	// HTTP GET REQUEST - Meal Delete
			@GetMapping("/cart/add")
			public String addCart(@RequestParam int id) {
				
				HttpSession session = request.getSession();
				
				// If the user is not logged in
				if(!uc.isUserLoggedIn()) {
						return "redirect:/";
				// If the user role is "user" do not give permission for delete		
				} 
				
				Meal meal = mealDao.findById(id);
				Cart cart = (Cart) session.getAttribute("userCart");
				cartMeals.add(meal);
				cart.setTotal(cart.getTotal()+meal.getMealPrice());
				cart.setCartMeals(cartMeals);
				cartDao.save(cart);
				return "redirect:/meal/index";
			}

}
