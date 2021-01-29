<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Restaurant APP</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
<link rel="stylesheet" href="../css/myStyles.css">
<link rel="stylesheet" href="css/myStyles.css">
</head>
<body>
<h2>${Welcome}</h2>
<% if(session.getAttribute("user") != null){%>

<a href="${appName}">Home</a> |
<a href="${appName}meal/index">Meals</a> |
<% if(session.getAttribute("userRole").equals("admin")) { %>
<a href="${appName}meal/add">Add Meal</a> |
<% } %>
<a href="${appName}order/add">Add Order</a> |
<a href="${appName}order/index">Orders</a> 

<div style="text-align:right; float:right;">
<b>Hi: ${user.getFirstName()} ${user.getLastName()}</b>
<a href="${appName}user/cart">Cart</a> |
<a href="${appName}user/logout">Logout</a> |
<a href="${appName}user/profile">Profile</a>
</div>

<%} else {%>

<a href="${appName}">Home</a> |
<a href="${appName}meal/index">Meals</a>

<div style="text-align:right; float:right;">
<a href="${appName}user/login">Login</a> |
<a href="${appName}user/registration">Create New Account</a>
</div>

<% } %>

</body>
</html>