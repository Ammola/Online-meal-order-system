<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../shared/_layout.jsp" />
<table class="table table-striped">

 <% 
            if (session.getAttribute("user") != null) {
			
			if ((int) session.getAttribute("orderSize") != 0) { %>
	<tr>
	    <th>Order ID</th>
	    <th>Order Date</th>
	    <th>Order Details</th>
	</tr>
	  
	  <!-- loop in orders -->
	<c:forEach items="${user.getOrders()}" var="order">
	<tr>
		<td>${order.orderId}</td>
		<td>${order.createAt}</td>
		<td><a href="${appName}order/detail?id=${order.orderId}">
		Order details</a></td>
		
	</tr>
	</c:forEach>
</table>

<%
} else { %><br><br><div class="alert alert-primary" role="alert">You don not have orders!!</div> <% } }%>

