<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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
<title>Créer Un Compte</title>
</head>
<body>
	<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100">
				<div class="login100-pic js-tilt" data-tilt>
					<img src="images/register.png" alt="IMG">
				</div>

				<form action="InscriptionServlet" method="post"
					class="login100-form validate-form">
					<span class="login100-form-title"> Créer un compte </span>
					<!-- Nom -->
					<div class="wrap-input100 validate-input"
						data-validate="Valid name is required">
						<input class="input100" type="text" name="nom" placeholder="Nom"
							value="<c:out value="${ user.getNomUtil() }"/>"> <span
							class="focus-input100"></span> <span class="symbol-input100">
							<i class="fa fa-user" aria-hidden="true"></i>
						</span>
					</div>
					<!-- Email -->
					<c:if test="${ !empty error }">
						<c:out value="${ error }"></c:out>
					</c:if>
					<div class="wrap-input100 validate-input"
						data-validate="Valid email is required: ex@abc.xyz">
						<input class="input100" type="text" name="email"
							placeholder="Email"
							value="<c:out value="${ user.getEmailUtil() }"/>"> <span
							class="focus-input100"></span> <span class="symbol-input100">
							<i class="fa fa-envelope" aria-hidden="true"></i>
						</span>
					</div>
					<!-- Adresse -->
					<div class="wrap-input100 validate-input"
						data-validate="Valid adresse is required">
						<input class="input100" type="text" name="adresse"
							placeholder="Adresse"
							value="<c:out value="${ user.getAdresseUtil() }"/>"> <span
							class="focus-input100"></span> <span class="symbol-input100">
							<i class="fa fa-map" aria-hidden="true"></i>
						</span>
					</div>
					<!-- Password -->
					<div class="wrap-input100 validate-input"
						data-validate="Password is required">
						<input class="input100" type="password" name="password"
							placeholder="Password"> <span class="focus-input100"></span>
						<span class="symbol-input100"> <i class="fa fa-lock"
							aria-hidden="true"></i>
						</span>
					</div>
					<!-- Bouton -->
					<div class="container-login100-form-btn">
						<button type="submit" class="login100-form-btn">Valider</button>
					</div>
					
					<div style="text-align: center; margin-top: 20px;">
						<a href="index.jsp" style="font-size: 15px;">Vous avez déja un compte ?</a>
					</div>
					
<!-- 					<div class="text-center p-t-136"> -->
<!-- 						<a class="txt2" href="index.jsp"> Vous avez déja un compte <i -->
<!-- 							class="fa fa-long-arrow-right m-l-5" aria-hidden="true"></i> -->
<!-- 						</a> -->
<!-- 					</div> -->
				</form>
			</div>
		</div>
	</div>




	<!--===============================================================================================-->
	<script src="vendor/jquery/jquery-3.2.1.min.js"></script>
	<!--===============================================================================================-->
	<script src="vendor/bootstrap/js/popper.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.min.js"></script>
	<!--===============================================================================================-->
	<script src="vendor/select2/select2.min.js"></script>
	<!--===============================================================================================-->
	<script src="vendor/tilt/tilt.jquery.min.js"></script>
	<script>
		$('.js-tilt').tilt({
			scale : 1.1
		})
	</script>
	<!--===============================================================================================-->
	<script src="js/main.js"></script>
</body>
</html>