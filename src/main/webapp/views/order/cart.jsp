<jsp:include page="../shared/_layout.jsp" />


<form action="/restaurant/order/add" method="post">
	<div>
		<label>Customer's Name</label> <input type="text" name="customerName">
	</div>
	<div>
		<label>customerId</label> <input type="text" name="customerId">
	</div>
	<div>
		<label>CustomerPhone</label> <input type="text" name="customerPhone">
	</div>
	<div>
		<label>Order ID </label> <input type="text" name="orderid">
	</div>
	<div>
		<label>Quantity </label> <input type="text" name="quantity">
	</div>
	<div>
		<label>Price </label> <input type="text" name="price">
	</div>
	<div>
		<label>OrderDate</label> <input type="date" name="orderDate">
	</div>
	
	
	<button type="submit">checkout</button>
	
</form>