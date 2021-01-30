<%--
  Created by IntelliJ IDEA.
  User: 陈世旭
  Date: 2021/1/30
  Time: 5:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页面</title>
</head>
<body>
    <h1>用户登录</h1>

    <%--    可登录的用户名必须包含admin    可登录 可放行--%>
    <form action="login" method="post">
        用户名<input type="text" name="ename" ><br/>
        <input type="submit" value="登录" >
    </form>
</body>
</html>
