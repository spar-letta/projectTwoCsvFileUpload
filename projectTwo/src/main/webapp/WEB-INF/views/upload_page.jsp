<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>upload_page</title>
</head>
<spring:theme code="styleSheet" var="app_css" />
<spring:url value="/${app_css}" var="app_css_url" />
<link rel="stylesheet" type="text/css" media="screen" href="${app_css_url}" />
<body class="katikati">
	<div >
	<p>Hi welcome  Tulaa CSV upload</p>
	<spring:url value="/doUpload" var="doUploadURL"/>
	<form:form method="post" modelAttribute="formUpload" action="${doUploadURL}" enctype="multipart/form-data">		
		<form:input path="files" type="file" multiple="multiple"/>
		<form:errors path="files"/><br/>
		<button type="submit">upload</button>
	</form:form>
	</div>
</body>
</html>