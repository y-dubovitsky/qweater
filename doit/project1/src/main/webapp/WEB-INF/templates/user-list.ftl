<html>
    <head>
        <title>Users List</title>
    </head>
    <body>
        <#if users?has_content>
            <ul>
                <#list users as user>
                    <li>User name: ${user.name}</li>
                    <ul>
                        <li>age: ${user.age}</li>
                        <li>gender: ${user.sex?then('M', 'W')}</li>
                    </ul>
                </#list>
            </ul>
            <#else>
            Oooop, no one here!
        </#if>
    </body>
</html>