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

<h1>Reserver une maison</h1>

Nom de la maison : ${house.title}<br>
Description de la maison : ${house.description}<br>


<br><br>
Photos :
<c:forEach items="${photos}" var="p">
    <img src="<%=request.getContextPath()%>/images/housephotos/${p.url}">
</c:forEach>

<form action="/reserve/${house.id}" method="post">
    date début : <input type="date" id="debut" name="debut"><br>
    date fin : <input type="date" id="fin" name="fin"><br>
    <button type="submit">Réserver</button>
</form>

</body>
</html>
