<jsp:include page="../shared/_layout.jsp" />
<form action="${appName}order/add" method="post">
	<div>
		<label>Customer's Name</label> <input type="text" name="CustomerName" value="${order.CustomerName }">
	</div>
	<div>
		<label>customerId</label> <input type="text" name="customerId" value="${order.customerId }">
	</div>
	<div>
		<label>CustomerPhone</label> <input type="text" name="CustomerPhone" value="${order.CustomerPhone }">
	</div>
	<div>
		<label>Order ID </label> <input type="text" name="Orderid" value="${order.Orderid }">
	</div>
	<div>
		<label>Quantity </label> <input type="text" name="Quantity" value="${order.Quantity }">
	</div>
	<div>
		<label>Price </label> <input type="text" name="Price" value="${order.Price }">
	</div>
	<div>
		<label>OrderDate</label> <input type="date" name="OrderDate" value="${order.OrderDate }">
	</div>

 <!--  may name will be - name = id -->
	<input name="customerId" type="hidden" value="${order.customerId}">
	
	<button type="submit">Submit</button>
	
</form>
	