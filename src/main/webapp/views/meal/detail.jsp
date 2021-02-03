<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../shared/_layout.jsp" />


Meal's Name: ${meal.MealName} <br>
Description: ${meal.Description} <br>

<table>
	<c:forEach items="${meal.getOrders()}" var="orders">
		<tr>
			<td>Meal's Name: ${orders.meals.MealName} </td>
		</tr>
		<tr>
			<td> Description: ${orders.meals.Description} </td>
		</tr>
	</c:forEach>
</table>
