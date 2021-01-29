<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../shared/_layout.jsp" />

Male's Name: ${meal.name} <br>
Email Address: ${meal.emailAddress} <br>

Gender: ${meal.gender} <br>
Date of Birth: ${meal.dateofBirth} <br><br>

	<c:forEach items="${meal.getOrders()}" var="order">
			<div>Title: ${order.title} </div> 

			<div> Description: ${order.description} </div> 
			
			<hr>
	</c:forEach>
