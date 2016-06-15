<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Détail du produit</title>
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
	<div class="row">
	<div style="text-align:center" class="produit produit panel panel-primary  col-md-3 col-md-offset-4">
	<div class="panel-heading ">
	<h3 style="text-align:center">${produit.nom}</h3>
	</div>

		<img
			src='<c:url value="/res/image/produit/${produit.identifiant}.jpeg"/>'
			alt="image de ${produit.nom}" />
		<p>modèle: ${produit.nom}</p>
		<p>marque:${produit.marque}</p>
		<p>couleur:${produit.couleur}</p>
		<p>stock:${produit.stock}</p>
		<p>prix:${produit.prix}€</p>
		</div>
		</div>
		<div class="row" >
		<div class="col-md-offset-5">
		<a href='<c:url value = "/"/>'><input class="btn btn-info" type="button" value="Retour" /></a>
		<a
			href='<c:url value = "/panier/addProduit/${produit.identifiant}"/>'><input
			class="btn btn-success" type="button" value="Ajouter au panier" /></a>
			</div>
			<c:if test="${messageUtilisateur==0 }">
			<div class="row">
		<div class="col-md-3 col-md-offset-4">
		<p class="bg-danger" id="messageErreur">L'ajout du produit à votre article n'a pas pus se faire</p>
		</div>
		</div>
		</c:if>
		
		<c:if test="${messageUtilisateur==1 }">
		<div class="row">
		<div class="col-md-3 col-md-offset-4">
		<p id="messageValidation" class="bg-success">Le produit a été ajouté à votre panier</p>
		</div>
		</div>
		
		</c:if>
		</div>
		
	
</div>
</body>
</html>