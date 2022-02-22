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
      <h1>Welcome please add a new dojo</h1>
      <a href="/ninjas/add">Add a new ninja</a>
      <form:form action="/dojo/create" method="post" modelAttribute="dojo">
    <p>
        <form:label path="name">New Dojo</form:label>
        <form:errors path="name" class="text-danger" />
        <form:input path="name" type="text" class="form-control"/>
    </p>  
    <input type="submit" value="Create"/>
      </form:form>
    </div> <!-- End of Container -->
</body>
</html>