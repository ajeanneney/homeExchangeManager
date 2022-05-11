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

<div class="d-flex justify-content-center flex-nowrap">
    <form action="/signup" method="post" class="shadow rounded p-3 m-3">
        <h1>Page d'inscription</h1>
        <div class="row">
        <div class="form-group p-2 col">
            <label for="firstname">Prénom</label>
            <input type="text" class="form-control" id="firstname" name="firstname" placeholder="Entrez votre prénom" required>
        </div>
        <div class="form-group p-2 col">
            <label for="lastname">Nom</label>
            <input type="text" class="form-control" id="lastname" name="lastname" placeholder="Entrez votre nom" required>
        </div>
        </div>
        <div class="row">
        <div class="form-group p-2">
            <label for="mail">Adresse mail</label>
            <input type="email" class="form-control" id="mail" name="mail" aria-describedby="emailHelp" placeholder="Entrez votre mail" required>
        </div>
        <div class="form-group p-2">
            <label for="password">Mot de passe</label>
            <input type="password" class="form-control" id="password" name="password" placeholder="Mot de passe" required>
        </div>
        <div class="form-group p-2 d-flex justify-content-center">
            <button type="submit" class="btn btn-primary m-2">S'inscrire</button>
            <a href="/connexion"><button type="button" class="btn btn-secondary m-2">S'identifier</button></a>
        </div>
        </div>
    </form>
</div>

</body>
</html>
