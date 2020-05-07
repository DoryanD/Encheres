<%@ page  language="java"
          contentType="text/html; charset=UTF-8"
          pageEncoding="UTF-8"
  %>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<!--Bootsrap 4 CDN-->
<link rel="stylesheet" href="Assets/bootstrap/css/bootstrap.min.css">
<script src="Assets/boostrap/js/bootstrap.min.js"></script>

<title><%=request.getSession().getAttribute("pseudo")%></title>
</head>
<body>
	<div class="jumbotron">
		<div class="container">
			<a href="/Enchere/Accueil" class="h1">ENI - Enchères</a>
		</div>
	</div>
	<div class="container d-flex justify-content-center pt-5 mt-5">
		<div class="pr-5">
			<p>Pseudo :</p>
			<p>Nom :</p>
			<p>Prénom :</p>
			<p>Email :</p>
			<p>Téléphone :</p>
			<p>Rue :</p>
			<p>Code Postal :</p>
			<p>Ville :</p>
		</div>
		<div class="text-center pl-5">
			<p>${pseudo}</p>
			<p>${nom}</p>
			<p>${prenom}</p>
			<p>${Email}</p>
			<p>${tel}</p>
			<p>${Rue}</p>
			<p>${cp}</p>
			<p>${ville}</p>
		</div>
	</div>
	<c:if test="${affichageButton}">
		<div class="text-center mt-5">
			<a class="btn btn-outline-secondary"
				href="ModificationProfil?id=<%=request.getSession().getAttribute("id")%>">Modifier</a>
		</div>
	</c:if>
</body>
</html>