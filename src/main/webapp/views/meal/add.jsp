<jsp:include page="../shared/_layout.jsp" />
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
		<label>Meal's Name </label> <input type="text" name="mealName" class="form-control">
	</div>

	<div class="form-group">
		<label>Price  </label> <input type="text" name="mealPrice" class="form-control">
	</div>

	<div class="form-group">
		<label>Calories </label> <input type="text" name="calories"  class="form-control">
	</div>

	<div class="form-group">
		<label>Description </label> <input type="text" name="description"  class="form-control">
	</div>

	<div class="form-group">
		<label>Photo </label> <input type="text" name="photo"  class="form-control">
	</div>
<!-- 	<div>
		<label>Article </label> <input type="text" name="article">
	</div> -->

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />

</form>