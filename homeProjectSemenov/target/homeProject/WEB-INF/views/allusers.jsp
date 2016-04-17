<%--
  Created by IntelliJ IDEA.
  User: semen
  Date: 14.04.2016
  Time: 1:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <title>User's List</title>

  <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"/>
  <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"/>

  <style>
    tr:first-child{
      font-weight: bold;
      background-color: #C6C9C4;
    }
  </style>

</head>


<body>
<h2>List of Users</h2>
<table class="table">
  <tr>
    <td>id</td><td>First Name</td><td>Last Name</td><td>Type</td><td></td><td></td>
  </tr>
  <c:forEach items="${users}" var="user">
    <tr>
      <td>${user.id}</td>
      <td>${user.ssoId}</td>
      <td>${user.password}</td>
      <td>${user.state}</td>
      <td><a href="<c:url value='/user/edit-user-${user.id}' />">edit</a></td>
      <td><a href="<c:url value='/user/delete-user-${user.id}' />">delete</a></td>
    </tr>
  </c:forEach>
</table>
<br/>
<a href="<c:url value='/security/logout' />">Logout</a>
</body>
</html>