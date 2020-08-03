<#include "../main-template.ftl"/>

<@main title="Login Page"/>

<#macro content>
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
</#macro>