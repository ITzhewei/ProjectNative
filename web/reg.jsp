<%--
  Created by IntelliJ IDEA.
  User: john
  Date: 2016/9/5
  Time: 21:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/regServlet" method="post">
    用户名:<input type="text" name="username"><br/>
    密码:<input type="password" name="password"><br/>
    确认密码:<input type="password" name="repassword"><br/>
    邮箱:<input type="text" name="email"><br/>
    生日:<input type="text" name="birthday"><br/>
    <input type="submit" value="注册">
</form>
</body>
</html>
