<#assign sf=JspTaglibs["http://www.springframework.org/tags"]>
<#assign sf=JspTaglibs["http://www.springframework.org/tags/form"]>

<!doctype html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport"
              content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>User List</title>
    </head>
    <body>
        <@sf.form action="/user/register" method="post" modelAttribute="user">
            <div>
                <@sf.label path="name">User Name</@sf.label>
                <@sf.input path="name"/>
                <@sf.errors path="name"/>
            </div>
            <div>
                <@sf.label path="age">Age</@sf.label>
                <@sf.input path="age"/>
                <@sf.errors path="age"/>
            </div>
            <div>
                <@sf.label path="email">Email</@sf.label>
                <@sf.input path="email"/>
                <@sf.errors path="email"/>
            </div>
            <div>
                Gender:
                Male: <@sf.radiobutton path="sex" value="true"/>
                Female: <@sf.radiobutton path="sex" value="false"/>
            </div>
            <input type="submit" value="Register User">
        </@sf.form>
    </body>
</html>
