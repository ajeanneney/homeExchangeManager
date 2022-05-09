<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Connexion</title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/style.css" />
    <jsp:include page="header.jsp"></jsp:include>
</head>
<body>
<h1>Page de connexion</h1>

<form action="/connexion" method="post">
    <label for="mail">Mail :</label>
    <input type="email" name="mail" id="mail"/><br>

    <label for="password">Mot de passe :</label>
    <input type="password" name="password" id="password"/><br>

    <input type="submit" value="Connexion">
</form>
</body>
</html>
