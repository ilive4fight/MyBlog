<%--
  Created by IntelliJ IDEA.
  User: semen
  Date: 13.04.2016
  Time: 2:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <title>User Registration Form</title>
  <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
  <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>
<body>
<div class="success">
  Confirmation message : ${success}

  Go to <a href="<c:url value='/user' />">Your HomePage</a>
</div>

</body>
</html>