<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>ENI-Enchères | Se connecter</title>

<!--Bootsrap 4 CDN-->
<link rel="stylesheet" href="Assets/bootstrap/css/bootstrap.min.css">
<script src="Assets/boostrap/js/bootstrap.min.js"></script>
</head>
<body>
	<% 
		String email = (String)request.getAttribute("email");
		session.setAttribute("email", email);
	%>

	<a href="Accueil" class="h3">ENI - Enchères</a>
	<form action="Connexion" method="post">
		<div class="alert alert-success" role="alert">
  			Email trouvée, saisissez votre nouveau mot de passe
		</div>
		<div class="groupeFormulaire">
			<label>Mot de passe :</label> <input type="password"
				placeholder="••••••••••••" required name="mdp"
				id="mdp">
		</div>
		<br>
		<div class="groupeFormulaire">
			<label>Confirmation :</label> <input type="password"
				placeholder="••••••••••••" required name="mdpconfirm"
				id="mdpconfirm">
		</div>
		<br>
		<div class="groupeFormulaire">
			<button class="btn btn-primary">Confirmer le changement</button>
		</div>
		<br>
		
	</form>
</body>
</html>