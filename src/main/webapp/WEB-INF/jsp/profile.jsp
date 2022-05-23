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
    </div>
</div>
</body>
</html>
