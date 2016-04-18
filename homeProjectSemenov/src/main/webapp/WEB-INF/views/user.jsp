<%--
  Created by IntelliJ IDEA.
  User: semen
  Date: 12.04.2016
  Time: 21:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <meta name="_csrf" content="${_csrf.token}"/>
  <!-- default header name is X-CSRF-TOKEN -->
  <meta name="_csrf_header" content="${_csrf.headerName}"/>
  <!-- ... -->
  <title>User page</title>

  <script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>

  <%--<link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"/>--%>
  <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"/>

</head>
<body>
Dear <strong>${user}</strong>, Welcome to User Page.

<a href="<c:url value="/security/logout" />">Logout</a>
</br>
<a href="article/newarticle"/>NewArticle</a>
<h2>List of User Articles</h2>
<table class="table data-contacts-js table ">
  <tr>
    <td>id</td><td>Title</td><td>Text</td><td></td><td></td>
  </tr>
  <c:forEach items="${articles}" var="article">
    <tr>
      <td>${article.id}</td>
      <td>${article.title}</td>
      <td>${article.text}</td>
      <td><a href="<c:url value='/article/edit-article-${article.id}' />">edit</a></td>
      <td><a href="<c:url value='/article/delete-article-${article.id}' />">delete</a></td>
    </tr>
  </c:forEach>
</table>
<br/>



<div>
  <sec:authorize access="hasRole('ADMIN')">
    <label> This part is visible only to ADMIN</label>
  </sec:authorize>
</div>

<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal" >New Article</button>

<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="exampleModalLabel">New message</h4>
      </div>
      <div class="modal-body">
        <form>
          <div class="form-group">
            <label for="title" class="control-label">Recipient:</label>
            <input type="text" class="form-control" id="title">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
          </div>
          <div class="form-group">
            <label for="text" class="control-label">Message:</label>
            <textarea class="form-control" id="text"></textarea>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
          </div>
        </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        <button type="button"  onclick="SaveArticle()" class="btn btn-primary">Save article</button>
      </div>
    </div>
  </div>
</div>


<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>
</body>
</html>

<script>

  var SaveArticle = function() {
    $('#exampleModal').on('show.bs.modal', function (event) {
      var button = $(event.relatedTarget) // Button that triggered the modal
      var recipient = button.data('whatever') // Extract info from data-* attributes
      // If necessary, you could initiate an AJAX request here (and then do the updating in a callback).
      // Update the modal's content. We'll use jQuery here, but you could use a data binding library or other methods instead.
      var modal = $(this)
      modal.find('.modal-title').text('New message to ' + recipient)
      modal.find('.modal-body input').val(recipient)
    })


    $.ajax({
      type: 'POST',
      url: "http://localhost:8080/homeProject/article/new",
      dataType: 'json',
      data:{ "${_csrf.parameterName}" : "${_csrf.token}", title: $('#title').val(), text : $('#text').val() },
      success:function (art) {
        $(".data-contacts-js").append(
                "<tr><td>" +art.articleId + "</td>" +
                "<td>" + art.title + "</td>" +
                "<td>" + art.text + "</td>" +
                "<td>" + "Rdit" + "</td>" +
                "<td>" + "<button type='button' id='asd' onclick=' DeleteArt(" + parseInt(art.articleId) + ");'>DELETE</button> " + "</td></tr>");
      }
    })
  }
</script>