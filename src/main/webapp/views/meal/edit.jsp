<jsp:include page="../shared/_layout.jsp" />

<form action="${appName}meal/add" method="post">

	<div class="form-group">
		<label>Meal's Name </label> <input type="text" name="name" value="${meal.name}" class="form-control">
	</div>

	<div class="form-group">
		<label>Price </label> <input type="text" name="price"  value="${meal.price}" class="form-control">
	</div>

	<input name="id" type="hidden" value="${meal.id}">
	
	<button type="submit">Submit</button>

</form>