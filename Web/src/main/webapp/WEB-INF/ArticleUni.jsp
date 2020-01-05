<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Article</title>
</head>
<body>

<p> ${ article.getAuteur().getPseudo()}</p>
<p> ${ article.getTitre() }</p>
<p> ${ article.getDescription() }</p>
<p> ${ article.getTexte() } </p>
<p> ${ article.getDate() } </p>
	



</body>
</html>