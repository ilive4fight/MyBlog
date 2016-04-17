<%--
  Created by IntelliJ IDEA.
  User: semen
  Date: 14.04.2016
  Time: 4:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>New Article</title>
  <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
  <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>
<body>
<div class="form-container">

  <h1>New Article Registration Form</h1>

  <form:form method="POST" modelAttribute="article" class="form-horizontal">





  <div class="container">
    <div class="form-group">
      <label for="title">Title:</label>
      <form:input type="text" path="title" id="title" class="form-control input-sm" />
    </div>

      <div class="form-group">
        <label for="text">Text:</label>
        <form:textarea role="form" type="text" rows="5" path="text" id="text" class="form-control input-sm"/>
      </div>
  </div>


  <div class="row">
    <div class="form-actions floatRight">
      <input type="submit" value="Create" class="btn btn-primary btn-sm"> or <a href="<c:url value='/user' />">UserHomePage</a>
    </div>
  </div>

  </form:form>

</body>
</html>
