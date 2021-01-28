<jsp:include page="../shared/_layout.jsp" />

<b>${message}</b>
<br>

<form action="${appName}login" method="post">

	<div class="form-group">
	<label> Email Address </label>
	<input name="username" type="email" class="form-control">
	</div>
	
	<div class="form-group">
	<label> Password </label>
	<input name="password" type="password" class="form-control">
	</div>
	
	<br>
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
	<button type="submit" class="btn btn-primary">Submit</button>

</form>