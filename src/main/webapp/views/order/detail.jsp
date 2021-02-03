<jsp:include page="../shared/_layout.jsp" />

<table class="table table-striped">
	<tr>
		<th>Order Id</th>
		<th>Customer's Name</th>
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

