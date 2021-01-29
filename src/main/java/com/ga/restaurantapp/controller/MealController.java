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
=======
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.ga.restaurantapp.dao.MealDao;
import com.ga.restaurantapp.model.Meal;

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
		hc.setAppName(mv, env);
		
		// If the user is not logged in
		if(!uc.isUserLoggedIn()) {
			mv.setViewName("home/index");
		}
		
		return mv;
	}
	
	@Autowired
	private MealDao dao;
	
	// HTTP POST REQUEST - Meal Add
	@PostMapping("/meal/add")
	public String addMeal(Meal meal) {
		dao.save(meal);
		
		return "redirect:/meal/index";
	}
	
	// HTTP GET REQUEST - Meal Index
		@GetMapping("/meal/index")
		public ModelAndView getMeal() {
			var it = dao.findAll();
			
			ModelAndView mv = new ModelAndView();
			mv.setViewName("meal/index");
			mv.addObject("meals", it);
			
			HomeController hc = new HomeController();
			hc.setAppName(mv, env);
			
			return mv;
		}
		
		// HTTP GET REQUEST - Meal Detail
		@GetMapping("/meal/detail")
		public ModelAndView mealDetails(@RequestParam int id) {
			System.out.println(id);
			
			Meal meal = dao.findById(id);
			
			ModelAndView mv = new ModelAndView();
			mv.setViewName("meal/detail");
			mv.addObject("meal", meal);
			
			HomeController hc = new HomeController();
			hc.setAppName(mv, env);
			
			return mv;
			
		}
		
		// HTTP GET REQUEST - Meal Edit
		@GetMapping("/meal/edit")
		public ModelAndView editMeal(@RequestParam int id) {
			Meal meal = dao.findById(id);
			
			ModelAndView mv = new ModelAndView();
			mv.setViewName("meal/edit");
			mv.addObject("meal", meal);
			
			HomeController hc = new HomeController();
			hc.setAppName(mv, env);
			
			// If the user is not logged in
					if(!uc.isUserLoggedIn()) {
						mv.setViewName("home/index");
					}
			
			return mv;
		}
		
		// HTTP GET REQUEST - Meal Delete
		@GetMapping("/meal/delete")
		public String deleteMeal(@RequestParam int id) {
			
			HttpSession session = request.getSession();
			
			// If the user is not logged in
			if(!uc.isUserLoggedIn()) {
					return "redirect:/";
			// If the user role is "user" do not give permission for delete		
			} else if(session.getAttribute("userRole").equals("user")) {
				return "redirect:/meal/index";
			}
			
			dao.deleteById(id);
			return "redirect:/meal/index";
		}
		
		
	
	

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
