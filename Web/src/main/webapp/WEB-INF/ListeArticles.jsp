<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Liste Article</title>
</head>
<body>
	<c:forEach items="${article}" var="article">
		<p>
			<c:out value="${ article.getAuteur().getPseudo() }" />
		</p>
		<p>
			<c:out value="${ article.getTitre() }" />
		</p>
		<p>
			<c:out value="${ article.getDescription() }" />
		</p>
		<p>
			<c:out value="${ article.getTexte() }" />
		</p>
		<p>
			<c:out value="${ article.getDate() }" />
		</p>
		<form action="" method="post">
		<input type="hidden" name="id"
			value=<c:out value="${ article.getId() }" />>
		<button type="submit" name="supprimer">Supprimer</button>

	</form>
	</c:forEach>

	



</body>
</html>



</body>
</html>