<%--
  Created by IntelliJ IDEA.
  User: mengdacheng
  Date: 2017/1/13
  Time: 下午6:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>SoTu</title>
</head>
<body style="width: 100%; margin: 0; padding: 0;">
<div style="width: 90%; margin: 10px auto 0 auto;">
    ${user.userName},Welcome to BaobaoTao，your current Credit is ${user.credits}
</div>
<div style="width: 400px; margin: 50px auto 0 auto; text-align: center"><a style="font-size: xx-large; font-family: Arial; font-weight: 900">SOTO</a></div>
<form action="<c:url value="/search.html"/>" method="post" style="width: 550px; margin: 50px auto 50px auto;">
    <input type="text" name="keyword" style="width: 400px;height: 20px;" placeholder="Input Keywords">
    <input type="submit" style="width: 50px;" value="Search">
    <input type="button" name="" value="Refresh" onclick="javascript:window.location='/refresh.html';" />
</form>
<div style="width: 90%; margin: 0 auto;">
    <c:forEach var="b" items="${backgrounds}">
        <a href="/orign.html?imgUrl=${b.image}">
            <img src="/image.html?imgUrl=${b.thumbnail}" width="200" height="150" />
        </a>
    </c:forEach>
</div>
</body>
</html>
