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
        <c:forEach items="${house.photos}" var="p">
            <img src="<%=request.getContextPath()%>/images/housephotos/${p.url}">
        </c:forEach>
    </div>

    <div class="house_photos">
        <a class = "titre_maison2"> ${house.title}<br> </a>
        <a class = "description_maison2"> ${house.description}</a><br><br>

        Services à rendre dans cette maison : <br>
        <c:forEach items="${house.services}" var="s">
            ${s.name} : ${s.description}<br>
        </c:forEach>
        <br><br>

        Contraintes de cette maison : <br>
        <c:forEach items="${house.necessities}" var="n">
            ${n.name} : ${n.description}<br>
        </c:forEach>
        <br><br>

    </div>
    <br>
    <div>
        <br>
        <form action="/reserve/${house.id}" method="post">
            date début : <input type="date" id="debut" name="debut" class="inputReserve"><br><br>
            date fin : <input type="date" id="fin" name="fin" class="inputReserve"><br><br>
            <button type="submit" class="buttonReserve">Réserver</button>
        </form>
    </div>

</div>

</body>
</html>
