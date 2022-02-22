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
                        <title>Title Here</title>
                        <!-- Bootstrap -->
                        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
                            rel="stylesheet"
                            integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
                            crossorigin="anonymous">
                    </head>

                    <body>
                        <div class="container">
                            <h1>Info about Dojo: ${dojoToShow.name}</h1>
                            <!-- <h2>${dojoToShow.ninjas}</h2> -->
                            <table class="table-info">
                                <thead>
                                    <tr>
                                        <th scope="col">Ninja ID</th>
                                        <th scope="col">First Name</th>
                                        <th scope="col">Last Name</th>
                                        <th scope="col">Age</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${dojoToShow.ninjas}" var="ninjaObj">
                                    <tr class="table-info">
                                        <td scope="row">${ninjaObj.id}</td>
                                        <td colspan="row" class="table-info">${ninjaObj.firstName}</td>
                                        <td colspan="row" class="table-info">${ninjaObj.lastName}</td>
                                        <td colspan="row" class="table-info">${ninjaObj.age}</td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>

                    </body>

                    </html>