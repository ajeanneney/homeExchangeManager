<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Connexion</title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/style.css" />
    <jsp:include page="header.jsp"/>
</head>
<h1>Ajouter une nouvelle maison</h1>

<form method="post" action="/newhome">
    <div>
        <input type="Nom de la maison" name="title" id="title" placeholder="Nom de la maison">
    </div>
    <div>
        <textarea name="description" id="description" placeholder="Entrez la description de votre maison" rows="10", cols="50"></textarea>
    </div>
    <div>
        <button type="submit">Créer la maison</button>
    </div>

</form>
</html>
