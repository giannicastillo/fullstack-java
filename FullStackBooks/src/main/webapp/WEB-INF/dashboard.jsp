<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <!-- c:out ; c:forEach ; c:if -->
  <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <!-- Formatting (like dates) -->
    <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
      <!-- form:form -->
      <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
        <!-- for rendering errors on PUT routes -->
        <%@ page isErrorPage="true" %>
          <!DOCTYPE html>
          <html>

          <head>
            <meta charset="UTF-8">
            <title>Dashboard</title>
            <!-- Bootstrap -->
            <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
              crossorigin="anonymous">

          </head>

          <body>
            <h1>Welcome to the dashboard. ${loggedInUser.userName} </h1>
            <h3>Books from everyone's shelves:</h3>
            <a href="/logout" class="float-end" >Logout</a> 
            <a href="/books/new" class="float-end" me-3>Add a new Book</a>
            <h2>${allBooks}</h2>
            <div class="container">
              <table class="table">
                <thead>
                  <tr>
                    <th scope="col">ID</th>
                    <th scope="col">Title</th>
                    <th scope="col">Author Name</th>
                    <th scope="col">Posted By</th>
                    <th scope="col">Actions</th>
                  </tr>
                </thead>
                <tbody>
                  <c:forEach items="${allBooks}" var="bookObj">
                    <tr class="table-info">
                      <td scope="row">${bookObj.id}</td>
                      <td colspan="row" class="table-info"><a href="/books/${bookObj.id}/details">${bookObj.title}</a></td>
                      <!-- make sure that href link is reflecting the url -->
                      <td colspan="row" class="table-info">${bookObj.authorName}</td>
                      <td colspan="row" class="table-info">${bookObj.user.userName}</td>
                      <td colspan="row" class="table-info">
                        <!-- if the loggedInUser id is the same as the bookObj's user it, then they can see the edit link -->
                        <c:if test='${loggedInUser.id == bookObj.user.id}'>
                        <a href="/books/${bookObj.id}/edit">Edit</a> ||
                        <a href="/books/${bookObj.id}/delete">Delete</a>
                        </c:if>
                      </td>
                    </tr>
                  </c:forEach>
                </tbody>
              </table>
            </div>
          </body>

          </html>