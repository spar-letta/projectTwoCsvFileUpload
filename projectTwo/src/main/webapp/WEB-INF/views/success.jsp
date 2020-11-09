<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>uploaded successful</title>
</head>
<spring:theme code="styleSheet" var="app_css" />
<spring:url value="/${app_css}" var="app_css_url" />
<link rel="stylesheet" type="text/css" media="screen" href="${app_css_url}" />
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<body class="katikati">
<div id="succ">
	<p>Success !!!</p><br/>

<p><a href="${contextPath}/listAll">Click to view List</a></p>
</div>
</body>
</html>