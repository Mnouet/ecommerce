<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Projet e-commerce / Modifier</title>
<link rel="stylesheet" type="text/css"
	href='<c:url value="/res/css/bootstrap/css/bootstrap.min.css"/>'>
	<link rel="stylesheet" type="text/css"
	href='<c:url value="/res/css/bootstrap/css/bootstrap-theme.min.css"/>'>
</head>
<body>
<div class="container-fluid">

<form  name="modifierClient" action='<c:url value ="/modifierClient" />' method="post" > 
<div class="col-md-6 col-md-offset-3 panel panel-primary">               
       <div class="panel-heading ">
       <h3 style="text-align:center">Espace Client / Modifier mes informations</h3>
       </div>
        <div class="panel-body">
        <p >Nom : <input class="form-control" type="text" name="nom" value ="${sessionScope['scopedTarget.clientSession'].prenom}"/></p>
        <p >Prénom : <input class="form-control" type="text" name="prenom" value ="${sessionScope['scopedTarget.clientSession'].nom}" /></p>
        <p >Email : <input class="form-control" type="text" name="email" value ="${sessionScope['scopedTarget.clientSession'].email}" /></p>
        <p >Adresse complete : <input class="form-control" type="text" name="adresse" value ="${sessionScope['scopedTarget.clientSession'].adresse}"/></p>
        <p >Mot de passe : <input class="form-control" type="password" name="mdp" /></p> 
        <p >Confirmation : <input class="form-control" type="password" name="confirmation" /></p>
        <div style="text-align:center">
        <a href='<c:url value = "/"/>'><input class="btn btn-info" type="button" value="Retour" /></a>               
        <input class="btn btn-success" type="submit" name="Valider" value="Valider"/>
        </div>
        </div>
        
</div>
</form>
<div class="row">
<div class="col-md-6 col-md-offset-3">
  <p class="bg-danger" style="text-align:center;"> ${clientError} </p>
  </div>
  </div>
  </div>
</body>
</html>



