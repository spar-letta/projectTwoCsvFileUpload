<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List</title>
</head>
<spring:theme code="styleSheet" var="app_css" />
<spring:url value="/${app_css}" var="app_css_url" />
<link rel="stylesheet" type="text/css" media="screen" href="${app_css_url}" />
<body class="katikati">
<h1>Hello Customer</h1>
	<table border="1">
		<thead>YOUR DETAILS</thead>
			<tr>
				<td>First Name</td>
				<td>Last Name</td>
				<td>DOB</td>
				<td>Postal-Address</td>
				<td>National-Id</td>
				<td>Gender</td>
			</tr>
			<c:forEach items="${user}" var="list_list">
			<tr>
				<td>${list_list.first_name}</td>
				<td>${list_list.last_name}</td>
				<td>${list_list.dob}</td>
				<td>${list_list.postal_address}</td>
				<td>${list_list.national_id}</td>
				<td>${list_list.gender}</td>
			<tr>	
			</c:forEach>
	</table>
</body>
</html>