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
                        <title>Login and Registration</title>
                        <!-- Bootstrap -->
                        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
                            rel="stylesheet"
                            integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
                            crossorigin="anonymous">

                    </head>

                    <body>
                        <div class="container">
                            <!-- Beginning of Container -->
                            <h1>Welcome. Please register or log in</h1>
                            <div class="row"></div>
                            <div class="col">
                                <form:form action="/register" method="post" modelAttribute="newUser">
                                    <div>
                                        <form:label path="userName">User Name</form:label>
                                        <form:errors path="userName" />
                                        <form:input path="userName" class="form-control" />
                                    </div>
                                    <div>
                                        <form:label path="email">Email</form:label>
                                        <form:errors path="email" />
                                        <form:input path="email" class="form-control" />
                                    </div>
                                    <div>
                                        <form:label path="password">Password</form:label>
                                        <form:errors path="password" />
                                        <form:input path="password" type="password" class="form-control" />
                                    </div>
                                    <div>
                                        <form:label path="confirm">Confirm Password</form:label>
                                        <form:errors path="confirm" />
                                        <form:input type="password" path="confirm" class="form-control" />
                                    </div>
                                    <input type="submit" value="Submit" class="btn btn-secondary ,mt-3" class="form-control"/>
                                </form:form>
                            </div>
                            <hr></hr>
                            <div class="col">
                                <h3>Login:</h3>
                                <form:form action="/login" method="post" modelAttribute="newLogin">
                                    <div>
                                        <form:label path="email">Email</form:label>
                                        <form:errors path="email" />
                                        <form:input path="email" class="form-control" />
                                    </div>
                                    <div>
                                        <form:label path="password">Password</form:label>
                                        <form:errors path="password" />
                                        <form:input path="password" type="password" class="form-control" />
                                    </div>
                                    <input type="submit" value="Login" class="btn btn-secondary ,mt-3" class="form-control"/>
                                </form:form>
                            </div>

                        </div> <!-- End of Container -->
                    </body>

                    </html>