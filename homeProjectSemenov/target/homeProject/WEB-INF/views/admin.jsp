<%--
  Created by IntelliJ IDEA.
  User: semen
  Date: 12.04.2016
  Time: 20:44
  To change this template use File | Settings | File Templates.
--%>

<%@ page language="java" contentType="text/html;charset=UTF-8; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>AdminPage</title>

    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
    <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"/>
    <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"/>

</head>
<body>


Helo ${user}, welcome to admin page
<br/>


<a href="<c:url value='/user/newUser' />">Add New User</a>

<br/>

<a href="<c:url value="/security/logout" />">Logout</a>


<br/>

<a href="<c:url value="/user" />">YourUserPage</a>


<h2>List of Users with JSTL</h2>


<table class="table">
    <tr>
        <td>id</td>
        <td>Name</td>
        <td>Password</td>
        <td>Type</td>
        <td>Edit</td>
        <td>Delete</td>
        <td></td>
    </tr>

    <c:forEach items="${users}" var="user">
        <tr>
            <td>${user.id}</td>
            <td>${user.ssoId}</td>
            <td>${user.password}</td>
            <td>${user.state}</td>
            <td><a class="btn btn-primary" href="<c:url value='/user/edit-user-${user.id}' />">Edit</a></td>
            <td><a class="btn btn-danger" href="<c:url value='/user/delete-user-${user.id}' />">Delete</a></td>

        </tr>

    </c:forEach>

</table>


<table class="data-contacts-js table table-striped">
    <h2>List of Users with jQuery</h2>

    <tr>
        <th>ssoId</th>
        <th>password</th>
        <th>state</th>
        <th>edit</th>
        <th>delete</th>
    </tr>
</table>
<button id='fetchContacts' onClick="this.disabled='true'" class="btn btn-default" type="submit">GetTableWithAjax
</button>

</body>
</html>
<script type="text/javascript">


    $("#fetchContacts").bind("click", function () {

        $.get("http://localhost:8080/homeProject/user/allUsersRest", function (data) {

            $.each(data, function (i, contact) {

                $(".data-contacts-js").append(
                        "<tr><td>" + contact.ssoId + "</td>" +
                        "<td>" + contact.password + "</td>" +
                        "<td>" + contact.state + "</td>" +
                        "<td>" + parseInt(contact.id) + "</td>" +
                        "<td>" + "<button type='button' id='asd' onclick=' DeleteUser(" + parseInt(contact.id) + ");'>DELETE</button> " + "</td></tr>");
            });
        })
    });


    var DeleteUser = function (a) {
        $.ajax({
            url: "http://localhost:8080/homeProject/user/rest/delete-user-" + a,
            type: 'GET',
            alert:("DELETE")
        })
    }
</script>


