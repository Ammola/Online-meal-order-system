package com.ga.restaurantapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class OrderController {

	@GetMapping("/order/add")
	public ModelAndView addOrder() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("order/add");
		
		return mv ;
	}
	
}
