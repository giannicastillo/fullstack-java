<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
   <!-- c:out ; c:forEach ; c:if -->
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
   <!-- Formatting (like dates) -->
 <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
   <!-- form:form -->
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
   <!-- for rendering errors on PUT routes -->
 <%@ page isErrorPage="true" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Title Here</title>
  <!-- Bootstrap -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" 
      rel="stylesheet" 
      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" 
      crossorigin="anonymous">

</head>
<body>
    <div class="container"> <!-- Beginning of Container -->
        <h1> All the menu items, Choose from our fanastic selection.</h1>
        <table class="table table-success table-striped">
          <thead>
            <tr>
              <th scope="col">Expense</th>
              <th scope="col">Vendor</th>
              <th scope="col">Amount</th>
              <th scope="col">Actions</th>
            </tr>
          </thead>
          <tbody>
            <c:forEach items="${allTravelItems}" var= "travelObj">
            <tr>
              <td><a href="/travelitems/${travelObj.id}">${travelObj.expense}</a></td>
              <td>${travelObj.vendor}</td>
              <td>${travelObj.amount}</td>
              <td>
                  <a href="/travelitems/edit/${travelObj.id}">Edit</a>
                  <a href="/travelitems/delete/${travelObj.id}">Delete</a>
            </td>
            </tr>
          </c:forEach>
            </tbody>
        </table>

        <hr>
        <form:form action="/travelitems/create" method="post" modelAttribute="travelItem">
          <p>
            <form:label path="expense">Expense</form:label>
            <form:errors path="expense"/>
            <form:input path="expense" class="form-control"/>
          </p>
          <p>
              <form:label path="vendor">Vendor</form:label>
              <form:errors path="vendor"/>
              <form:input path="vendor" class="form-control"/>
          </p>
          <p>
              <form:label path="amount">Amount</form:label>
              <form:errors path="amount"/>
              <form:input type="number" path="amount" class="form-control"/>
          </p>
          <p>
              <form:label path="description">Description</form:label>
              <form:errors path="description"/>
              <form:textarea path="description" class="form-control"/>
          </p>    
          <input type="submit" value="Submit"/>
      </form:form>    
    </div> <!-- End of Container -->
</body>
</html>