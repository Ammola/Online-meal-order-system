<jsp:include page="../shared/_layout.jsp" />

<form action="${appName}user/registration" method="post">
	<div class="container register-form">
		<div class="form">
			<!-- <div class="note">
				<p>This is a simpleRegister Form made using Boostrap.</p>
			</div> -->

			<div class="form-content">
				<div class="row">
					<div class="col-md-6">
						<div class="form-group">
							<input name="firstName" type="text" class="form-control"
								placeholder="First Name *" value="" />
						</div>
						<div class="form-group">
							<input name="emailAddress" type="email" class="form-control"
								placeholder="Email *" value="" />
						</div>
						<div class="form-group">
							<input name="password" type="password" class="form-control"
								placeholder="Your Password *" value="" id="password" />
						</div>
					</div>

					<div class="col-md-6">
						<div class="form-group">
							<input name="lastName" type="text" class="form-control"
								placeholder="Last Name *" value="" />
						</div>
						<div class="form-group">
							<input name="mobile" type="text" class="form-control"
								placeholder="Mobile *" value="" />
						</div>

						<div class="form-group">
							<input name="confirmPassword" type="password"
								class="form-control" placeholder="Confirm Password *" value=""
								id="confirmPassword" />
						</div>
					</div>

					<div class="col-md-4">
						<div class="form-group">
							<input name="buildingNumber" type="text" class="form-control"
								placeholder="Building Number *">
						</div>
					</div>

					<div class="col-md-4">
						<div class="form-group">
							<input name="streetName" type="text" class="form-control"
								placeholder="Street Name *">
						</div>
					</div>

					<div class="col-md-4">
						<div class="form-group">
							<input name="district" type="text" class="form-control"
								placeholder="District *">
						</div>
					</div>

					<div class="col-md-4">
						<div class="form-group">
							<input name="city" type="text" class="form-control"
								placeholder="City *">
						</div>
					</div>

					<div class="col-md-4">
						<div class="form-group">
							<input name="postalCode" type="text" class="form-control"
								placeholder="Postal Code *">
						</div>
					</div>

					<div class="col-md-4">
						<div class="form-group">
							<input name="additionalNumber" type="text" class="form-control"
								placeholder="Additional Number *">
						</div>
					</div>
					<div class="col-md-4">
					<div class="form-group">
						 <select name="userRole"
							class="form-control">
							<option value="admin">Admin</option>
							<option value="user">User</option>
						</select>
					</div>
					</div>
				</div>
				<button type="submit" onclick="matchPassword()" class="btnSubmit">Sign Up</button>
			</div>
		</div>

	</div>
</form>

<script>
	function matchPassword() {
		var pw1 = document.getElementById("password").value;
		var pw2 = document.getElementById("confirmPassword").value;
		if (pw1 != pw2) {
			alert("Passwords did not match");
			alert(pw1);
		} else {
			alert("Password created successfully");
		}
	}
</script>
