<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<!--Bootsrap 4 CDN-->
<link rel="stylesheet" href="Assets/bootstrap/css/bootstrap.min.css">
<script src="Assets/boostrap/js/bootstrap.min.js"></script>

<title>${utilisateur.pseudo }</title>
</head>
<body>
<div class="jumbotron">
    <div class="container">
        <a href="Home" class="h1">ENI - Enchères</a>
    </div>
</div>
<div class="container d-flex justify-content-center pt-5 mt-5">
	<div class="pr-5">
		<p>Pseudo : </p>
		<p>Nom : </p>
		<p>Prénom : </p>
		<p>Email : </p>
		<p>Téléphone : </p>
		<p>Rue : </p>
		<p>Code Postal : </p>
		<p>Ville : </p>
	</div>
	<div class="text-center pl-5">
		<p>${session.pseudo }</p>
		<p>${session.nom }</p>
		<p>${session.prenom }</p>
		<p>${session.Email }</p>
		<p>${session.tel }</p>
		<p>${session.Rue }</p>
		<p>${session.codePostal }</p>
		<p>${session.ville }</p>
	</div>
</div>
<div class="text-center mt-5">
	<c:if test="${modifier==oui }">
		<a class="btn btn-outline-secondary" href="ModifierProfil?id=${session.id }">Modifier</a>
	</c:if>
</div>
</body>
</html>