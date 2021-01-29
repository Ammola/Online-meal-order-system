package com.ga.restaurantapp.controller;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ga.restaurantapp.controller.HomeController;
import com.ga.restaurantapp.controller.UserController;

@Controller
public class MealController {
	

	@Autowired 
	private Environment env;
	
	@Autowired
	private UserController uc;
	
	@Autowired
	HttpServletRequest request;
	
	// HTTP GET REQUEST - Meal Add
	@GetMapping("/meal/add")
	public ModelAndView addMeal() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("meal/add");
		
		HomeController hc = new HomeController();
		return hc.setAppName(mv, env);

}}
