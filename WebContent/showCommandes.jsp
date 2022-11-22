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

<title>Commandes</title>
</head>
<body>
	<div class="limiter">
		<div class="container-login100">
			<span class="login100-form-title" style="font-size: 40px; color: white;">Commandes</span>
			<table class="table table-hover" style="background-color: white;">
				<thead>
					<tr>
						<th scope="col">Id</th>
						<th scope="col">Date</th>
						<th scope="col">Utilisateur</th>
						<c:if test="${ sessionScope.user.getTypeUtil() != 1 }">
							<th scope="col">Delete</th>
							<th scope="col">Update</th>
						</c:if>
						<th scope="col">Détail</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${ listCmd }" var="cmd">
						<tr>
							<th scope="row">${ cmd.getIdCmd() }</th>
							<td>${ cmd.getDateCmd() }</td>
							<td>${ cmd.getIdUtil() }</td>
							<c:if test="${ sessionScope.user.getTypeUtil() != 1 }">
								<td><a href="DeleteServlet?id=${ cmd.getIdCmd() }">
										delete </a></td>
								<td><a href="ShowListServlet?act=11&id=${ cmd.getIdCmd() }">
										update </a></td>
							</c:if>
								<td><a href="ShowListServlet?act=4&id=${ cmd.getIdCmd() }">
										détail </a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<c:if test="${ sessionScope.user.getTypeUtil() != 1 }">
				<a href="CreateServlet?act=1" style="color: white; font-size: 20px;"> Nouvelle Commande </a> <br/>
			</c:if>
			<div>
				<a class="logout" href="home.jsp">Home</a>
			</div>
		</div>
	</div>
	<%
		session.setAttribute("page", "cmd");
	%>
</body>
</html>