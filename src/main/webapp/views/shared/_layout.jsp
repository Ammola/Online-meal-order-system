  
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Restaurant APP</title>
<link rel="stylesheet"
href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
crossorigin="anonymous">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="../css/myStyles.css">
<link rel="stylesheet" href="css/myStyles.css">
</head>
<body>
<!-- <p id="demo"></p>-->
 <%
if (session.getAttribute("user") != null) {
%>
<div style="text-align: right; float: right;">
<b>Hi: ${user.getFirstName()} ${user.getLastName()}</b> 
</div>
<% } %>
<h5>${Welcome}</h5>
<!-- <script> document.getElementById("demo").innerHTML = 5 + 6; </script>-->
	<%
	if (session.getAttribute("user") != null) {
	%>
     <div>
	<a href="${appName}">Home</a> |
	<a href="${appName}meal/index">Menu</a> |
	<%
	if (session.getAttribute("userRole").equals("admin")) {
	%>
	<a href="${appName}meal/add">Add Meal</a>
	<%
	}
	%>
	
	<div style="text-align: right; float: right;">
	    <a href="${appName}order/get-index">Orders</a> |
		<a href="${appName}cart/get-index">Cart</a> | 
		<a href="${appName}user/profile">Profile</a> | 
		<a href="${appName}user/logout">Logout</a>
	</div>


	<%
	} else {
	%>
<div class = "home-nav">
	<a href="${appName}">Home</a> |
	<a href="${appName}meal/index">Meals</a>
     
      </div>
</div>


	<div class=right-nav>
		<a href="${appName}user/login">Login<i class="fa fa-sign-in"></i></a> | <a
			href="${appName}user/registration">Sign up</a>
	</div>
	
	
	<%
	}
	%>


	<c:if test="${message != null}">
		<div class="alert alert-success fade show" role="alert">
			${message}</div>
		<%
		session.removeAttribute("message");
		%>
	</c:if>
	<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
	<script type="text/javascript">
		$('.fade').slideUp(4000);
	</script>
	
	<c:if test="${alarm != null}">
		<div class="alert alert-danger fade show" role="alert">
			${alarm}</div>
		<%
		session.removeAttribute("alarm");
		%>
	</c:if>
	<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
	<script type="text/javascript">
		$('.fade').slideUp(4000);
	</script>
	
</body>
</html>
