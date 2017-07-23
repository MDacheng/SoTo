<%--
  Created by IntelliJ IDEA.
  User: mengdacheng
  Date: 2017/4/9
  Time: 下午8:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        .button{
            text-decoration: none;
            position: absolute;
            top: 50px;
            right: 100px;
            width: 100px;
            height: 30px;
            line-height: 30px;
            border-radius: 5px;
            background-color: darkorange;
            text-align: center;
            color: white;
        }
    </style>
</head>
<body oncontextmenu="return false" ondragstart="return false" onselectstart="return false">
<img src="/image.html?imgUrl=${orimg}" width="100%" height="100%"/>
<a class="button" href="/download.html?imgUrl=${orimg}">Download</a>
</body>
</html>
