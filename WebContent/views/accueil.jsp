<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Site e-commerce</title>
<link rel="stylesheet" type="text/css"
	href='<c:url value="/res/css/design.css"/>'>
<link rel="stylesheet" type="text/css"
	href='<c:url value="/res/css/bootstrap/css/bootstrap.min.css"/>'>
<link rel="stylesheet" type="text/css"
	href='<c:url value="/res/css/bootstrap/css/bootstrap-theme.min.css"/>'>
</head>
<body>
<div class="container-fluid">
	<%@include file="/views/header.jsp"%>
	
		<%@include file="/views/menu.jsp"%>
		<div class=" col-md-10" id="bodyProduit">
		
			<c:forEach var="produit" items="${produits}">
			<div class="col-md-1">
			</div>
				<div style="text-align:center" class="produit panel panel-primary  col-md-3">
					<div class="panel-heading ">
						<h3 class="panel-title">${produit.nom}</h3>
					</div>
					<div>
					<a href="<c:url value='/showProduit/${produit.identifiant}'/>"><img
						src='<c:url value="/res/image/produit/${produit.identifiant}.jpeg"/>'
						alt="image de ${produit.nom}" /></a>
					<p>modèle: ${produit.nom}</p>
					<p>marque:${produit.marque}</p>
					<p>prix:${produit.prix}€</p>
					</div>
					
				</div>
				
			</c:forEach>
		</div>
	

</div>
</body>
</html>