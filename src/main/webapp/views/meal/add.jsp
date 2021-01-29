<jsp:include page="../shared/_layout.jsp" />

<form action="${appName}meal/add" method="post">

	<div class="form-group">
		<label>Meal's Name </label> <input type="text" name="name" class="form-control">
	</div>

	<div class="form-group">
		<label>Price </label> <input type="text" name="price" class="form-control">
	</div>
	<button type="submit" class="btn btn-primary">Submit</button>

</form>