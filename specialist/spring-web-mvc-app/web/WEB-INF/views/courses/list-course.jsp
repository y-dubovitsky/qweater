<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <title>Courses List</title>
    </head>
    <body>
        <h1>List of courses</h1>
        <c:if test="${not empty courseList}">
            <h1>NotEmpty</h1>
        </c:if>
    </body>
</html>
