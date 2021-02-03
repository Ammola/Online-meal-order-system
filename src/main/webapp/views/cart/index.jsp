<jsp:include page="../shared/_layout.jsp" />
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<table class="table table-striped">

            <% 
            if (session.getAttribute("user") != null) {
			
			if ((int) session.getAttribute("cartSize") != 0) { %>
			

	<tr>
		<th>Meal Name</th>
		<th>Meal Description</th>
		<th>Price</th>
		<th>calories</th>
		<th>Image</th>
		
	</tr>
	<c:forEach items="${cart.getCartMeals()}" var="Meal">

		<tr>
			<td><a href="${appName}meal/detail?id=${Meal.mealId}">${Meal.mealName}</a></td>
			<td>${Meal.description}</td>
			<td>${Meal.mealPrice}</td>
			<td>${Meal.calories}</td>
			<td><img alt="" src="${Meal.mealImg}" width=80px height=80px></td>

			
			<td><a href="${appName}cart/edit?id=${Meal.mealId}">Edit</a> | <a
				href="${appName}cart/delete?id=${Meal.mealId}">Delete</a></td>
			

		</tr>
	</c:forEach>	
</table>

<b>Total: ${cart.getTotal()}</b>

<a class="btn btn-primary" role="button" href="${appName}order/add?id=${cart.getId()}">Checkout</a>

<%
} else { %><br><br><div class="alert alert-primary" role="alert">Your cart is empty!!</div> <% } }%>

