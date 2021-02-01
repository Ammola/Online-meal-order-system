<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../shared/_layout.jsp" />
<table class="table table-striped">
	<tr>
	   <th>customerName</th>
		<th>customerId</th>
		<th>customerPhone</th>
		<th>Order ID </th>
		<th> Quantity </th>
		<th> Price </th>
		<th> Date </th>
		<th> Action </th>
	</tr>
	  
	  <!-- loop in orders -->
	<c:forEach items="${orders}" var="order">
	<tr>
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
	</tr>
	</c:forEach>
</table>
