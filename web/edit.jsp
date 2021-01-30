<%@ page import="com.service.GoodsService" %>
<%@ page import="com.service.GoodsServiceImpl" %>
<%@ page import="com.model.Goods" %><%--
  Created by IntelliJ IDEA.
  User: 陈世旭
  Date: 2021/1/28
  Time: 7:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>编辑页</title>
</head>
<h1>商品管理列表</h1>
<%
    String gid=request.getParameter("gid");
    gid=gid==null?"0":gid;
    //调用service 层通过gid查询商品详情
    GoodsService goodsService = new GoodsServiceImpl();
    Goods goodsByGid = goodsService.getGoodsByGid(Integer.parseInt(gid));
    String modify=request.getParameter("modify");
    pageContext.setAttribute("goods",goodsByGid);//放入作用域,仅本网页
%>
<form method="post" action="goods?modify=<%=modify%>">
<%--    ${param.fav} ${paramValues.fav[1] }  收集表单数据或地址参数值--%>
    编号:<input type="text" name="gid" value="${goods.gid!=0?goods.gid:""}"><br/>
    名称:<input type="text" name="gname" value="${goods.gname}"><br/>
    价格:<input type="text" name="price" value="${goods.price==0.0?"":goods.price}"><br/>
    <input type="submit" value="提交">
</form>

<body></body>
</html>
