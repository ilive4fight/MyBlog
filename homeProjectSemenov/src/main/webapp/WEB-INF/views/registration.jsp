<%--
  Created by IntelliJ IDEA.
  User: semen
  Date: 13.04.2016
  Time: 2:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <title>User Registration Form</title>
  <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
  <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>

<body>

<div class="form-container">

  <h1>New User Registration Form</h1>

  <form:form method="POST" modelAttribute="user" class="form-horizontal">



    <div class="row">
      <div class="form-group col-md-12">
        <label class="col-md-3 control-lable" for="ssoId">SSO ID</label>
        <div class="col-md-7">
          <form:input type="text" path="ssoId" id="ssoId" class="form-control input-sm"/>
          <div class="has-error">
            <form:errors path="ssoId" class="help-inline"/>
          </div>
        </div>
      </div>
    </div>

    <div class="row">
      <div class="form-group col-md-12">
        <label class="col-md-3 control-lable" for="password">Password</label>
        <div class="col-md-7">
          <form:input type="password" path="password" id="password" class="form-control input-sm"/>
          <div class="has-error">
            <form:errors path="password" class="help-inline"/>
          </div>
        </div>
      </div>
    </div>


    <div class="row">
      <div class="form-actions floatRight">
        <input type="submit" value="Register" class="btn btn-primary btn-sm">
      </div>
    </div>
  </form:form>
</div>
</body>
</html>