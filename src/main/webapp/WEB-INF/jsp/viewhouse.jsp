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

<br><br><br>
    <div class="wrapper2">

        <div class="house_photos">
        <c:forEach items="${photos}" var="p">
            <img src="<%=request.getContextPath()%>/images/housephotos/${p.url}">
        </c:forEach>
        </div>

        <div class="house_photos">
            <a class = "titre_maison2"> ${house.title}<br> </a>
            <a class = "description_maison2"> ${house.description}<br> </a>
            <br>
            <br>
            <a class = "btn_btn-primary_m-2" href="/reserve/${house.id}">Réserver cette maison</a>
        </div>

    </div>
</body>
</html>
