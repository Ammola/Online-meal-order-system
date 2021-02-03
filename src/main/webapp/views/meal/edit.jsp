<jsp:include page="../shared/_layout.jsp" />
<form action="${appName}meal/add" method="post">
	<div class="form-group">
		<label>Meal's Name </label> <input type="text" name="mealName" value="${meal.mealName}" class="form-control">
	</div>
	<div class="form-group">
		<label>Price </label> <input type="text" name="mealPrice"  value="${meal.mealPrice}" class="form-control">
	</div>
	<div class="form-group">
		<label>Calories </label> <input type="text" name="calories" value="${meal.calories}"  class="form-control">
	</div>
	<div class="form-group">
		<label>Description </label> <input type="text" name="description" value="${meal.description}" class="form-control">
	</div>
	<div class="form-group">
		<label>Description </label> <input type="text" name="description" value="${meal.description}" class="form-control">
	</div>
	<div class="form-group">
		<label>Image </label> <input type="text" name="mealImg" value="${meal.mealImg} class="form-control">
	</div>
	     <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		<input name="mealId" type="hidden" value="${meal.mealId}">
	<button type="submit">Submit</button>
</form>