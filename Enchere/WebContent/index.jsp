<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Login Page</title>
<!--Made with love by Mutiullah Samim -->

<!--Bootsrap 4 CDN-->
<link rel="stylesheet" href="Assets/bootstrap/css/bootstrap.min.css">

<!--Fontawesome CDN-->
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.3.1/css/all.css"
	integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU"
	crossorigin="anonymous">

<!--Custom styles
	<link rel="stylesheet" href="Assets/css/seConnecter.css">
	-->
</head>
<body>

	<!--  Récupération du cookie rememberLogin s'il existe -->
	<%
	Cookie cookie = null;
	Cookie[] cookies = request.getCookies();
	String cookieSearchName = "rememberLogin";
	String cookieSearchValue = "";
	
	if (cookies != null) {
		for (int i = 0; i < cookies.length; i++) {
			cookie = cookies[i];
			if(cookie.getName().equals(cookieSearchName)){
				cookieSearchValue = cookie.getValue();
			}
		}
	}
	%>
	
	<div class="container">
		<div class="d-flex justify-content-center" style="margin-top:200px;">

			<div class="card">
				<div class="card-header">
					<h3>ENI-Enchères</h3>
				</div>
				<div class="card-body">
					<form action="seConnecter" method="post">
						<div class="input-group form-group">
							<div class="input-group-prepend">
								<span class="input-group-text"><i class="fas fa-user"></i></span>
							</div>
							<input type="text" class="form-control" placeholder="username" required name ="identifiant" id="identifiant" value="<%=cookieSearchValue%>">
						</div>
						<div class="input-group form-group">
							<div class="input-group-prepend">
								<span class="input-group-text"><i class="fas fa-key"></i></span>
							</div>
							<input type="password" class="form-control"
								placeholder="password" required name="motdepasse" id="motdepasse">
						</div>
						<div class="row align-items-center remember">
							<input type="checkbox" name="remember" id="remember">Remember Me
						</div>
						
						<div class="form-group">
							<input type="submit" value="Login" class="btn float-right">
						</div>
						
					</form>
				</div>
				<div class="card-footer">
					<div class="d-flex justify-content-center links">
						Don't have an account?<a href="#">Sign Up</a>
					</div>
					<div class="d-flex justify-content-center">
						<a href="#">Forgot your password?</a>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>