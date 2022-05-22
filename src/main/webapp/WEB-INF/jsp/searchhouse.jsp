<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Connexion</title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/style.css" />
    <jsp:include page="header.jsp"/>
</head>
<body>

<c:forEach items="${houses}" var="h">

    <div class="wrapper">
        <a class = "titre_maison"> ${h.title}<br> </a>
        <a class = "description_maison">${h.description}<br> <br> </a>
        <a class="btn_btn-primary_m-2" href="house/${h.id}">Voir cette maison</a>
    </div>

</c:forEach>


</body>
</html>
