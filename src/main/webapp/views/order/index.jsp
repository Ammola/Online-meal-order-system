<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../shared/_layout.jsp" />
<table class="table table-striped">

 <% 
            if (session.getAttribute("user") != null) {
			
			if ((int) session.getAttribute("cartSize") != 0) { %>
	<tr>
	    <th>Order ID</th>
	    <th>Order Date</th>
	</tr>
	  
	  <!-- loop in orders -->
	<c:forEach items="${user.getOrders()}" var="order">
	<tr>
		<td><a href="${appName}order/detail?id=${order.id}">
		Order details</a></td>
		
		<td>${order.id}</td>
		<td>${order.createAt}</td>
	</tr>
	</c:forEach>
</table>

<%
} else { %><br><br><div class="alert alert-primary" role="alert">You don not have orders!!</div> <% } }%>

