<jsp:include page="../shared/_layout.jsp" />

<form action="${appName}user/edit-profile" method="post">
	<div class="container register-form">
		<div class="form">
			<div class="form-content">
				<div class="row">
					<div class="col-md-6">
					
						<div class="form-group">
							<input name="firstName" type="text" class="form-control"
								placeholder="First Name *" value="${user.firstName}" />
						</div>
						
						<div class="form-group">
							<input name="emailAddress" type="email" class="form-control"
								placeholder="Email *" value="${user.emailAddress}" />
						</div>
						
					</div>

					<div class="col-md-6">
						<div class="form-group">
							<input name="lastName" type="text" class="form-control"
								placeholder="Last Name *" value="${user.lastName}" />
						</div>
						<div class="form-group">
							<input name="mobile" type="text" class="form-control"
								placeholder="Mobile *" value="${user.mobile}" />
						</div>
					</div>

					<div class="col-md-4">
						<div class="form-group">
							<input name="buildingNumber" type="text" class="form-control"
								placeholder="Building Number *" value="${user.firstName}">
						</div>
					</div>

					<div class="col-md-4">
						<div class="form-group">
							<input name="streetName" type="text" class="form-control"
								placeholder="Street Name *" value="${user.streetName}">
						</div>
					</div>

					<div class="col-md-4">
						<div class="form-group">
							<input name="district" type="text" class="form-control"
								placeholder="District *" value="${user.district}">
						</div>
					</div>

					<div class="col-md-4">
						<div class="form-group">
							<input name="city" type="text" class="form-control"
								placeholder="City *" value="${user.city}">
						</div>
					</div>

					<div class="col-md-4">
						<div class="form-group">
							<input name="postalCode" type="text" class="form-control"
								placeholder="Postal Code *" value="${user.postalCode}">
						</div>
					</div>

					<div class="col-md-4">
						<div class="form-group">
							<input name="additionalNumber" type="text" class="form-control"
								placeholder="Additional Number *" value="${user.additionalNumber}">
						</div>
					</div>
				</div>
				<button type="submit" class="btn btn-warning">Save</button>
			</div>
		</div>

	</div>
	<input name="id" type="hidden" value="${user.id}">
	<input name="userRole" type="hidden" value="${user.userRole}">
	<input name="password" type="hidden" value="${user.password}">
</form>
