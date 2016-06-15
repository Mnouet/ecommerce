<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Projet e-commerce / Enregistrement Validé</title>
	<link rel="stylesheet" type="text/css"
	href='<c:url value="/res/css/bootstrap/css/bootstrap.min.css"/>'>
	<link rel="stylesheet" type="text/css"
	href='<c:url value="/res/css/bootstrap/css/bootstrap-theme.min.css"/>'>
</head>
<script type='text/javascript'>
setTimeout('window.location.replace("/j2ee-e-commerce")',4000);
</script>
<body>
<div class="container-fluid">
 <h2 style="text-align:center" class="text-info">Récapitulatif des informations</h2>
 <div class="row">
 <div class="col-md-8 col-md-offset-2">
   <table class="table table-bordered">
   	  <tr class="active">
        <td>Nom :</td>
        <td>Prénom :</td>
        <td>Adresse :</td>
         <td>Email :</td>
        
      </tr>
      <tr>
        
        <td>${client.nom}</td>
        <td>${client.prenom}</td>
        <td>${client.adresse}</td>
        <td>${client.email}</td>
      </tr>
</table> 
</div>
</div>
<div class="row">
<div class="col-md-5 col-md-offset-3">
<p>Vous allez être redirigé automatiquement.... sinon cliquez sur le bouton : <a href='<c:url value = "/"/>'><input class="btn btn-info" type="button" value="Retour" /></a></p>
</div>
</div>
</div>
</body>
</html>

