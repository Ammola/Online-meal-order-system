<jsp:include page="../shared/_layout.jsp"></jsp:include>

<%
if (session.getAttribute("user") != null) {
%>


<div class="card">
<h2 class="card-header">My Profile</h2>
<img class="card-img-top" src="https://cdn.pixabay.com/photo/2017/12/28/15/06/background-3045402_1280.png" alt="profile banner">
  <div class="card-body">
  <h4 class="card-title">Hi ${user.firstName} ${user.lastName}</h4>
    <h6 class="card-subtitle mb-2 text-muted">This is your personal profile</h6>
    <p class="card-text"><b>First Name: </b>${user.firstName}</p>
    <p class="card-text"><b>Last Name: </b>${user.lastName}</p>
    <p class="card-text"><b>Email Address: </b>${user.emailAddress}</p>
    <p class="card-text"><b>Mobile: </b>${user.mobile}</p>
    <h4 class="card-title">Address Information</h4>
    <p class="card-text"><b>Building Number: </b>${user.buildingNumber}</p>
    <p class="card-text"><b>Street Name: </b>${user.streetName}</p>
    <p class="card-text"><b>District: </b>${user.district}</p>
    <p class="card-text"><b>City: </b>${user.city}</p>
    <p class="card-text"><b>Postal Code: </b>${user.postalCode}</p>
    <p class="card-text"><b>Additional Number: </b>${user.additionalNumber}</p>
    <form action="${appName}user/edit-profile" method="get" style="display: inline-block;">
			<button type="submit" class="btn btn-warning">Edit Profile</button>
		</form>
	
		<form action="${appName}user/edit-password" method="get" style="display: inline-block;">
			<button type="submit" class="btn btn-warning">Change Password</button>
		</form>
  </div>
</div>

<%
}
%>