<html>
    <head>
        <title>Users List</title>
    </head>
    <body>
        <ul>
            <#list users as user>
                <li>User name: ${user.name}</li>
                    <ul>
                        <li>age: ${user.age}</li>
                        <li>gender: ${user.sex?then('M', 'W')}</li>
                    </ul>
            </#list>
        </ul>
    </body>
</html>