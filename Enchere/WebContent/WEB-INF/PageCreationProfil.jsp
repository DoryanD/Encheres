<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<!--Bootsrap 4 CDN-->
<link rel="stylesheet" href="Assets/bootstrap/css/bootstrap.min.css">
<script src="Assets/boostrap/js/bootstrap.min.js"></script>

</head>
<body>
	<a href="Accueil" class="h3">ENI - Enchères</a>

	<form action="ServletCreationCompte" method="post">
		<h2>Mon profil</h2>

		<div>
			<div>
				<label>Pseudo :</label>
				<input type="text" name="pseudo" id="pseudo">
			</div>

			<div>
				<label>Nom :</label>
				<input type="text" name="nom" id="nom">
			</div>
		</div>

		<br>

		<div>
			<div>
				<label>Prénom :</label>
				<input type="text" name="prenom" id="prenom">
			</div>

			<div>
				<label>Email :</label>
				<input type="email" name="Email" id="Email">
			</div>
		</div>

		<br>

		<div>
			<div>
				<label>Téléphone :</label>
				<input type="text" name="tel" id="tel">
			</div>

			<div>
				<label>Rue :</label>
				<input type="text" name="Rue" id="Rue">
			</div>
		</div>
		
		<br>

		<div>
			<div>
				<label>Code Postal :</label>
				<input type="text" name="cp" id="cp">
			</div>

			<div>
				<label>Ville :</label>
				<input type="text" name="ville" id="ville">
			</div>
		</div>

		<br>

		<div>
			<div>
				<label>Mot de passe :</label>
				<input type="password" placeholder="••••••••••••" name="mdp" id="mdp">
			</div>
			
			<div>
				<label>Confirmation :</label>
				<input type="password"placeholder="••••••••••••" name="mdpconfirm" id="mdpconfirm">
			</div>
		</div>
		
		<br>
		
		<div>
			<button class="btn btn-primary" type="submit">Créer</button>
			<button type="reset" class="btn btn-success">Annuler</button>
		</div>
	</form>
</body>
</html>