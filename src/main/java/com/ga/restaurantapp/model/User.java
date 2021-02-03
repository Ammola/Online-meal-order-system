package com.ga.restaurantapp.model;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "users")
public class User {
	
		@Id
		@GeneratedValue
		private int id;
		private String firstName;
		private String lastName;
		private String emailAddress;
		private String mobile;
		private String password;
		private String buildingNumber;
		private String streetName;
		private String district;
		private String city;
		private String postalCode;
		private String additionalNumber;
		private String userRole;
		
		@OneToOne
	    @JoinColumn(name = "cartId", referencedColumnName = "id")
	    private Cart cart;

		@OneToMany(mappedBy="admin")
		private Set<Meal> meals;

		@OneToMany(fetch = FetchType.EAGER, mappedBy="customer", cascade = CascadeType.ALL)
		private Set<Order> orders;
		
		@Column(name="createdAt", nullable = false, updatable = false)
		@CreationTimestamp
		private LocalDateTime createAt;
		
		@Column(name="updatedat", nullable = false, updatable = true)
		@UpdateTimestamp
		private LocalDateTime updateAt;
		
		
		public String getBuildingNumber() {
			return buildingNumber;
		}

		public void setBuildingNumber(String buildingNumber) {
			this.buildingNumber = buildingNumber;
		}

		public String getStreetName() {
			return streetName;
		}

		public void setStreetName(String streetName) {
			this.streetName = streetName;
		}

		public String getDistrict() {
			return district;
		}

		public void setDistrict(String district) {
			this.district = district;
		}

		public String getPostalCode() {
			return postalCode;
		}

		public void setPostalCode(String postalCode) {
			this.postalCode = postalCode;
		}

		public String getAdditionalNumber() {
			return additionalNumber;
		}

		public void setAdditionalNumber(String additionalNumber) {
			this.additionalNumber = additionalNumber;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public String getEmailAddress() {
			return emailAddress;
		}

		public void setEmailAddress(String emailAddress) {
			this.emailAddress = emailAddress;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public LocalDateTime getCreateAt() {
			return createAt;
		}

		public void setCreateAt(LocalDateTime createAt) {
			this.createAt = createAt;
		}

		public LocalDateTime getUpdateAt() {
			return updateAt;
		}

		public void setUpdateAt(LocalDateTime updateAt) {
			this.updateAt = updateAt;
		}

		public String getUserRole() {
			return userRole;
		}

		public void setUserRole(String userRole) {
			this.userRole = userRole;
		}
		
		public Set<Meal> getMeals() {
			return meals;
		}

		public void setMeals(Set<Meal> meals) {
			this.meals = meals;
		}

		public Set<Order> getOrders() {
			return orders;
		}

		public void setOrders(Set<Order> orders) {
			this.orders = orders;
		}
		
		public String getMobile() {
			return mobile;
		}

		public void setMobile(String mobile) {
			this.mobile = mobile;
		}

		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city = city;
		}
		
		public Cart getCart() {
			return cart;
		}

		public void setCart(Cart cart) {
			this.cart = cart;
		}
		
}
