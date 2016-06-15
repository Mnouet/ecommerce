<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css"
	href='<c:url value="/res/css/design.css"/>'>
		<link rel="stylesheet" type="text/css"
	href='<c:url value="/res/css/bootstrap/css/bootstrap.min.css"/>'>
	<link rel="stylesheet" type="text/css"
	href='<c:url value="/res/css/bootstrap/css/bootstrap-theme.min.css"/>'>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Détail du panier</title>
</head>
<body>
<div class="container-fluid">

	<%@include file="/views/header.jsp"%>
	<h1 style="text-align:center" class="text-info">Détail du panier</h1>
	<br/>
	<br/>
	<c:if
		test="${fn:length(sessionScope['scopedTarget.panier'].produits)==0}">
		<p style="text-align:center">Votre panier est actuellement vide</p>
	</c:if>
	<c:if
		test="${fn:length(sessionScope['scopedTarget.panier'].produits)>0}">
		<table class="table table-bordered">
			<tr class="active">
				<td>Marque</td>
				<td>Modèle</td>
				<td>Prix</td>
				<td>Couleur</td>
				<td>Supprimer le produit</td>
			</tr>
			<c:forEach var="produit"
				items="${sessionScope['scopedTarget.panier'].produits}">
				<tr>
					<td>${produit.nom}</td>
					<td>${produit.marque}</td>
					<td>${produit.prix}€</td>
					<td>${produit.couleur}</td>
					<td><a
						href='<c:url value="/panier/enleverProduit/${produit.identifiant}"/>'>Supprimer</a></td>
				</tr>
			</c:forEach>
			<tr>
				<td class="info" colspan="5">Cout total : ${coutTotal}€</td>
			</tr>
		</table>
	</c:if>
	<c:if test="${messageUtilisateur==0 }">
		<p class="bg-danger">La suppresion du produit n'a pas pus se
			faire</p>
	</c:if>
	<c:if test="${messageUtilisateur==1 }">
		<p class="bg-success">Le produit à bien été supprimer</p>
	</c:if>
	<c:if test="${empty sessionScope['scopedTarget.clientSession'].identifiant}">
	<p class="bg-danger"> Attention, vous ne pourrez pas valider votre commande si vous n'êtes pas connecté/inscris !</p><br>
	</c:if>
	<div style="text-align:center">
	<a href='<c:url value = "/"/>'><input type="button" class="btn btn-info" value="Retour" /></a>
	<c:if
		test="${fn:length(sessionScope['scopedTarget.panier'].produits)>0}">
		<c:if test="${not empty sessionScope['scopedTarget.clientSession'].identifiant}">
	<a href='<c:url value="/panier/validationPanier"/>'><input type="button" class="btn btn-success" value="Valider commande" /></a>
	</c:if>
	</c:if>
	</div>
	<c:if
		test="${etatDeLaTransaction==1}">
	<p class="bg-success">Votre commande à bien été validé</p>
	</c:if>
	<c:if
		test="${etatDeLaTransaction==0}">
	<p class="bg-danger">Votre commande n'a pas pus être validé !</p>
	</c:if>
	</div>
</body>
</html>