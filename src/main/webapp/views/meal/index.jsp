  
<jsp:include page="../shared/_layout.jsp" />
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<br><br><br>
<div class="row">
<div class="col-sm-6">
<c:forEach items="${meals}" var="Meal">
<div class="card" style="width: 30rem;">
  <img class="card-img-top" src="${Meal.mealImg}" alt="Card image cap">
  <div class="card-body">
    <h3 class="card-title"><a href="${appName}meal/detail?id=${Meal.mealId}">${Meal.mealName}</a></h3>
    <p class="card-text">${Meal.description}</p>
    <p class="card-text"><b>Calories:</b> ${Meal.calories}</p>
    <p class="card-text"><b>Price:</b> ${Meal.mealPrice} SR</p>
    <%
	if (session.getAttribute("user") != null) {
	%>
    <a class="btn btn-warning" role="button" 
	 href="${appName}cart/add?id=${Meal.mealId}">Add to Cart</a>
	 <% } %>
	 <%
			if (session.getAttribute("user") != null) {
			if (session.getAttribute("userRole").equals("admin")) {
			%>
			<br><br><br>
			<p class="card-text">
			<a href="${appName}meal/edit?id=${Meal.mealId}">Edit</a> | <a
				href="${appName}meal/delete?id=${Meal.mealId}">Delete</a>
		    </p>
			<%
			}
			}
			%>
  </div>
</div>
</div>
<br><br>
</c:forEach>
</div>
