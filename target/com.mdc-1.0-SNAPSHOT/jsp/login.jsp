<%--
  Created by IntelliJ IDEA.
  User: mengdacheng
  Date: 2017/1/13
  Time: 下午6:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>搜图登录</title>
</head>
<body>
<div style="width: 300px; margin: 200px auto">
    <c:if test="${!empty error}">
        <font color="red"><c:out value="${error}"/></font>
    </c:if>
    <form action="<c:url value="/loginCheck.html"/>" method="post">
        <div style="float: left; width: 80px">Username：</div>
        <div><input type="text" name="userName"></div>

        <br><br>
        <div style="float: left;width: 80px">Password：</div>
        <div><input type="password" name="password"></div>
        <br>
        <br>
        <div style="margin-left: 80px">
            <input type="submit" value="Login">
            <input type="reset" value="Reset">
        </div>
    </form>
</div>
</body>
</html>
