<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">

<!--Bootsrap 4 CDN-->
<link rel="stylesheet" href="Assets/bootstrap/css/bootstrap.min.css">
<script src="Assets/boostrap/js/bootstrap.min.js"></script>

    
<title>Liste des enchères</title>
</head>
<body>


<nav class="d-flex justify-content-between text-dark align-items-center p-3 bg-light">
		<h1><a href="Accueil" class="nav-link" >ENI - Enchères</a></h1>
	    <a href="seConnecter" class="nav-link">S'inscrire - Se connecter</a>
</nav>
<div class="jumbotron text-center">
	<h1>Liste des enchères</h1>
</div>
<div class="text-center">
	<c:if test="${!empty message }">
		<p>${message }</p>
	</c:if>
</div>
<form class="d-flex justify-content-around mt-5" action="ListeEnchereDeconnecte" method="POST">
	<div class="w-25">
		<label>Filtres : </label><br>
		<input style="width: 400px;" name="nom" type="text" placeholder="Le nom de l'article contient">
		<label class="mt-3	" for="categorie">Categorie : </label>
        <select id="categorie" name="categorie">
        	<option value="-1">Toutes</option>
        	<c:forEach  var="categorie" items="${categories}">
        		<option value="${categorie.idCategorie}">${categorie.libelle}</option>
        	</c:forEach>
        </select>
	</div>
	<div class="d-flex align-items-center">
		<button type="submit" class="btn btn-outline-secondary">Rechercher</button>
	</div>
</form>
<div class="container">
	<div class="d-flex flex-wrap justify-content-between mt-4 mb-4">
		<c:forEach  var="enchere" items="${encheres}">
			<div class="border mt-3">
				<div>
					<img src="/images/patate.jpeg">
				</div>
				<div class="p-3">
					<c:if test="${!empty enchere.getArticle().getNomArticle()}">
						<p>${enchere.getArticle().getNomArticle() }</p>
					</c:if>

					<c:if test="${empty enchere.getArticle().getNomArticle()}">
						<p> Aucun titre </p>
					</c:if>

					<c:if test="${enchere.getMontantEnchere() == 0}">
						<p>Prix : ${enchere.getArticle().getPrixInitial()}</p>
					</c:if>
					<c:if test="${enchere.getMontantEnchere() > 0}">
						<p>Prix : ${enchere.getMontantEnchere() }</p>
					</c:if>
					<p>Fin de l'enchère : ${enchere.getArticle().getDateFinEnchere() }</p>
					<p>Vendeur : ${enchere.getUtilisateur().getPseudo() }</p>
				</div>
			</div>
		</c:forEach>
	</div>
</div>
</body>
</html>