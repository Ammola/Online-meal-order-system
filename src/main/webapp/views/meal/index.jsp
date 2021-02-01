<jsp:include page="../shared/_layout.jsp" />
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<table class="table table-striped">

	<tr>
		<th>Meal Name</th>
		<th>Meal Description</th>
          <th>Price</th>
          <th>calories</th>
           <th>Image</th>
			<th>Actions</th>
	    </tr>
        <c:forEach items="${meals}" var="Meal">

		<tr>
			<td><a href="${appName}meal/detail?id=${Meal.mealId}">${Meal.mealName}</a></td>
			<td>${Meal.description}</td>
			<td>${Meal.mealPrice}</td>
			<td>${Meal.calories}</td>
			<td><img alt="" src="${Meal.mealImg}" width =80px height=80px></td>


				<td><a href="${appName}meal/edit?id=${Meal.mealId}">Edit</a>
  					<a href="${appName}meal/delete?id=${Meal.mealId}">Delete</a>
  					<form action="${appName}order/confirm">
                     <input type="submit" value="Confirm" />
                      </form>
                      </td>
		
		</tr>
	</c:forEach>
</table>