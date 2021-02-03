<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../shared/_layout.jsp" />
<table class="table table-striped">
<<<<<<< HEAD
	<tr>
	   <th>customerName</th>
		<th>customerId</th>
		<th>customerPhone</th>
		<th>Order ID </th>
		<th> Quantity </th>
		<th> Price </th>
		<th> Date </th>
=======
<<<<<<< HEAD
>>>>>>> 3998b7c00df8fd3c58070cfd13d8bca15945ecfe
=======
>>>>>>> fb4de4dc8a9ee9c157eee9e308114cd91ac2e9e9
>>>>>>> master

 <% 
            if (session.getAttribute("user") != null) {
			
			if ((int) session.getAttribute("cartSize") != 0) { %>
	<tr>
	    <th>Order ID</th>
	    <th>Order Date</th>
	    <th>Order Details</th>
	</tr>
	  
	  <!-- loop in orders -->
	<c:forEach items="${user.getOrders()}" var="order">
	<tr>
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> master

<<<<<<< HEAD
		 <!-- In rayan code Id was hidden not in a Table I mean -->
		<td><a href="${appName}order/detail?id=${Order.orderName}">
		${Order.orderId}</a></td>
		
		<td>${Order.customerName}</td>
		<td>${Order.customerId}</td>
		<td>${Order.customerPhone}</td>
		<td>${Order.orderid}</td>
		<td>${Order.quantity}</td>
		<td>${Order.price}</td>
		<td>${Order.orderDate}</td>
	
		<td>
		<a href="${appName}order/edit?id=${order.orderid}">Edit</a>
		<a href="${appName}order/delete?id=${order.orderid}">Delete</a>
		</td>
=======
		<td>${order.orderId}</td>
		<td>${order.createAt}</td>
		<td><a href="${appName}order/detail?id=${order.orderId}">
		Order details</a></td>
<<<<<<< HEAD
		
>>>>>>> 3998b7c00df8fd3c58070cfd13d8bca15945ecfe
=======
>>>>>>> fb4de4dc8a9ee9c157eee9e308114cd91ac2e9e9
>>>>>>> master
	</tr>
	</c:forEach>
</table>

<%
} else { %><br><br><div class="alert alert-primary" role="alert">You don not have orders!!</div> <% } }%>

