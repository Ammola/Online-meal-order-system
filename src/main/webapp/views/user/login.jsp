<jsp:include page="../shared/_layout.jsp" />

<form action="${appName}user/login" method="post">

	<div class="container register-form">
		<div class="form">
		<div class="form-content">

			<div class="row">
				<div class="col-md-12">
					<div class="form-group">
						<label class="inline-label"> Email Address </label> <input name="emailAddress"
							type="email" class="form-control">
					</div>
				</div>
			</div>

			<div class="row">
				<div class="col-md-12">
					<div class="form-group">
						<label > Password </label> <input name="password" type="password"
							class="form-control">
					</div>
				</div>
			</div>

			<br>
			<button type="submit" class="btnSubmit">Log In</button>
		</div>
	</div>
	</div>
</form>