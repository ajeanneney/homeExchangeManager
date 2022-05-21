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
        Mail : ${user.mail}<br>
    </div>

    <div class="shadow3">
    Maisons : <br>
    <table class="table">
        <tr>
            <th>title</th>
            <th>description</th>
        </tr>
        <c:forEach items="${houses}" var="h">
            <tr>
                <td><a href="house/${h.id}">${h.title}</a></td>
                <td>${h.description}</td>
            </tr>
        </c:forEach>
        <a href="/newhouse">Ajouter une maison</a>
    </table>
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
    </div>

</div>

</body>
</html>
