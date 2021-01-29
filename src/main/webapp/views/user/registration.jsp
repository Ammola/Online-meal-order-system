<jsp:include page="../shared/_layout.jsp" />

<form action="${appName}user/registration" method="post">

	<div class="form-group">
		<label> First Name </label> <input name="firstName" type="text"
			class="form-control">
	</div>

	<div class="form-group">
		<label> Last Name </label> <input name="lastName" type="text"
			class="form-control">
	</div>

	<div class="form-group">
		<label> Email Address </label> <input name="emailAddress" type="email"
			class="form-control">
	</div>

	<div class="form-group">
		<label> Password </label> <input name="password" type="password"
			class="form-control">
	</div>

	<div class="form-group">
		<label> Address </label>  
			
			<input type="street" class="form-control" id="autocomplete" placeholder="Street">
			
		    <input type="city" class="form-control" id="inputCity" placeholder="City"> 
			
			<input type="state" class="form-control" id="inputState" placeholder="State"> 
			
			<input type="zip" class="form-control" id="inputZip" placeholder="Zip"> 
			
			<input type="county" class="form-control" id="inputCounty" placeholder="County"> 
			
			<input type="country" class="form-control" id="inputCountry" placeholder="Country">
	</div>

	<div class="form-group">
		<label>Select Role</label> <select name="userRole"
			class="form-control">
			<option value="admin">Admin</option>
			<option value="user">User</option>
		</select>
	</div>

	<br>

	<button type="submit" class="btn btn-primary">Submit</button>

</form>