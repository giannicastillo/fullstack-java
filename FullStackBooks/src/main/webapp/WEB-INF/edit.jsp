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
                        <title>Edit Book</title>
                        <!-- Bootstrap -->
                        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
                            rel="stylesheet"
                            integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
                            crossorigin="anonymous">

                    </head>

                    <body>
                        <h1>Add a book to your bookshelf!</h1>
                        <div class="container">
                            <h1>Edit Idea</h1>
                            <form:form action="/books/${book.id}/update" method="post" modelAttribute="book">
                                <input type="hidden" name="_method" value="put"/>
                                <form:input type="hidden" path="user" value="${idOfLoggedInUser}" />
                                
                                <div>
                                    <form:label path="title">Title</form:label>
                                    <form:errors path="title" class="text-danger" />
                                    <form:input path="title" class="form-control" />
                                </div>
                                <div>
                                    <form:label path="authorName">Author Name</form:label>
                                    <form:errors path="authorName" class="text-danger" />
                                    <form:input path="authorName" class="form-control" />
                                </div>
                                <div>
                                    <form:label path="myThoughts">My Thoughts</form:label>
                                    <form:errors path="myThoughts" class="text-danger" />
                                    <form:textarea path="myThoughts" type="text" class="form-control" />
                                </div>
                                <input type="submit" value="Submit" class="btn btn-secondary mt-3"
                                    class="form-control" />
                            </form:form>
                        </div>

                    </body>

                    </html>