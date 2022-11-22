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

<title>Ligne De Commande</title>
</head>
<body>
	<div class="limiter">
		<div class="container-login100">
			<span class="login100-form-title" style="font-size: 40px; color: white;">Lignes de la commande nº ${ sessionScope.idCmd }</span>
			<table class="table table-hover" style="background-color: white;">
				<thead>
					<tr>
						<th scope="col">Id</th>
						<th scope="col">Quantité</th>
						<th scope="col">Id Commande</th>
						<th scope="col">Id Produit</th>
						<c:if test="${ sessionScope.user.getTypeUtil() != 1 }">
							<th scope="col">Delete</th>
							<th scope="col">Update</th>
						</c:if>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${ listLigCmd }" var="lcmd">
						<tr>
							<th scope="row">${ lcmd.getIdLigneCmd() }</th>
							<td>${ lcmd.getQuantite() }</td>
							<td>${ lcmd.getIdCmd() }</td>
							<td>${ lcmd.getIdProd() }</td>
							<c:if test="${ sessionScope.user.getTypeUtil() != 1 }">
								<td><a href="DeleteServlet?id=${ lcmd.getIdLigneCmd() }"> delete
								</a></td>
								<td><a href="ShowListServlet?act=44&id=${ lcmd.getIdLigneCmd() }"> update
								</a></td>
							</c:if>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<div>
				<c:if test="${ sessionScope.user.getTypeUtil() != 1 }">
					<a href="ShowListServlet?act=444" style="color: white; font-size: 20px;"> Nouvelle Ligne Commande  </a> <br/>
				</c:if>
				
				<div style="text-align: center; margin-top: 20px;">
					<a href="ShowListServlet?act=1" style="color: white; font-size: 20px;">Retour</a>
				</div>
			</div>
			<div>
				<a class="logout" href="home.jsp">Home</a>
			</div>
		</div>
	</div>
	
	<%
		session.setAttribute("page", "lcmd");
	%>
</body>
</html>