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
<title>Eni enchere - <%=request.getSession().getAttribute("pseudo") %></title>
</head>
<body>
	<div class="jumbotron">
		<div class="container">
			<a href="/Enchere/Accueil" class="h1">ENI - Enchères</a>
		</div>
	</div>
	<form action="ModificationProfil" method="POST">
		<div class="container d-flex justify-content-around pt-5 mt-5 mb-5">
			<div class="w-10">
				<p>Pseudo :</p>
				<p>Prénom :</p>
				<p>Téléphone :</p>
				<p>Code Postal :</p>
				<p>Mot de passe actuel :</p>
				<p>Nouveau mot de passe :</p>
				<p>Crédit :</p>
			</div>
			<div class="text-center d-flex flex-column w-10">
				<input class="mb-2" type="text" name="pseudo"
					value="<%=request.getSession().getAttribute("pseudo") %>"> <input class="mb-2" type="text"
					name="prenom" value="<%=request.getSession().getAttribute("prenom") %>"> <input
					class="mb-2" type="tel" name="tel" value="<%=request.getSession().getAttribute("tel") %>">
				<input class="mb-2" type="text" name="cp"
					value="<%=request.getSession().getAttribute("cp") %>"> <input class="mb-2"
					type="password" name="mdp"> <input class="mb-3"
					type="password" name="newmdp">
				<p class="mb-2">0</p>
			</div>
			<div class="w-10">
				<p>Nom :</p>
				<p>Email :</p>
				<p>Rue :</p>
				<p>Ville :</p>
				<p style="visibility: hidden">espace</p>
				<p>Confirmation :</p>
			</div>
			<div class="text-center d-flex flex-column w-10">
				<input class="mb-2" type="text" name="nom"
					value="<%=request.getSession().getAttribute("nom") %>"> <input class="mb-2"
					type="email" name="Email" value="<%=request.getSession().getAttribute("Email") %>"> <input
					class="mb-2" type="text" name="Rue" value="<%=request.getSession().getAttribute("Rue") %>">
				<input class="mb-2" type="text" name="ville"
					value="<%=request.getSession().getAttribute("ville") %>">
				<p style="visibility: hidden">espace</p>
				<input class="mb-2" type="password" name="mdpconfirm">
				 <input	class="mb-2" type="hidden" name="id"
					value="<%=request.getSession().getAttribute("id") %>">
			</div>
		</div>

		<div class="button d-flex justify-content-center">
			<button class="btn btn-outline-secondary mr-5" type="submit">Enregistrer</button>
			<a class="btn btn-outline-secondary ml-5"
				href="SupprimerCompte?id=<%=request.getSession().getAttribute("id")%>">Supprimer mon compte</a>
		</div>
	</form>
</body>
</html>