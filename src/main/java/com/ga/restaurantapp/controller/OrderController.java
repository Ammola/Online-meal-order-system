package com.ga.restaurantapp.controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ga.restaurantapp.dao.OrderDao;
import com.ga.restaurantapp.model.Order;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller


public class OrderController {
	@Autowired 
	private Environment env;
	
	@Autowired
	private UserController uc;
	
	@Autowired
	HttpServletRequest request;
	
	// HTTP GET REQUEST - Order Add
	@GetMapping("/order/add")
	public ModelAndView addOrder() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("order/add");
		
		HomeController hc = new HomeController();
		hc.setAppName(mv, env);
		
		// If the user is not logged in
		if(!uc.isUserLoggedIn()) {
			mv.setViewName("home/index");
		}
		
		return mv;
	}
	
	@Autowired
	private OrderDao dao;
	
	// HTTP POST REQUEST - Order Add
	@PostMapping("/order/add")
	public String addOrder(Order order) {
		dao.save(order);
		
<<<<<<< HEAD
	}
	
	@GetMapping("/order/index")
	public ModelAndView getAuthor() {
		var it = dao.findAll();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("order/index");
		mv.addObject("orders", it);
		HomeController hc = new HomeController();
		hc.setAppName(mv, env);
		return mv;
	}
	@GetMapping("/order/detail")
	public ModelAndView orderDetails(@RequestParam int id) {
		System.out.println(id);
		Order order = dao.findById(id);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("order/detail");
		mv.addObject("order", order);
		HomeController hc = new HomeController();
		hc.setAppName(mv, env);
		return mv;
	}
	@GetMapping("/order/edit")
	public ModelAndView editOrder(@RequestParam int id) {
		System.out.println(id);
		Order order = dao.findById(id);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("order/edit");
		mv.addObject("order", order);
		HomeController hc = new HomeController();
		hc.setAppName(mv, env);
		return mv;
	}
	@GetMapping("/order/delete")
	public String deleteOrder(@RequestParam int id) {
		dao.deleteById(id);

		return "redirect:/order/index";
	}
}
=======
		return "redirect:/order/index";
	}
	
	// HTTP GET REQUEST - Order Index
		@GetMapping("/order/index")
		public ModelAndView getOrder() {
			var it = dao.findAll();
			
			ModelAndView mv = new ModelAndView();
			mv.setViewName("order/index");
			mv.addObject("orders", it);
			
			HomeController hc = new HomeController();
			hc.setAppName(mv, env);
			
			return mv;
		}
		
		// HTTP GET REQUEST - Order Detail
		@GetMapping("/order/detail")
		public ModelAndView orderDetails(@RequestParam int id) {
			System.out.println(id);
			
			Order order = dao.findById(id);
			
			ModelAndView mv = new ModelAndView();
			mv.setViewName("order/detail");
			mv.addObject("order", order);
			
			HomeController hc = new HomeController();
			hc.setAppName(mv, env);
			
			return mv;
			
		}
		
		// HTTP GET REQUEST - Order Edit
		@GetMapping("/order/edit")
		public ModelAndView editOrder(@RequestParam int id) {
			Order order = dao.findById(id);
			
			ModelAndView mv = new ModelAndView();
			mv.setViewName("order/edit");
			mv.addObject("order", order);
			
			HomeController hc = new HomeController();
			hc.setAppName(mv, env);
			
			// If the user is not logged in
					if(!uc.isUserLoggedIn()) {
						mv.setViewName("home/index");
					}
			
			return mv;
		}
		
		// HTTP GET REQUEST - Order Delete
		@GetMapping("/order/delete")
		public String deleteOrder(@RequestParam int id) {
			
			HttpSession session = request.getSession();
			
			// If the user is not logged in
			if(!uc.isUserLoggedIn()) {
					return "redirect:/";
			// If the user role is "user" do not give permission for delete		
			} else if(session.getAttribute("userRole").equals("user")) {
				return "redirect:/order/index";
			}
			
			dao.deleteById(id);
			return "redirect:/order/index";
		}
		 
		@GetMapping("/order/confirm")
		public ModelAndView cunOrder(Order order) {
			ModelAndView mv = new ModelAndView();
			mv.addObject("order", order);
			mv.setViewName("order/confirm");
			
			HomeController hc = new HomeController();
			hc.setAppName(mv, env);
			
			// If the user is not logged in
			if(!uc.isUserLoggedIn()) {
				mv.setViewName("home/index");
			}
			
			return mv;
		}
		
		
		
		

}

>>>>>>> Ibrahim-dev
