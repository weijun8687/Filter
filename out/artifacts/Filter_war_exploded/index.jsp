<%--
  Created by IntelliJ IDEA.
  User: wj
  Date: 2017/9/12
  Time: 下午2:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>

  <c:if test="${sessionScope.user==null}">
    <a href="${pageContext.request.contextPath}/login.jsp">登录</a>
  </c:if>

  <c:if test="${sessionScope.user!=null}">
    欢迎您:${sessionScope.user.nickname}
  </c:if>

  </body>
</html>
