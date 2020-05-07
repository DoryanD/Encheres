<%@ page  language="java"
          contentType="text/html; charset=UTF-8"
          pageEncoding="UTF-8"
  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Enchere</title>

<!--Bootsrap 4 CDN-->
<link rel="stylesheet" href="Assets/bootstrap/css/bootstrap.min.css">
<script src="Assets/boostrap/js/bootstrap.min.js"></script>
</head>
<body>
<div class="jumbotron">
		<div class="container">
			<a href="/Enchere/Accueil" class="h1">ENI - Enchères</a>
		</div>
	</div>
	<h4 class="text-center">${NomArticle}</h4>
	<div class="container d-flex justify-content-center pt-5 mt-5">
		
		<div class="pr-5">
			<p>Description :</p>
			<p>Categorie :</p>
			<p>Meilleur offre :</p>
			<p>Mise à prix :</p>
			<p>Fin de l'enchère :</p>
			<p>Retrait :</p>
			<p>Vendeur :</p>
		
		</div>
		<div class="text-center pl-5">
			<p>${Description}</p>
			<p>${Categorie}</p>
			<p>${MeilleurOffre}</p>
			<p>${MiseAPrix}</p>
			<p>${DateFin}</p>
			<p>${Rue},${CP},${Ville}</p>
			<p>${Vendeur}</p>

		</div>
	</div>
</body>
</html>
