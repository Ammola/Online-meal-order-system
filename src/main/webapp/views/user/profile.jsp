<jsp:include page="../shared/_layout.jsp"></jsp:include>

<%
if (session.getAttribute("user") != null) {
%>
<div class="form-content">
	<table class="table table-striped">
		<tr>
			<th>First Name</th>
			<td>${user.firstName}</td>

		</tr>
		<tr>
			<th>Last Name</th>

			<td>${user.lastName}</td>

		</tr>
		<tr>
			<th>Email</th>
			<td>${user.emailAddress}</td>
		</tr>
		<tr>
			<th>Mobile</th>
			<td>${user.mobile}</td>
		</tr>
		<tr>
			<th>Building Number</th>
			<td>${user.buildingNumber}</td>
		</tr>
		<tr>
			<th>Street Name</th>
			<td>${user.streetName}</td>
		</tr>
		<tr>
			<th>District</th>
			<td>${user.district}</td>
		</tr>
		<tr>
			<th>City</th>
			<td>${user.city}</td>
		</tr>
		<tr>
			<th>Postal Code</th>
			<td>${user.postalCode}</td>
		</tr>
		<tr>
			<th>Additional Number</th>
			<td>${user.additionalNumber}</td>
		</tr>

	</table>

		<form action="${appName}user/edit-profile" method="get" style="display: inline-block;">
			<button type="submit" class="btn btn-info btn-rounded">Edit Profile</button>
		</form>
	
		<form action="${appName}user/edit-password" method="get" style="display: inline-block;">
			<button type="submit" class="btn btn-info btn-rounded">Change Password</button>
		</form>

</div>

<%
}
%>