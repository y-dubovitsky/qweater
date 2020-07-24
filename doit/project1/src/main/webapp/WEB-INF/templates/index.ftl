<html>
    <head>
        <title>Index</title>
    </head>
    <body>
        <h1>
            <#if msg??>
                Hi ${msg}, How are you?
            </#if>
        </h1>
        <h2>
            <#if name??>
                Hi ${name}, How are you?
            </#if>
        </h2>
        <h2>
            <#if pathVariable??>
                Hi ${pathVariable}, How are you?
            </#if>
        </h2>
    </body>
</html>
