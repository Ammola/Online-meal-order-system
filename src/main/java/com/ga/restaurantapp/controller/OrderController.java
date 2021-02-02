package com.ga.restaurantapp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ga.restaurantapp.dao.OrderDao;
import com.ga.restaurantapp.dao.UserDao;
import com.ga.restaurantapp.model.Cart;
import com.ga.restaurantapp.model.Order;
import com.ga.restaurantapp.model.User;


@Controller
public class OrderController {

	
	@Autowired 
	private Environment env;
	
	@Autowired
	private UserController uc;
	
	@Autowired
	HttpServletRequest request;
	
	@Autowired
	private OrderDao orderDao;
	
	@Autowired
	private UserDao userDao;
	
	// HTTP GET REQUEST - Meal Delete
				@GetMapping("/order/add")
				public String addOrder(@RequestParam int id) {
					
					// If the user is not logged in
					if(!uc.isUserLoggedIn()) {
							return "redirect:/";
					// If the user role is "user" do not give permission for delete		
					}
					
					HttpSession session = request.getSession();
					
					//Meal meal = mealDao.findById(id);
					Order order = new Order();
					Cart cart = (Cart) session.getAttribute("userCart");
					User user = (User) session.getAttribute("user");
				
					order.setOrderDate(order.getCreateAt());
					order.setCustomerName(user.getFirstName()+" "+user.getLastName());
					order.setTotal(cart.getTotal());
					
					orderDao.save(order);

					return "redirect:/order/detail?id="+order.getOrderId();
				}
				
				// HTTP GET REQUEST - Author Detail
				@GetMapping("/order/detail")
				public ModelAndView orderIndex(@RequestParam int id) {
					System.out.println(id);
					ModelAndView mv = new ModelAndView();
					//HttpSession session = request.getSession();
					//User user = (User) session.getAttribute("user");
					Order order = orderDao.findById(id);
					mv.setViewName("order/detail");
					mv.addObject("order", order);
					HomeController hc = new HomeController();
					hc.setAppName(mv, env);
					
					return mv;
					
				}
	
	
				/*
				 * //HTTP GET REQUEST - Add Order
				 * 
				 * @GetMapping("/order/cart") public ModelAndView addOrder() { ModelAndView mv =
				 * new ModelAndView(); mv.setViewName("order/cart");
				 * 
				 * HomeController hc = new HomeController(); hc.setAppName(mv, env);
				 * 
				 * return mv ;
				 * 
				 * }
				 * 
				 * @Autowired private OrderDao dao; //HTTP POST REQUEST - Add Order
				 * 
				 * @PostMapping("/order/cart") public String addOrder (Order order) {
				 * dao.save(order); return "redirect:/order/index";
				 * 
				 * }
				 * 
				 * @GetMapping("/order/index") public ModelAndView getAuthor() { var it =
				 * dao.findAll(); ModelAndView mv = new ModelAndView();
				 * mv.setViewName("order/index"); mv.addObject("orders", it); HomeController hc
				 * = new HomeController(); hc.setAppName(mv, env); return mv; }
				 * 
				 * @GetMapping("/order/detail") public ModelAndView orderDetails(@RequestParam
				 * int id) { System.out.println(id); Order order = dao.findById(id);
				 * ModelAndView mv = new ModelAndView(); mv.setViewName("order/detail");
				 * mv.addObject("order", order); HomeController hc = new HomeController();
				 * hc.setAppName(mv, env); return mv; }
				 * 
				 * @GetMapping("/order/edit") public ModelAndView editOrder(@RequestParam int
				 * id) { System.out.println(id); Order order = dao.findById(id); ModelAndView mv
				 * = new ModelAndView(); mv.setViewName("order/edit"); mv.addObject("order",
				 * order); HomeController hc = new HomeController(); hc.setAppName(mv, env);
				 * return mv; }
				 * 
				 * @GetMapping("/order/delete") public String deleteOrder(@RequestParam int id)
				 * { dao.deleteById(id);
				 * 
				 * return "redirect:/order/index"; }
				 */
}
