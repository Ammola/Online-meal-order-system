<jsp:include page="../shared/_layout.jsp" />
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<% 
if (session.getAttribute("user") != null) {			
if ((int) session.getAttribute("cartSize") != 0) { 
%>
<div class="card-deck">
<c:forEach items="${cart.getCartMeals()}" var="Meal">
  <div class="card">
  <div class="card-body">
  <img src="${Meal.mealImg}" alt="Card image cap" width=200px height=200px>
    <h5 class="card-title"><a href="${appName}meal/detail?id=${Meal.mealId}">${Meal.mealName}</a></h5>
    <p class="card-text"><b>Price :</b>${Meal.mealPrice} SR</p>
    <p class="card-text"><b>Calories :</b>${Meal.calories}</p>
    <a href="${appName}cart/delete?id=${Meal.mealId}" class="btn btn-warning">Remove</a>
  </div>
</div>
</c:forEach>
</div>
<br><br>
<h5>
<b>Total:</b> ${cart.getTotal()} SR
<a class="btn btn-warning" role="button" href="${appName}order/add?id=${cart.getId()}">Checkout</a>
</h5>

<%
} else { 
%><br><br><div class="alert alert-primary" role="alert">Your cart is empty!!
<a href="${appName}meal/index">Click here to start adding meals</a></div> 
<% 
} }
%>