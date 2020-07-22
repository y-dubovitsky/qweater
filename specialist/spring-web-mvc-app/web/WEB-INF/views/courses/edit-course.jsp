<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
    <head>
        <title>Edit Course</title>
    </head>
    <body>
        <h2>Edit course # ${editCourse.id}</h2>
        <form name="Edit" method="post">
            <p><b>Course title:</b><br>
                <input type="text" size="40" name="title" value="${editCourse.title}">
            </p>
            <p><b>Course length имя:</b><br>
                <input type="number" size="40" name="length" value="${editCourse.length}">
            </p>
            <p><b>Course description:</b><br>
                <input type="text" name="description" value="${editCourse.description}">
            </p>
                <input type="submit" value="Save Changes"></p>
        </form>
    </body>
</html>
