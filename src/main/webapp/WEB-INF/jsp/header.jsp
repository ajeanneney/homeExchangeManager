<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Host Dog</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/style.css" />
</head>


<body>

<ul>
    <li><a href="#findAHost">Find a Host</a></li>
    <li><a href="#becomeAHost">Become A Host</a></li>
    <li><a href="#sharePetsServices">Share Pet's Services</a></li>
    <c:choose>
        <c:when test="${cookie['userId'] == null || cookie['userId'] == ''}">
            <li style="float:right"><a href="#logIn">Log In / Sign Up</a></li>
        </c:when>
        <c:otherwise>
            <li style="float:right"><a href="/disconnect">Disconnect</a></li>
        </c:otherwise>
    </c:choose>
</ul>

</body>
</html>

