<!doctype html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport"
              content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Login Page</title>
    </head>
    <body>
        <form action="/auth/login" method="post">
            Email: <input name="email" type="email">
            Password: <input name="password" type="password">
            Login: <input type="submit">
        </form>
    <#if error??>
        <p>Bad credentials</p>
    </#if>
    </body>
</html>