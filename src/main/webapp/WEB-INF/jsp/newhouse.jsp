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
<h1>Ajouter une nouvelle maison</h1>

<form method="post" action="/newhouse" enctype="multipart/form-data" class="gridNewhouse">
    <div class="div1">
    <div>
        <input type="Nom de la maison" class="input2" name="title" id="title" placeholder="Nom de la maison">
    </div>
    <div>
        <textarea name="description" class="input2" id="description" placeholder="Entrez la description de votre maison" rows="10", cols="50"></textarea>
    </div>
    <div>
        <input type="file" id="photos" name="photos" accept="image/png, image/jpeg" multiple>
    </div>
    </div>

    <br>

    <div class="div2">
    <div>
        Services à effectuer dans la maison :<br>
    <c:forEach items="${services}" var="s">
        <input type="checkbox" name="services" value="${s.id}">${s.name} : ${s.description}<br>
    </c:forEach>
    </div>
    <br>

    <div>
        Contraintes de cette location : <br>
        <c:forEach items="${necessities}" var="n">
            <input type="checkbox" name="necessities" value="${n.id}">${n.name} : ${n.description}<br>
        </c:forEach>
    </div>


    <div>
        <button type="submit" class="btn_btn-ter_m-2">Créer la maison</button>
    </div>

    </div>

</form>
</html>
