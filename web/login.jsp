<%--
  Created by IntelliJ IDEA.
  User: john
  Date: 2016/9/5
  Time: 21:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>

<form action="${pageContext.request.contextPath}/loginServlet" method="post">
    <label for="username">用户名:</label><input type="text" id="username" name="username"/><br/>
    <label for="password">密码:</label><input type="password" id="password" name="password"/><br/>
    用户名:<input type="submit"/><br/>
</form>

</body>
</html>
