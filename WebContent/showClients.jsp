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

<title>Utilisateur</title>
</head>

<body>
	<div class="limiter">
		<div class="container-login100">
			<span class="login100-form-title" style="font-size: 40px; color: white;">Utilisateurs</span>
			<table class="table table-hover" style="background-color: white;">
				<thead>
					<tr>
						<th scope="col">Id</th>
						<th scope="col">Nom</th>
						<th scope="col">Adresse</th>
						<th scope="col">E-mail</th>
						<th scope="col">Delete</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${ listUtil }" var="util">
						<tr>
							<th scope="row">${ util.getIdUtil() }</th>
							<td>${ util.getNomUtil() }</td>
							<td>${ util.getAdresseUtil() }</td>
							<td>${ util.getEmailUtil() }</td>
							<td><a href="DeleteServlet?id=${ util.getIdUtil() }">
										delete </a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<div>
				<a class="logout" href="home.jsp">Home</a>
			</div>
		</div>
	</div>
	<%
		session.setAttribute("page", "util");
	%>
</body>
</html>