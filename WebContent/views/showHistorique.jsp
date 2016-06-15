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
	<h2 style="text-align:center" class="text-info">Historique des anciennes commandes</h2>
	
		<c:forEach var="commande" items="${listeHistoriqueClientDTO}">
			<br/>
			<br/>
		<table class="table table-bordered">
		<tr class="active">
			<td >Date de la commande : ${commande.date}</td>
		</tr>
		</table >
		<table class="table table-bordered">
			<tr>
				<td>Modèle</td>
				<td>Marque</td>
				<td>Couleur</td>
				<td>Prix</td>
				</tr>
				<c:forEach var="produit" items="${commande.panier.produits}">
				<tr>
					<td>${produit.nom}</td>
					<td>${produit.marque}</td>
					<td>${produit.couleur}</td>
					<td>${produit.prix}€</td>
			</tr>
</c:forEach>
				<tr class="info">
				<td colspan="4">Cout total :${commande.panier.coutTotal}€ </td>
			</tr>
			</table>
		</c:forEach>
		<a href='<c:url value = "/"/>'><input type="button" class="btn btn-info" value="Retour" /></a>
	</div>
</body>
</html>