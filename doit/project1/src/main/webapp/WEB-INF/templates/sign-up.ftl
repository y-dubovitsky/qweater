<html>
    <head>
        <title>Users List</title>
    </head>
    <body>
        <form action="/user/register-model-attribute" method="post">
                <input type="text" name="name" placeholder="user name">
                <input type="number" name="age" placeholder="user age">
                <b>Какой у вас пол?</b><Br>
                <input type="radio" name="sex" value="true"> Man<Br>
                <input type="radio" name="sex" value="false"> Woman<Br>
            <input type="submit" value="Register User">
        </form>
    </body>
</html>