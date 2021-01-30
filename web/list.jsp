<%@ page import="com.service.GoodsService" %>
<%@ page import="com.service.GoodsServiceImpl" %>
<%@ page import="com.model.Goods" %>
<%@ page import="java.util.List" %>
<%@ page import="com.model.Count" %><%--
  Created by IntelliJ IDEA.
  User: 陈世旭
  Date: 2021/1/30
  Time: 0:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>商品管理页</title>
</head>
<body>
    <h1>商品管理列表</h1>
    在线人数:<%=Count.ONLINE_NUM%><br/>
    当前用户名:${user.ename}
    <br/>
    <a href="edit.jsp?modify=0">新增</a>
    <a href="logout">注销</a>
    <table border="1px" width="500px">
        <tr>
            <td>编号</td>
            <td>名称</td>
            <td>价格</td>
            <td>操作</td>
        </tr>
        <c:forEach items="${list}" var="goods">
            <tr>
                <td>${goods.gid}</td>
                <td>${goods.gname}</td>
                <td>${goods.price}</td>
                <td>
                <a href="edit.jsp?modify=1&gid=${goods.gid}&gname=${goods.gname}&price=${goods.price}">修改</a>
                <a href="goods?cmd=del&gid=${goods.gid}" onclick="return confirm('是否删除')">删除</a>
                </td>>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
