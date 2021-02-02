<jsp:include page="../shared/_layout.jsp" />

<table>
	<tr>
		<td>Order Id</td>
		<td>Customer's Name</td>
		<th>Total</th>
		<th>Order Date</th>
	</tr>

	<tr>
		<td>${order.orderId}</td>
		<td>${order.customerName}</td>
		<td>${order.total}</td>
		<td>${order.createAt}</td>
	</tr>

</table>