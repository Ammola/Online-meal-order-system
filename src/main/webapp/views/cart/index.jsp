
     <jsp:include page="../shared/_layout.jsp" />
   <form action="${appName}cart/index" method="post">

	<div>

		<label>MealID</label> <input type="text" name="mealId">

	</div>
	<div>
		<label>mealName</label> <input type="text" name="customerId">
	</div>
	<div>

		<label>mealPrice</label> <input type="text" name="mealPrice">
	</div>
	<div>
		<label>mealImg</label> <input type="text" name="mealImg">
	</div>
	<div>
		<label>Quantity </label> <input type="text" name="quantity">
	</div>
	
	<div>
		<label>OrderDate</label> <input type="date" name="orderDate">
	</div>
	
	<button type="submit">checkout</button>
	</form>