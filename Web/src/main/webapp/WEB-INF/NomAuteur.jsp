<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Ajt Article</title>
</head>
<body>
<c:forEach items="${auteur}" var="auteur">
<p> <c:out value="${ auteur.getId_auteur() }" /></p>
<p> <c:out value="${ auteur.getPseudo() }" /></p>
<c:forEach items="${article}" var="article">
<c:if test= "${ auteur.getId_auteur() == article.getAuteur().getId_auteur() }">
<p> <c:out value="${article.getTitre() }" /></p>

</c:if>
</c:forEach>
	</c:forEach>
	



</body>
</html>