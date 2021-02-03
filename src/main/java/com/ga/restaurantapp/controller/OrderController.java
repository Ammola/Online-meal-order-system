package com.ga.restaurantapp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ga.restaurantapp.dao.CartDao;
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
	private CartDao cartDao;
	
	@Autowired
	private UserDao userDao;
	
	// HTTP GET REQUEST - Meal Delete
	            @Transactional
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
					User user = (User) session.getAttribute("user");
					Cart cart = user.getCart();

					cart = cartDao.findById(cart.getId());

					order.setOrderDate(order.getCreateAt());
					order.setCustomerName(user.getFirstName()+" "+user.getLastName());
					order.setTotal(cart.getTotal());
					order.setCustomer(user);
					
					System.out.println("cart total "+cart.getTotal());
					System.out.println("order total "+order.getTotal());

					orderDao.save(order);
					cartDao.deleteByCartId(cart.getId());
					cart = cartDao.findById(cart.getId());
					cart.setTotal(0);
					cartDao.save(cart);

					return "redirect:/order/detail?id="+order.getOrderId();
				}
				
				// HTTP GET REQUEST - Author Detail
				@GetMapping("/order/detail")
				public ModelAndView orderDetail(@RequestParam int id) {
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
				
				// HTTP GET REQUEST - Author Detail
				@GetMapping("/order/get-index")
				public String getOrderIndex() {
					
					HttpSession session = request.getSession();
					
					int userId = (int) session.getAttribute("userId");
					
					if(!uc.isUserLoggedIn())
					{
						return "redirect:/";
					}
				  
				  return "redirect:/order/index?id="+userId;
					
				}
				
				// HTTP GET REQUEST - profile Edit
				@GetMapping("/order/index")
				public ModelAndView orderIndex(@RequestParam int id) {
				
				User user = userDao.findById(id);
					
				ModelAndView mv = new ModelAndView();
				mv.setViewName("order/index");
				mv.addObject("user", user);
					
				HomeController hc = new HomeController();
				hc.setAppName(mv, env);
				
				HttpSession session = request.getSession();
				session.setAttribute("orderSize", user.getOrders().size());
					
				if(!uc.isUserLoggedIn())
					{
						mv.setViewName("home/index");
					}
					
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

