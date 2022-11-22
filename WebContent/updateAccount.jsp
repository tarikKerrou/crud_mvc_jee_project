<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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

<title>Mon compte</title>
</head>
<body>
	<div class="limiter">
		<div class="container-login100">
			<div class="">
				<form action="UpdateServlet?id=${ user.getIdUtil() }" method="post" class="login100-form validate-form">
					<span class="login100-form-title" style="font-size: 40px; color: white;"> Mon compte</span>
<!-- 				<!-- Nom -->
					<div class="wrap-input100 validate-input" data-validate="Valid name is required">
						<input class="input100" type="text" name="nomUtil" placeholder="Nom"
							value="<c:out value="${ user.getNomUtil() }"/>"> <span
							class="focus-input100"></span> <span class="symbol-input100">
							<i class="fa fa-user" aria-hidden="true"></i>
						</span>
					</div>
					<!-- E-mail -->
					<div class="wrap-input100 validate-input"
						data-validate="Valid email is required: ex@abc.xyz">
						<input class="input100" type="text" name="emailUtil"
							placeholder="Email"
							value="<c:out value="${ user.getEmailUtil() }"/>"> <span
							class="focus-input100"></span> <span class="symbol-input100">
							<i class="fa fa-envelope" aria-hidden="true"></i>
						</span>
					</div>
					<!-- Adresse -->
					<div class="wrap-input100 validate-input"
						data-validate="Valid adresse is required">
						<input class="input100" type="text" name="adresseUtil"
							placeholder="Adresse"
							value="<c:out value="${ user.getAdresseUtil() }"/>"> <span
							class="focus-input100"></span> <span class="symbol-input100">
							<i class="fa fa-map" aria-hidden="true"></i>
						</span>
					</div>
					<!-- Password -->
					<div class="wrap-input100 validate-input"
						data-validate="Password is required">
						<input class="input100" type="password" name="passwordUtil"
							placeholder="Password"> <span class="focus-input100"></span>
						<span class="symbol-input100"> <i class="fa fa-lock"
							aria-hidden="true"></i>
						</span>
					</div>
					<div class="container-login100-form-btn">
						<input type="submit" name="update" value="Enregistrer" class="login100-form-btn"> <br />
					</div>
					<div style="text-align: center; margin-top: 20px;">
						<a href="home.jsp" style="color: white; font-size: 20px;">Annuler</a>
					</div>
					<div>
						<a class="logout" href="home.jsp">Home</a>
					</div>
				</form>
			</div>
		</div>
	</div>
	<%
		session.setAttribute("page", "util");
	%>
</body>
</html>