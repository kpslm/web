<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Ajouter Article</title>
</head>
<body>
<form action="" method="post">
    <div>
        <label for="titre">Titre :</label>
        <input type="text" id="Titre" name="Titre" value="<c:out value="${ article.getTitre() }" />">
    </div>
    <div>
        <label for="description">Description :</label>
        <input type="text" id="Description" name="Description" value="<c:out value="${ article.getDescription() }" />">
    </div>
    <div>
        <label for="msg">Texte :</label>
        <textarea id="Texte" name="Texte" ><c:out value="${ article.getTexte() }" /></textarea>
    </div>
    <button type="submit" name="AjtArticle">ajouter</button>
    
</form>



</body>
</html>