<jsp:include page="../shared/_layout.jsp" />


<form action="/blogapp/author/add" method="post">
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
	<div>
		<label>customerId</label> <input type="text" name="customerId">
	</div>
	
	<button type="submit">Submit your Order</button>
	
</form>