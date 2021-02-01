package com.ga.restaurantapp.controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.ga.restaurantapp.dao.UserDao;
import com.ga.restaurantapp.model.User;


@Controller
public class UserController {
	@Autowired
	private Environment env;
	
	@Autowired
	private UserDao dao;
	
	@Autowired
	HttpServletRequest request;
	
	@Autowired
	private UserController uc;
	
	// Routes 
	
	// To load the registration form
	   @GetMapping("/user/registration")
	   public ModelAndView registration() {
		   
		   ModelAndView mv = new ModelAndView();
		   mv.setViewName("user/registration");
		   
		   HomeController hc = new HomeController();
		   hc.setAppName(mv, env);
		   
		   return mv;
	   }
	
	// To post the registration form
	 @PostMapping("/user/registration")
	 public ModelAndView registration(User user) {

		 
		 ModelAndView mv = new ModelAndView();
		 mv.setViewName("user/login");
		 
		 HomeController hc = new HomeController();
		 hc.setAppName(mv, env);
		 
		 // Check to user is already registered or not
		 
		 var it = dao.findAll();
		 
		 for(User dbUser : it) {
			 if(dbUser.getEmailAddress().equals(user.getEmailAddress())) {
				 mv.addObject("alarm", "User already exists");
				 return mv;
			 }
		 }
		 
		 
		 // Password Encryption
		 BCryptPasswordEncoder bCrypt = new BCryptPasswordEncoder();
		 String newPassword = bCrypt.encode(user.getPassword());
		 user.setPassword(newPassword);
		 
		 dao.save(user);
		 mv.addObject("message", "User registered successfully");
		 
		 return mv;
		 
	 }
	
	// To load the login form
	@GetMapping("/user/login")
		public ModelAndView login() {
			ModelAndView mv = new ModelAndView();
			mv.setViewName("user/login");
			
			HomeController hc = new HomeController();
			hc.setAppName(mv, env);
			
			return mv;
		}
	
	// To post the login form
		 @PostMapping("/user/login")
		public String login(User user) {
			 
			 BCryptPasswordEncoder bCrypt = new BCryptPasswordEncoder();
			 
			 String emailAddress = user.getEmailAddress();
			 String password = user.getPassword();
			 
			 User matchedUser = dao.findByEmailAddress(emailAddress);
			 HttpSession session = request.getSession();

			 if(matchedUser != null) {
				 if(bCrypt.matches(password, matchedUser.getPassword())) {
					 
					 // Session
					  session.setAttribute("user", matchedUser);
					  session.setAttribute("userRole", matchedUser.getUserRole());
					  session.setAttribute("userId", matchedUser.getId());
					  
					  session.setAttribute("message", "you are logged in successfully");
					  
					  System.out.println("is password matched?");
					  System.out.println(bCrypt.matches(password, matchedUser.getPassword()));
					  
					  return "redirect:/";
					 
				 }
			 }
			
		
		  session.setAttribute("alarm", "Username or password is incorrect"); return
		 "redirect:/user/login"; }
		 
		
		// To invalidate the current user session
		
		  @GetMapping("/user/logout") public String logout() { 
		  HttpSession session = request.getSession(); 
		  session.invalidate();
		  
		  return "redirect:/user/login"; }
		 
		
		// TO check the user is logged in or not
		
		  public boolean isUserLoggedIn() {
		 
		  HttpSession session = request.getSession(); if(session.getAttribute("user")
		  == null) { return false; } else { return true; } }
		 
		
		  // Load user profile	  
		  @GetMapping("/user/profile") public ModelAndView profile() {
		  
		  HttpSession session = request.getSession(); 
		  int userId = (int) session.getAttribute("userId");
		 
		  User user = dao.findById(userId);
		 
		  ModelAndView mv = new ModelAndView(); mv.setViewName("user/profile");
		  mv.addObject("user", user);
		 
		  HomeController hc = new HomeController(); hc.setAppName(mv, env);
		  
			
		if(!uc.isUserLoggedIn())
				{
					mv.setViewName("home/index");
				}
				
		  
		  return mv; }
		  
		// HTTP GET REQUEST - profile Edit
			@GetMapping("/user/edit")
			public ModelAndView editProfile(@RequestParam int id) {
			User user = dao.findById(id);
				
			ModelAndView mv = new ModelAndView();
			mv.setViewName("user/edit");
			mv.addObject("user", user);
				
			HomeController hc = new HomeController();
			hc.setAppName(mv, env);
				
			if(!uc.isUserLoggedIn())
				{
					mv.setViewName("home/index");
				}
				
				return mv;
			}
			
			//// HTTP GET REQUEST - profile Edit
			@GetMapping("/user/edit-profile")
			public String editProfileButton() {
				
				HttpSession session = request.getSession(); 
				int userId = (int) session.getAttribute("userId");
				
				if(!uc.isUserLoggedIn())
				{
					return "redirect:/home/index";
				}
				 
				//User user = dao.findById(userId);
				return "redirect:/user/edit?id="+userId; 			
				
				}
						
								
			// To post the registration form
			 @PostMapping("/user/edit-profile")
			 public ModelAndView editProfile(User user) {

				 
				 ModelAndView mv = new ModelAndView();
				 mv.setViewName("user/profile");
				 
				 HomeController hc = new HomeController();
				 hc.setAppName(mv, env);
				
				 // Password Encryption
				 //BCryptPasswordEncoder bCrypt = new BCryptPasswordEncoder();
				 
				 String newPassword = user.getPassword();
				 String role = user.getUserRole();
				 
				 user.setPassword(newPassword);
				 //System.out.println("role"+role);
				 //user.setPassword(bCrypt.encode(newPassword));
				 user.setUserRole(role);
				 
				 dao.save(user);
				 mv.addObject("message", "Your profile was updated successfully");
				 
					
				if(!uc.isUserLoggedIn())
						{
							mv.setViewName("home/index");
						}
						
				 
				 return mv;
				 
			 }
			 
				/*
				 * //// HTTP GET REQUEST - profile Edit
				 * 
				 * @GetMapping("/user/edit-profile") public String editPassword() {
				 * 
				 * HttpSession session = request.getSession(); int userId = (int)
				 * session.getAttribute("userId");
				 * 
				 * //User user = dao.findById(userId); return
				 * "redirect:/user/edit-password?id="+userId;
				 * 
				 * }
				 */
					/*
					 * // To post the registration form
					 * 
					 * @PostMapping("/user/edit-password") public ModelAndView editPassword(User
					 * user) {
					 * 
					 * 
					 * ModelAndView mv = new ModelAndView(); mv.setViewName("user/profile");
					 * 
					 * HomeController hc = new HomeController(); hc.setAppName(mv, env);
					 * 
					 * // Password Encryption BCryptPasswordEncoder bCrypt = new
					 * BCryptPasswordEncoder();
					 * 
					 * String newPassword = user.getPassword(); String role = user.getUserRole();
					 * 
					 * user.setPassword(newPassword); //System.out.println("role"+role);
					 * user.setPassword(bCrypt.encode(newPassword));
					 * user.setFirstName(user.getFirstName()); user.setLastName(user.getLastName());
					 * user.setEmailAddress(user.getEmailAddress());
					 * user.setStreetName(user.getStreetName());
					 * user.setAdditionalNumber(user.getAdditionalNumber());
					 * user.setBuildingNumber(user.getBuildingNumber());
					 * user.setDistrict(user.getDistrict());
					 * user.setPostalCode(user.getPostalCode()); user.setCity(user.getCity());
					 * user.setUserRole(user.getUserRole()); user.setMobile(user.getMobile());
					 * 
					 * dao.save(user); mv.addObject("message",
					 * "Your password was updated successfully");
					 * 
					 * return mv;
					 * 
					 * }
					 * 
					 */
		
		
		// Load user cart
		@GetMapping("/user/cart")
		public ModelAndView cart() {
					   
			   ModelAndView mv = new ModelAndView();
			   mv.setViewName("user/cart");
					   
			   HomeController hc = new HomeController();
			   hc.setAppName(mv, env);
					   
			   return mv;
				   }
		
		
	 
}


