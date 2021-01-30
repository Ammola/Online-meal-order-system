<jsp:include page="../shared/_layout.jsp" />
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<table class="table table-striped">

	<tr>
		<th>Meal Name</th>
		<th>Meal Description</th>

	
			<th>Actions</th>
	    </tr>
        <c:forEach items="${Meals}" var="Meal">

		<tr>
			<td><a href="${appName}meal/detail?id=${Meal.MealId}">${Meal.MealName}</a></td>
			<td>${Meal.Description}</td>

	

				<td><a href="${appName}meal/edit?id=${Meal.MealId}">Edit</a>

	
  					<a href="${appName}meal/delete?id=${Meal.MealId}">Delete</a></td>

		
		</tr>
	</c:forEach>
</table>