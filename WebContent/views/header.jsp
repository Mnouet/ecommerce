<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div>
		
		<nav class="navbar navbar-default"">
		<div class="container-fluid">
		<div class="navbar-header">
		<c:if test="${empty sessionScope['scopedTarget.clientSession'].identifiant}">
		<form class="navbar-form navbar-left" name="connexion" action='<c:url value ="/login/connexion" />' method="POST">
		<table>
			<tr>
				<td>Email : <input type="text" name="email" /></td>
				<td>Mot de passe : <input type="password" name="mdp" /></td>
				<td><input type="submit" name="Connexion" value="Connexion" /></td>
				<td><a href='<c:url value="/enregistrement"/>'>Inscris toi !</a></td>
				<c:if test="${validationConnexion==0}" >
				<td>Mauvais login ou mot de passe !</td>
				</c:if>
			</tr>
		</table>
		</form>
		</c:if>
		<c:if test="${not empty sessionScope['scopedTarget.clientSession'].identifiant}">
		<form class="navbar-form navbar-left" >
		<table>
			<tr>
				<td class="navbar-brand">Compte de :${sessionScope['scopedTarget.clientSession'].prenom} ${sessionScope['scopedTarget.clientSession'].nom} </td>
				<td class="navbar-brand"><a href='<c:url value="/modifierClient"/>'>|Modifier vos informations</td>
				<td class="navbar-brand"><a href='<c:url value="/historiqueCommande"/>'>|Voir l'historique de vos commandes</td>
				<td class="navbar-brand"><a href='<c:url value="/login/deconnexion"/>'>|Déconnexion</a></td>
			</tr>
		</table>
		</form>
		</c:if>
		</div>
		</div>
		</nav>
		
  
       
		

</div>