<%--
  Created by IntelliJ IDEA.
  User: john
  Date: 2016/9/5
  Time: 20:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
<c:if test="${ empty s }">
    <a href="login.jsp">登录</a>
    <a href="reg.jsp">注册</a>
</c:if>
<c:if test="${not empty s }">
    欢迎你${s.username}
</c:if>
</body>
</html>
