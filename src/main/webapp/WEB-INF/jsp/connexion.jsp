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

<h1>Page de connexion</h1>

<div class="connexion">
    <form action="/connexion" method="post" class="shadow2">
        <h2>Profil</h2>
        <div class="form-group p-2">
            <%--<!<label for="mail">Adresse mail</label>>--%>
            <input type="email" class="form-control" id="mail" name="mail" aria-describedby="emailHelp" placeholder="Entrez votre mail" required>
        </div>
        <div class="form-group p-2">
            <%--<label for="password">Mot de passe</label>--%>
            <input type="password" class="form-control" id="password" name="password" placeholder="Mot de passe" required>
        </div>
        <div class="form-group2">
            <button type="submit" class="btn_btn-primary_m-2">Connexion</button><br>
            <%--<a href="/signup"><button type="button" class="btn_btn-secondary_m-2">Si vous n'avez pas de compte, veillez en créer un
            </button></a>--%>
        </div>
        <a href="/signup">Si vous n'avez pas de compte, veillez en créer un</a>
    </form>
</div>

</body>
</html>
