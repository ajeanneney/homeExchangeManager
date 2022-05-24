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
<h1>Admin</h1>

<div>
    <form action="/admin" method="post">
        Ajouter une contrainte ou un service :
        <div>
        <select name="type" id="type">
            <option value="necessity">Contrainte</option>
            <option value="service">Service</option>
        </select>
        </div>
        <div>Titre <input type="text" name="title" id="title"></div>
        <div>Description <input type="text" name="description" id="description"></div>
        <button type="submit">Créer</button>
    </form>
</div>

<div>
    Gérer les utilisateurs :
    <div>
        <table class="table">
            <tr>
                <th>Nom</th>
                <th>Prénom</th>
                <th>Mail</th>
                <th>Supprimer</th>
            </tr>
            <c:forEach items="${users}" var="u">
                <tr>
                    <td>${u.lastname}</td>
                    <td>${u.firstname}</td>
                    <td>${u.mail}</td>
                    <td><a href="/admin/delete/${u.id}" onclick="return confirm('Vous êtes sur de vouloir supprimer ${u.firstname} ${u.lastname}')">❌</a></td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>

</body>
</html>
