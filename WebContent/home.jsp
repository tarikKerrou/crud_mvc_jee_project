<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" />

<!--===============================================================================================-->
<link rel="icon" type="image/png" href="images/icons/favicon.ico" />
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="vendor/select2/select2.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css" href="css/util.css">
<link rel="stylesheet" type="text/css" href="css/main.css">
<link rel="stylesheet" type="text/css" href="css/style.css">
<!--===============================================================================================-->

<title>Accueil</title>
</head>
<body>
	<div class="limiter">
		<div class="container-login100">
			<p class="title"> Hello ${ sessionScope.user.getNomUtil() } !</>
			<div>
				<a class="logout" href="AuthentificationServlet?act=0"> LogOut </a>
			</div>
			<div class="container">
				<br />
				<div class="element" style="width: 300px;">
					<div>
						<img width="100px" height="100px" src="images/login.png" alt="IMG">
					</div>
					<a style="font-size: 20px;" href="updateAccount.jsp"> Mon compte </a> <br />
			    </div>
			    <div class="element" style="width: 300px;">
					<div>
						<img width="100px" height="100px" src="images/cmd.png" alt="IMG">
					</div>
					<a style="font-size: 20px;" href="ShowListServlet?act=1"> Commandes </a> <br />
				</div>
				<div class="element" style="width: 300px;">
					<div>
						<img width="100px" height="100px" src="images/prod.png" alt="IMG">
					</div>
					<a style="font-size: 20px;" href="ShowListServlet?act=2"> Produits </a> <br />
				</div>
				<c:if test="${ sessionScope.user.getTypeUtil() == 1 }">
					<div class="element" style="width: 300px;">
						<div>
							<img width="100px" height="100px" src="images/users.png" alt="IMG">
						</div>
						<a style="font-size: 20px;" href="ShowListServlet?act=3"> Utilisateurs </a> <br />
					</div>
				</c:if>
				
				
			</div>
		</div>
	</div>
	
</body>
</html>