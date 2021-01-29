
<!--<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1256">
<title>Insert title here</title>
</head>
<body>

</body>
</html>
-->
<form action="${appName}meal/add" method="post">

	<div class="form-group">
		<label>Meal's Name </label> <input type="text" name="MealName" class="form-control">
	</div>

	<div class="form-group">
		<label>Price  </label> <input type="text" name="MealPrice" class="form-control">
	</div>

	<div class="form-group">
		<label>Calories </label> <input type="text" name="Calories"  class="form-control">
	</div>

	<div class="form-group">
		<label>Description </label> <input type="text" name="Description"  class="form-control">
	</div>

	<div class="form-group">
		<label>Photo </label> <input type="text" name="Photo"  class="form-control">
	</div>
<!-- 	<div>
		<label>Article </label> <input type="text" name="article">
	</div> -->

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />

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