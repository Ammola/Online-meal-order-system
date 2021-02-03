package com.ga.restaurantapp.controller;

import java.util.HashSet;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ga.restaurantapp.dao.CartDao;
import com.ga.restaurantapp.dao.MealDao;
import com.ga.restaurantapp.dao.UserDao;
import com.ga.restaurantapp.model.*;
//import com.ga.restaurantapp.model.Meal;
//import com.ga.restaurantapp.model.User;

@Controller
public class CartController {
	@Autowired
	private Environment env;
	
	@Autowired
	private UserDao userdao;
	
	@Autowired
	private MealDao mealDao;
	
	@Autowired
	private CartDao cartDao;
	
	@Autowired
	HttpServletRequest request;
	
	@Autowired
	private UserController uc;
	
	@GetMapping("/cart/add")
	public String addCart(@RequestParam int id) {
		
		HttpSession session = request.getSession();
		
		Set<Meal> cartMeals = new HashSet<Meal>();
		
		// If the user is not logged in
		if(!uc.isUserLoggedIn()) {
				return "redirect:/";
		// If the user role is "user" do not give permission for delete		
		} 
		
		Meal meal = mealDao.findById(id);
		User user = (User) session.getAttribute("user");
		Cart cart = user.getCart();
		cart = cartDao.findById(cart.getId());
		cartMeals = cart.getCartMeals();
		cartMeals.add(meal);
		cart.setTotal(cart.getTotal()+meal.getMealPrice());
		cart.setCartMeals(cartMeals);
		cartDao.save(cart);
		
		System.out.println("cart.getCartMeals()   "+cart.getCartMeals().size());
		System.out.println("cartMeals   "+cartMeals.size());
	
		return "redirect:/meal/index";
	}
			
			
			// HTTP GET REQUEST - Author Detail
			@GetMapping("/cart/get-index")
			public String cartIndex() {
				
				HttpSession session = request.getSession();
				
				Cart cart = (Cart) session.getAttribute("userCart");
				
				int cartId = cart.getId();
				
				if(!uc.isUserLoggedIn())
				{
					return "redirect:/";
				}
			  
			  return "redirect:/cart/index?id="+cartId;
				
			}
			
			// HTTP GET REQUEST - profile Edit
			@GetMapping("/cart/index")
			public ModelAndView editPassword(@RequestParam int id) {
			Cart cart = cartDao.findById(id);
				
			ModelAndView mv = new ModelAndView();
			mv.setViewName("cart/index");
			mv.addObject("cart", cart);
				
			HomeController hc = new HomeController();
			hc.setAppName(mv, env);
			
			HttpSession session = request.getSession();
			session.setAttribute("cartSize", cart.getCartMeals().size());
				
			if(!uc.isUserLoggedIn())
				{
					mv.setViewName("home/index");
				}
				
				return mv;
			}
			
			// HTTP GET REQUEST - Meal Delete
						@Transactional
						@GetMapping("/cart/delete")
						public String deleteMeal(@RequestParam int id) {
							HttpSession session = request.getSession();
							User user = (User) session.getAttribute("user");
							Cart cart = user.getCart();
							Meal meal = mealDao.findById(id);
							System.out.println("meal id "+id);
							System.out.println("cart id "+cart.getId());
							//cart.setCartMeals(cartMeals);
							System.out.println(cart);
							cartDao.deleteByMealIdAndCartId(id, cart.getId());
							cart = cartDao.findById(cart.getId());
							cart.setTotal(cart.getTotal() - meal.getMealPrice());
							cartDao.save(cart);
							
							/*
							 * Meal meal = mealDao.findById(id);
							 * 
							 * // cart.cartMeals.remove();
							 * 
							 * Set<Meal> meals = cart.getCartMeals();
							 * 
							 * meals.remove(meal);
							 * 
							 * cart.setCartMeals(meals);
							 * 
							 * cartDao.save(cart);
							 */
							 
							 //int oldId = id;
							 
							 // mealDao.deleteById(id); mealDao.save(meal);
							  
							 // meal.setMealId(oldId);
							  
							 // System.out.println("meal Id "+meal.getMealId());
							 			
							
							//meals = cart.getCartMeals();
							
							//System.out.println(meals);
							
							/*
							 * if(meals.remove(meal)) { mv.addObject("message",
							 * "The meal was removed successfully from the cart");
							 * System.out.println("meal removed"); System.out.println(meal.getMealName()); }
							 */
							
							//System.out.println(meal.getMealName());
							//cart.setCartMeals(meals);
							
							// If the user is not logged in
							if(!uc.isUserLoggedIn()) {
								return "redirect:/";
							// If the user role is "user" do not give permission for delete		
							} 
							
							session.setAttribute("message", "The meal was removed successfully from the cart");
							return "redirect:/cart/index?id="+cart.getId();
							
						}
			

}