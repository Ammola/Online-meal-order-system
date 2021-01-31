  <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../shared/_layout.jsp" />
<table>
	<tr>
		<th>customerId</th>
		<th>Order ID </th>
		<th> Quantity </th>
		<th> Price </th>
		<th> Article </th>
		<th> Action </th>
	</tr>
	  
	  <!-- loop in orders -->
	<c:forEach items="${orders}" var="order">
	<tr>
		 <!-- In saad code Id was hidden not in a Table I mean -->
		<td><a href="${appName}order/detail?customerId=${order.CustomerName}">
		${order.customerId}</a></td>
		
		<td><a href="">${order.CustomerPhone}</a></td>
		<td><a href="">${order.Orderid}</a></td>
		<td><a href="">${order.Quantity}</a></td>
		<td><a href="">${order.Price}</a></td>
		<td><a href="">${order.OrderDate}</a></td>
	
		<td>
		<a href="${appName}order/detail?customerId=${order.Orderid}">Edit</a>
		<a href="${appName}order/detail?customerId=${order.Orderid}">Delete</a>
		</td>
	</tr>
	</c:forEach>
</table>