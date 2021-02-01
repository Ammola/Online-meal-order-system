<jsp:include page="../shared/_layout.jsp" />
<form action="${appName}user/edit-profile" method="post">
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
								placeholder="New Password *" required />
						</div>

						<div class="form-group">
							<input name="password" type="password" class="form-control"
								placeholder="Confirm Password *" required />
						</div>

					</div>
				</div>
				<button type="submit" class="btnSubmit">Save</button>
			</div>
		</div>
	</div>

	<input name="id" type="hidden" value="${user.id}"> 
	<input name="userRole" type="hidden" value="${user.firstName}">
	<input name="userRole" type="hidden" value="${user.lastName}">
	<input name="userRole" type="hidden" value="${user.emailAddress}">
	<input name="userRole" type="hidden" value="${user.mobile}">
	<input name="userRole" type="hidden" value="${user.buildingNumber}">
	<input name="userRole" type="hidden" value="${user.streetName}">
	<input name="userRole" type="hidden" value="${user.district}">
	<input name="userRole" type="hidden" value="${user.city}">
	<input name="userRole" type="hidden" value="${user.postalCode}">
	<input name="userRole" type="hidden" value="${user.additionalNumber}">          
	<input name="userRole" type="hidden" value="${user.userRole}">
</form>