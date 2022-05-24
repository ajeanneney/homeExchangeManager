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
<h1>Modifier son profil</h1>

<div class="d-flex justify-content-around">
    <div class="shadow3">
        Prenom : ${user.firstname}<br>
        Nom : ${user.lastname}<br>
        Mail : ${user.mail}<br><br>
    </div>

    <div class="shadow3">
        <form action="/profile" method="post">
            <label for="firstname">Modifier Prénom :</label><input type="text" value="${user.firstname}" name="firstname" id="firstname"><br>
            <label for="lastname">Modifier Nom : </label><input type="text" value="${user.lastname}" name="lastname" id="lastname"><br>
            <label for="mail">Modifier mail : </label><input type="email" value="${user.mail}" name="mail" id="mail"><br>
            <label for="password">Modifier mot de passe : </label><input type="pasword" name="password" id="password"><br>
            <button type="submit">Modifier</button>
        </form>
    </div>
</div>
</body>
</html>
