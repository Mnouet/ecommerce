<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<div class="col-md-2" id="menuCategorie">
	<table class="table table-bordered">
		<tr>
			<td class="active" style="text-align:center">Rechercher par cat&eacute;gorie</td>
		</tr>
		<tr>
			<td><a href='<c:url value="/"/>'>Tous les produits</a></td>
		</tr>
		<c:forEach var="categorie" items="${categories}">
			<tr>
				<td><a
					href='<c:url value="/categorie/${categorie.identifiant}"/>'>${categorie.nom}</a></td>
			</tr>
		</c:forEach>
		<tr>
			<td class="active"> Votre panier:</td>
		</tr>
		<tr>
			<td> Nombre d'articles:${fn:length(sessionScope['scopedTarget.panier'].produits)}
			<br/>
			Cout total: ${coutTotalPanier}&euro;</td>
		</tr>
		<tr>
			<td class="info"><a href='<c:url value="/panier/showPanier"/>'>Voir le d&eacute;tail du panier</a></td>
		</tr>
	</table>
</div>