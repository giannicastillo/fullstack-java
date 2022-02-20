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
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" 
      rel="stylesheet" 
      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" 
      crossorigin="anonymous">
<title>Insert title here</title>
</head>
<body>
    <div class="container">
        <h1>Edit travel expense below: </h1>
        <form:form action="/travelitems/update/${itemToEdit.id}" method="post" modelAttribute="itemToEdit">
        <input type="hidden" name="_method" value="put">
        <p>
            <form:label path="expense">Expense</form:label>
            <form:errors class= "text-danger" path="expense"/>
            <form:input path="expense" class="form-control"/>
          </p>
          <p>
              <form:label path="vendor">Vendor</form:label>
              <form:errors  class= "text-danger" path="vendor"/>
              <form:input path="vendor" class="form-control"/>
          </p>
          <p>
              <form:label path="amount">Amount</form:label>
              <form:errors path="amount" class= "text-danger"/>
              <form:input type="number" path="amount" class="form-control"/>
          </p>
          <p>
              <form:label path="description">Description</form:label>
              <form:errors class= "text-danger" path="description"/>
              <form:textarea path="description" class="form-control"/>
          </p>
          <input type="submit" value="Submit"/>
      </form:form>
    </div>
</body>
</html>