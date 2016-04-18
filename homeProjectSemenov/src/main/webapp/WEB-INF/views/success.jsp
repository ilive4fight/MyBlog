<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

	<link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"/>
	<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"/>
<title>Registration Confirmation Page</title>
</head>
<body>
	message : ${success}
	<br/>
	<br/>
	Go back to <a href="<c:url value='/admin' />">AdminPage</a>
	<a href="<c:url value='/logout' />">Logout</a>
	
</body>

</html>