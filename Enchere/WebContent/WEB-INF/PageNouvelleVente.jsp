<%@ page  language="java"
          contentType="text/html; charset=UTF-8"
          pageEncoding="UTF-8"
  %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Vendre article</title>

<!--Bootsrap 4 CDN-->
<link rel="stylesheet" href="Assets/bootstrap/css/bootstrap.min.css">
<script src="Assets/boostrap/js/bootstrap.min.js"></script>

</head>
<body>
	<div class="jumbotron">
		<div class="container">
			<a href="Accueil" class="h1">ENI - Enchères</a>
		</div>
	</div>
	<div class="container">
		<form action="/Enchere/NouvelleVente" method="POST">
			<div class="mb-5">
				<h2>Article</h2>
				<hr>
				<div class="form-group">
					<label for="nomArticle">Nom de l'article</label> <input type="text"
						class="form-control" id="nomArticle" name="nomArticle"
						placeholder="Nom de l'article">
				</div>
				<div class="form-group">
					<label for="descriptionArticle">Description</label>
					<textarea class="form-control" name="description" id="description"
						placeholder="Description de votre article" rows="3"></textarea>
				</div>
				<div class="form-group">
					<label for="categorie">Categorie</label>
					 <select
						class="form-control" id="categorie" name=categorie>
						<c:forEach var="categorie" items="${listeCategorie}">
							<option value="${categorie.GetId()}">${categorie.libelle}</option>
						</c:forEach>
					</select>
				</div>
			</div>
			<hr>
			<h2>Enchere</h2>
			<hr>

			<div class="form-group">
				<label for="prix">Prix de l'enchere</label> <input type="number"
					id="prix" class="form-control" name="prix"
					placeholder="Prix initial de la vente">
			</div>
			<div class="d-flex justify-content-around">
				<div class="form-group">
					<label for="dateDebut">Date de début de l'enchere</label> <input
						type="date" id="debEnch" class="form-control" name="debEnch"
						placeholder="Prix initial de la vente">
				</div>
				<div class="form-group">
					<label for="dateFinEnchere">Date de fin de l'enchere</label> <input
						type="date" id="finEnch" class="form-control" name="finEnch">
				</div>
			</div>
			<hr>
			<h2>Retrait</h2>
			<hr>
			<div class="d-flex justify-content-between">
				<div class="form-group">
					<label for="retraitRue">Rue du retrait</label> <input type="text"
						id="rueRetrait" class="form-control" name="rueRetrait"
						value="<%=request.getSession().getAttribute("Rue") %>"
						placeholder="Rue du retrait">
				</div>
				<div class="form-group">
					<label for="retraitCodePostal">Code Postal du retrait</label> <input
						type="text" id="cp" class="form-control" name="cp"
						value="<%=request.getSession().getAttribute("cp") %>"
						placeholder="Code Postal du retrait">
				</div>
				<div class="form-group">
					<label for="retraitVille">Ville du retrait</label> <input
						type="text" id="ville" class="form-control" name="ville"
						value="<%=request.getSession().getAttribute("ville") %>">
				</div>
			</div>
			<input type="hidden" name="formSubmit"> <input type="submit"
				role="button" class="btn btn-primary">
		</form>
	</div>

</body>
</html>
