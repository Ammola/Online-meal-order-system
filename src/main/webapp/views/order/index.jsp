<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../shared/_layout.jsp" />
<table>
	<tr>
	    <th>Order ID</th>
	    <th>Customer Name</th>
	    <th>Order Date</th>
		<th>Total</th>
	</tr>
	  
	  <!-- loop in orders -->
	<c:forEach items="${orders}" var="order">
	<tr>

		 <!-- In rayan code Id was hidden not in a Table I mean -->
		<td><a href="${appName}order/detail?customerId=${order.customerName}">
		${order.customerId}</a></td>
		
		<td><a href="">${  order.customerPhone}</a></td>
		<td><a href="">${  order.orderid}</a></td>
		<td><a href="">${  order.quantity}</a></td>
		<td><a href="">${  order.price}</a></td>
		<td><a href="">${  order.orderDate}</a></td>
	
		<td>
		<a href="${appName}order/detail?customerId=${order.orderid}">Edit</a>
		<a href="${appName}order/detail?customerId=${order.orderid}">Delete</a>
		</td>
	</tr>
	</c:forEach>
</table>
