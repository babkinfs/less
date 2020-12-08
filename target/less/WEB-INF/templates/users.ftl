<html lang="ru">
<head>
    <title>Users</title>
</head>
<body>
<#if users?has_content>
    <p>
    <ul>
        <#list users as user>
            <li>
                ${user.name} ${user.surname} ${user.email}
            </li>
        </#list>
    </ul>
    </p>
<#else >
    <p>Users not yet</p>
</#if>
</body>
</html>
