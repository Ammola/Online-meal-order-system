<jsp:include page="../shared/_layout.jsp" />
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<table class="table table-striped">
	<tr>
		<%
		if (session.getAttribute("user") != null) {
			if (session.getAttribute("userRole").equals("admin")) {
		%>
		<th>Meal ID</th>
		<%
		}
		}
		%>
		<th>Meal Name</th>
		<th>MealPrice</th>
		<th>Calories</th>
		<th>Description</th>
		<th>Image</th>
	</tr>

	<tr>
		<%
		if (session.getAttribute("user") != null) {
			if (session.getAttribute("userRole").equals("admin")) {
		%>
		<td>${meal.mealId}</td>
		<%
		}
		}
		%>
		<td>${meal.mealName}</td>
		<td>${meal.mealPrice}</td>
		<td>${meal.calories}</td>
		<td>${meal.description}</td>
		<td><img alt="" src="${meal.mealImg}" width=300px height=300px></td>
	</tr>

</table>
