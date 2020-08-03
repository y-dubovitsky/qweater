<#assign sf=JspTaglibs["http://www.springframework.org/tags"]>
<#assign sf=JspTaglibs["http://www.springframework.org/tags/form"]>

<#include "../main-template.ftl"/>

<@main title="Register Page"/>

<#macro content>
    <body>
        <@sf.form action="/login/process" method="post" modelAttribute="user">
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
                <@sf.label path="password">Password</@sf.label>
                <@sf.input path="password"/>
                <@sf.errors path="password"/>
            </div>
            <div>
                Gender:
                Male: <@sf.radiobutton path="sex" value="true"/>
                Female: <@sf.radiobutton path="sex" value="false"/>
            </div>
            <input type="submit" value="Register User">
        </@sf.form>
    </body>
</#macro>
