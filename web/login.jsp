<%--
  Created by IntelliJ IDEA.
  User: wj
  Date: 2017/9/13
  Time: 上午11:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/servlet/LoginServlet" method="post">

    用户名:<input type="text" name="username"><br>
    密码:<input type="password" name="password"><br>
    <input type="checkbox" value="记住密码" name="remember">
    <input type="submit" value="登录">

</form>



</body>
</html>
