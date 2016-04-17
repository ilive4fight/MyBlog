<%--
  Created by IntelliJ IDEA.
  User: semen
  Date: 16.04.2016
  Time: 22:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <title>User Edit Form</title>
  <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"/>
  <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"/>
</head>

<body>

<h2>User Edit Form</h2>

<form:form method="POST" modelAttribute="user">

  <table class="table">
       <tr>
      <td><label for="ssoId">ssoId: </label> </td>
      <td><form:input path="ssoId" id="ssoId"/></td>
    </tr>
    <tr>
      <td><label for="password">Password: </label> </td>
      <td><form:input path="password" id="password"/></td>
    </tr>
    <tr>
      <td><label for="userProfiles">UserProfiles: </label> </td>
      <form:select path="userProfiles" items="${roles}" multiple="true" itemValue="id" itemLabel="type" class="form-control input-sm"/>
      <form:errors path="userProfiles" class="help-inline"/>
    </tr>
    <tr>
      <td colspan="3">
            <input type="submit" value="Update"/>
      </td>
    </tr>
  </table>
</form:form>
<br/>
<br/>
Go back to <a href="<c:url value='/list' />">List of All Users</a>
<a href="<c:url value='/logout' />">Logout</a>
</body>
</html>