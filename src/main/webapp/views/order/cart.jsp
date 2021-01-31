<jsp:include page="../shared/_layout.jsp" />


<form action="/restaurant/order/add" method="post">
	<div>
		<label>Customer Name's</label> <input type="text" name="CustomerName">
	</div>
	<div>
		<label>customerId</label> <input type="text" name="customerId">
	</div>
	<div>
		<label>CustomerPhone</label> <input type="text" name="CustomerPhone">
	</div>
	<div>
		<label>Order ID </label> <input type="text" name="Orderid">
	</div>
	<div>
		<label>Quantity </label> <input type="text" name="Quantity">
	</div>
	<div>
		<label>Price </label> <input type="text" name="Price">
	</div>
	<div>
		<label>OrderDate</label> <input type="date" name="OrderDate">
	</div>
	
	
	<button type="submit">checkout</button>
	
</form>