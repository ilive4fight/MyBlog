<%--
  Created by IntelliJ IDEA.
  User: semen
  Date: 12.04.2016
  Time: 20:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html;charset=UTF-8; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"/>
<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"/>

<html>
<head>
    <meta http-equiv="CONTENT-TYPE" content="text/html;charset=ISO-8859-1">
    <title>WelcomePage</title>
    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
</head>
<body>
<div class="container">

    <a href="security/login"/>Login</a>
    <br>


    <h1>Greeting: ${greeting}
        This is a welcome page</h1>
</div>

</body>
<div>
    <h2>List of All Articles</h2>
    <table class="table table-bordered">
        <tr>
            <td>id</td>
            <td>Title</td>
            <td>Text</td>
            <td></td>
            <td></td>
        </tr>
        <c:forEach items="${articles}" var="article">
            <tr>
                <td>${article.id}</td>
                <td>${article.title}</td>
                <td>${article.text}</td>
            </tr>
        </c:forEach>
    </table>
</div>
<br/>



</body>
</html>

<%--<a></a>--%>


<%--<h2>List of Users</h2>--%>
<%--<table>--%>
<%--<tr>--%>
<%--<td>id</td>--%>
<%--<td>Name</td>--%>
<%--<td>Password</td>--%>
<%--<td>Type</td>--%>
<%--<td>DeleteUser</td>--%>
<%--<td></td>--%>
<%--</tr>--%>
<%--<c:forEach items="${users}" var="user">--%>
<%--<tr>--%>
<%--<td>${user.id}</td>--%>
<%--<td>${user.ssoId}</td>--%>
<%--<td>${user.password}</td>--%>
<%--<td>${user.state}</td>--%>
<%--&lt;%&ndash;<c:set var="asd" value="${user.id}" />&ndash;%&gt;--%>
<%--<td>--%>
<%--<button type="button" onclick=" DeleteUser(${user.id});">DELETE</button>--%>
<%--</td>--%>
<%--&lt;%&ndash;<td><a href="<c:url value='/user/delete-user-${user.id}' />">delete</a></td>&ndash;%&gt;--%>

<%--</tr>--%>

<%--</c:forEach>--%>
<%--<script>--%>
<%--var DeleteUser = function (a) {--%>
<%--$.ajax({--%>
<%--url: "http://localhost:8080/homeProject/user/delete-user-"+a,--%>
<%--type: 'GET',--%>
<%--dataType: "json",--%>
<%--success: function (result) {--%>
<%--alert("has been deleted");--%>
<%--}--%>
<%--});--%>
<%--}</script>--%>
<%--<script>--%>


<%--</script>--%>
<%--</table>--%>

<%--<button type="button" onclick="AllUsers()">GET</button>--%>

<%--<button type="button" onclick="AllUsers1()">GET</button>--%>


<%--<button id="fetchContacts" type="submit">GET</button>--%>


<%--<table class="data-contacts-js table table-striped">--%>
<%--<tr>--%>
<%--<th>id</th>--%>
<%--<th>ssoId</th>--%>
<%--<th>password</th>--%>
<%--<th>state</th>--%>
<%--</tr>--%>
<%--</table>--%>

<%--<script type="text/javascript">--%>
<%--$("#fetchContacts").bind("click", function () {--%>

<%--$.get("http://localhost:8080/homeProject/user/allUsers1", function (data) {--%>

<%--$.each(data, function (i, contact) {--%>

<%--$(".data-contacts-js").append(--%>
<%--"<tr><td>" + contact.id + "</td>" +--%>
<%--"<td>" + contact.ssoId + "</td>" +--%>
<%--"<td>" + contact.password + "</td>" +--%>
<%--"<td>" + contact.state + "</td>" +--%>
<%--"<td>" + "<button type='button' onclick='DeleteUser( +contact.state +);'>DELETE</button>'"+"</td></tr>");--%>
<%--});--%>

<%--});--%>
<%--});--%>
<%--</script>--%>


<%--<script>--%>
<%--var AllUsers1 = function () {--%>
<%--$.ajax({--%>
<%--type: 'GET',--%>
<%--url: "http://localhost:8080/homeProject/user/allUsers1",--%>
<%--dataType: 'json',--%>
<%--async: true,--%>
<%--success: function (result) {--%>
<%--alert(result);--%>
<%--},--%>
<%--error: function (jqXHR, textStatus, errorThrown) {--%>
<%--alert(jqXHR.status + ' ' + jqXHR.responseText);--%>
<%--}--%>
<%--});--%>
<%--}--%>


<%--</script>--%>

<%--<script>--%>
<%--var AllUsers = function () {--%>
<%--$.ajax({--%>
<%--type: 'GET',--%>
<%--url: "http://localhost:8080/homeProject/user/allUsers",--%>
<%--dataType: 'json',--%>
<%--async: true,--%>
<%--success: function (result) {--%>
<%--alert(result.message);--%>
<%--},--%>
<%--error: function (jqXHR, textStatus, errorThrown) {--%>
<%--alert(jqXHR.status + ' ' + jqXHR.responseText);--%>
<%--}--%>
<%--});--%>
<%--}--%>


<%--</script>--%>


<%--<script>$.getJSON('ajax/test.json', function(data){--%>
<%--var items = [];--%>

<%--$.each(data, function(key, val){--%>
<%--items.push('<li id="' + key + '">' + val + '</li>');--%>
<%--});--%>

<%--$('<ul/>', {--%>
<%--'class': 'my-new-list',--%>
<%--html: items.join('')--%>
<%--}).appendTo('body');--%>


