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
		<td><a href="">${order.customerId}</a></td>
		<td><a href="">${order.Orderid}</a></td>
		<td><a href="">${order.Quantity}</a></td>
		<td><a href="">${order.Price}</a></td>
		<td><a href="">${order.OrderDate}</a></td>
		<td>
		<a href="">Edit</a>
		<a href="">Delete</a>
		</td>
	</tr>
	</c:forEach>
</table>