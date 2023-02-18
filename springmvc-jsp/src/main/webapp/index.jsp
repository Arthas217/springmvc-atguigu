<%--
  Created by IntelliJ IDEA.
  User: zuocheng
  Date: 2023/2/18
  Time: 21:37
  To change this template use File | Settings | File Templates.
--%>
<%--jsp指令--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSP页面</title>
</head>
<body>
    <H1>首页---JSP页面</H1>
    <%--链接中，前面路径使用了EL表达式--%>
    <a href="${pageContext.request.contextPath}/jspSuccess">跳转success.jsp</a><br>
</body>
</html>
