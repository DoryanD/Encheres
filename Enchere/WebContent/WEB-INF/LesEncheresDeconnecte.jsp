<%@ page  language="java"
          contentType="text/html; charset=UTF-8"
          pageEncoding="UTF-8"
  %>
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
	    <a href="Connexion" class="nav-link">S'inscrire - Se connecter</a>
</nav>
<div class="jumbotron text-center">
	<h1>Liste des enchères</h1>
</div>
<div class="container">
		<form action="ListeEnchereConnecte" method="POST">
			<div class="d-md-flex d-sm-inline -flex justify-content-md-around">
				<div class="form-group">
					<label for="rechercher">Filtres : </label><br> <input
						class="form-control" id="rechercher" name="nom" type="text"
						placeholder="Nom de l'article">
					<button type="submit" class="btn btn-outline-secondary mt-2">Rechercher</button>
				</div>
				<div class="form-group">
					<label for="categorie">Categorie : </label> <select
						class="form-control" id="categorie" name=categorie>
						<c:forEach var="categorie" items="${listeCategorie}">
							<option value="${categorie.GetId()}">${categorie.libelle}</option>
						</c:forEach>
					</select>
				</div>
				<div id="achatvente" class="d-flex justify-content-between">
					<div class="form-check p-3">
						<input class="form-check-input" type="radio" id="achats"
							name="type" value="achats" checked> <label for="achats">Achats</label>
						<div class="ml-4">
							<div>
								<input class="form-check-input" type="radio"
									id="encheresouvertes" name="encheres" value="encheresouvertes"
									checked> <label for="encheresouvertes">enchères
									ouvertes</label>
							</div>
							<div>
								<input class="form-check-input" type="radio"
									id="encheresencours" name="encheres" value="encheresencours">
								<label for="encheresencours">enchères en cours</label>
							</div>
							<div>
								<input class="form-check-input" type="radio"
									id="encheresremportees" name="encheres"
									value="encheresremportees"> <label
									for="encheresremportees">Mes Ventes</label>
							</div>
						</div>
					</div>
					<div class="form-check p-3">
						<input class="form-check-input" type="radio" id="ventes"
							name="type" value="vente"> <label for="ventes">Mes
							Ventes</label>
						<div id="ventesradio" class="ml-4">
							<div>
								<input class="form-check-input" type="radio" id="ventesencours"
									name="ventes" value="ventesencours" disabled> <label
									for="ventesencours">mes ventes en cours</label>
							</div>
							<div>
								<input class="form-check-input" type="radio"
									id="ventesnondebutees" name="ventes" value="ventesnondebutees"
									disabled> <label for="ventesnondebutees">ventes
									non débutées</label>
							</div>
							<div>
								<input class="form-check-input" type="radio"
									id="ventesterminees" name="ventes" value="ventesterminees"
									disabled> <label for="ventesterminees">ventes
									terminées</label>
							</div>
						</div>
					</div>
				</div>
			</div>
		</form>
		<div class="container">
			<div class="d-flex flex-wrap justify-content-around mt-4 mb-4">
				<c:forEach var="article" items="${listeArticlesNonFiltre}">
					<div class="border mt-3 p-3">
						<div class="mt-3">
								<a href="/Enchere/AffichageEnchere?idArticle=${article.GetId()}"> ${article.getNom_article()}</a>						
							
							<c:if test="${article.getPrix_vente() > 0}">
								<p>Enchère Actuel : ${article.getPrix_vente() }</p>
							</c:if>
							<p>Fin de l'enchère :
								${article.getDate_fin_encheres()}</p>
							<p> Vendeur : <a href="/Enchere/PageAffichageInfosUtilisateur?idVendeur=${article.getNo_utilisateur()}">${UtilisateursManager.getInstance().get(article.getNo_utilisateur()).getPseudo()}</a>
							</p>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript" src="assets/js/listeEnchereConnecte.js"></script>
</html>