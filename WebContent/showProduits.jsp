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

<title>Produits</title>
</head>
<body>
<%--  <img src="data:image/jpg;base64,${img}" width="240" height="300"/> --%>
	<div class="limiter">
		<div class="container-login100">
			<span class="login100-form-title" style="font-size: 40px; color: white;">Produits</span>
			<table class="table table-hover" style="background-color: white;">
				<thead>
					<tr>
						<th scope="col">Id</th>
						<th scope="col">Nom</th>
						<th scope="col">Prix</th>
						<c:if test="${ sessionScope.user.getTypeUtil() == 1 }">
							<th scope="col">Delete</th>
							<th scope="col">Update</th>
						</c:if>
					</tr>
				<tbody>
					<c:forEach items="${ listProd }" var="prod">
						<tr>
							<th scope="row">${ prod.getIdProd() }</th>
							<td>${ prod.getNomProd() }</td>
							<td>${ prod.getPrixProd() }</td>
							<c:if test="${ sessionScope.user.getTypeUtil() == 1 }">
								<td><a href="DeleteServlet?id=${ prod.getIdProd() }">
										delete </a></td>
								<td><a href="ShowListServlet?act=22&id=${ prod.getIdProd() }">
										update </a></td>
							</c:if>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			
			<c:if test="${ sessionScope.user.getTypeUtil() == 1 }">
				<a href="createProduit.jsp" style="color: white; font-size: 20px;"> Nouveau Produit </a> <br />
			</c:if>
			<div>
				<a class="logout" href="home.jsp">Home</a>
			</div>
		</div>
	</div>
	<%
		session.setAttribute("page", "prod");
	%>
</body>
</html>