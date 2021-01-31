package com.ga.restaurantapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

//CRUD OPERATIONS
//C -> CREAT
//R -> SELECT
//U -> UPDATE
//D -> DELETE


@Controller
public class HomeController {

	@Autowired 
	private Environment env;
	
	// HTTP GET REQUEST - Root Route
	@GetMapping("/")
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("home/index");
		
		setAppName(mv, env);
		return mv;
	}
	
	// Setting an App name (Other common properties)
	public ModelAndView setAppName(ModelAndView mv, @Autowired Environment env) {
		String appName = env.getProperty("app.name");
		mv.addObject("appName", appName);
		mv.addObject("Welcome", "Welcome to our Restaurant");

		return mv;
	}
	
	
	
}