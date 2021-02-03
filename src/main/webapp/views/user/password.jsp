<jsp:include page="../shared/_layout.jsp" />
<form action="${appName}user/edit-password" method="post">
	<div class="container register-form">
		<div class="form">
			<!-- <div class="note">
				<p>This is a simpleRegister Form made using Boostrap.</p>
			</div> -->

			<div class="form-content">
				<div class="row">
					<div class="col-md-6">

						<div class="form-group">
							<input name="password" type="password" class="form-control"
								placeholder="New Password *" value="" id="password"
								onkeyup="matchPassword();" required />
						</div>

						<div class="form-group">
							<input name="confirmPassword" type="password" class="form-control"
								placeholder="Confirm Password *" value="" id="confirmPassword"
								onkeyup="matchPassword();" required /> <span id='message'></span>
						</div>

					</div>
				</div>
				<button type="submit" onclick="matchPassword()" class="btn btn-warning" id="submit">Save
					Password</button>
			</div>
		</div>
	</div>

	<input name="id" type="hidden" value="${user.id}"> <input
		name="firstName" type="hidden" value="${user.firstName}"> <input
		name="lastName" type="hidden" value="${user.lastName}"> <input
		name="emailAddress" type="hidden" value="${user.emailAddress}">
	<input name="mobile" type="hidden" value="${user.mobile}"> <input
		name="buildingNumber" type="hidden" value="${user.buildingNumber}">
	<input name="streetName" type="hidden" value="${user.streetName}">
	<input name="district" type="hidden" value="${user.district}">
	<input name="city" type="hidden" value="${user.city}"> <input
		name="postalCode" type="hidden" value="${user.postalCode}"> <input
		name="additionalNumber" type="hidden" value="${user.additionalNumber}">
	<input name="userRole" type="hidden" value="${user.userRole}">
</form>

<script>
	function matchPassword() {
		var pw1 = document.getElementById("password").value;
		var pw2 = document.getElementById("confirmPassword").value;
		if (pw1 == pw2) {
			document.getElementById('submit').disabled = false;
			document.getElementById('message').style.color = 'green';
			document.getElementById('message').innerHTML = 'matching';
		} else {
			document.getElementById('submit').disabled = true;
			document.getElementById('message').style.color = 'red';
			document.getElementById('message').innerHTML = 'not matching';
		}
	}
</script>