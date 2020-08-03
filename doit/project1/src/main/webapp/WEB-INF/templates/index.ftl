<#include "main-template.ftl"/>

<@main title="Main Page"/>

<#macro content>
    <body>
        <h1>
            <#if msg??>
                Hi ${msg}, How are you? <br>
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
</#macro>

