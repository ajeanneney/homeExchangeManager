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
<h1>Home</h1>

<div class="d-flex justify-content-around">

    <div class="shadow3">
        Prenom : ${user.firstname}<br>
        Nom : ${user.lastname}<br>
        Mail : ${user.mail}<br><br>
        <a class="btn_btn-primary_m-2" href="/profile">Modifier mon profil</a>
    </div>

    <div class="shadow3">
    Maisons : <br>
    <table class="table">
        <tr>
            <th><a class="titre_maison">Maison</a></th>
            <th><a class="titre_maison">description</a></th>
        </tr>
        <c:forEach items="${houses}" var="h">
            <tr>
                <td><a class="titre_maison" href="house/${h.id}">${h.title}</a></td>
                <td> ${h.description}</td>
            </tr>
        </c:forEach>
    </table>
        <a class="btn_btn-primary_m-2" href="/newhouse">Ajouter une maison</a>
    </div>

    <div class="shadow3">
    Reservations : <br>
    <table class="table">
        <tr>
            <th>maison</th>
            <th>date debut</th>
            <th>date fin</th>
            <th>validation</th>
        </tr>
        <c:forEach items="${reservations}" var="r">
            <tr>
                <td>${r.house.getDescription()}</td>
                <td>${r.startDate}</td>
                <td>${r.endDate}</td>
                <td>${r.validated}</td>
            </tr>
        </c:forEach>
    </table>
        <a class="btn_btn-primary_m-2" href="/search">Réserver une maison</a>
    </div>

</div>

</body>
</html>
