<jsp:include page="../shared/_layout.jsp" />
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<table class="table table-striped">

	<tr>
		<th>Meal Name</th>
		<th>Meal Description</th>
		<th>Price</th>
		<th>calories</th>
		<th>Image</th>
		<%
		if (session.getAttribute("userRole").equals("admin")) {
		%>
		<th>Actions</th>
		<%
		}
		%>
	</tr>
	<c:forEach items="${meals}" var="Meal">

		<tr>
			<td><a href="${appName}meal/detail?id=${Meal.mealId}">${Meal.mealName}</a></td>
			<td>${Meal.description}</td>
			<td>${Meal.mealPrice}</td>
			<td>${Meal.calories}</td>
			<td><img alt="" src="${Meal.mealImg}" width=80px height=80px></td>

			<%
			if (session.getAttribute("userRole").equals("admin")) {
			%>
			<td><a href="${appName}meal/edit?id=${Meal.mealId}">Edit</a> | <a
				href="${appName}meal/delete?id=${Meal.mealId}">Delete</a></td>
			<%
			}
			%>

			<%
	        if (session.getAttribute("user") != null) {
	        %>
	        <td><a class="btn btn-primary" role="button" 
	        href="${appName}cart/add?id=${Meal.mealId}">Add to Cart</a></td>
			<% } %>

		</tr>
	</c:forEach>
</table>