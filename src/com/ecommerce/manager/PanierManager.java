package com.ecommerce.manager;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.ecommerce.dao.HistoriqueClientDao;
import com.ecommerce.dao.PanierDao;
import com.ecommerce.model.Client;
import com.ecommerce.model.HistoriqueClient;
import com.ecommerce.model.Panier;
import com.ecommerce.model.Produit;

@Component
@Transactional
public class PanierManager {

	@Autowired
	HistoriqueClientDao historiqueDao;
	@Autowired
	PanierDao panierDao;

	/**
	 * Calcul le cout total d'un panier
	 * @param objPanier
	 * @return total
	 * @author morgan nouët
	 */
	// Méthode Calculer le total d'un panier
	public float coutTotal(Panier objPanier) {
		float total = 0;
		for (Produit p : objPanier.getProduits()) {
			total += p.getPrix();
		}
		return total;
	}

	/**
	 * Méthode d'ajout d'un produit à un panier
	 * 
	 * @param objProduit
	 * @param objPanier
	 * @author morgan nouët
	 *
	 */
	// Méthode ajouter produit
	public void ajouterProduit(Produit objProduit, Panier objPanier) {
		objPanier.getProduits().add(objProduit);
	}

	/**
	 * Méthode de suppression d'un produit à un panier
	 * 
	 * @param objProduit
	 * @param objPanier
	 * @author morgan nouët
	 * 
	 */
	// Méthode supprimer produit
	public void supprimerProduit(Produit objProduit, Panier objPanier) {
		objPanier.getProduits().remove(objProduit);
	}

	// Méthode valider panier
	public void validerPanier(Panier panier, Client client) throws Exception {
		HistoriqueClient historique = new HistoriqueClient();

		// je décrémente les stock des produits contenu dans panier
		for (Produit p : panier.getProduits()) {
			if (p.getStock() == 0)
				throw new Exception();
			p.setStock(p.getStock() - 1);
		}

		// puis j'envoi mon panier à l'historique
		Panier copiePanier = new Panier();
		copiePanier.setProduits(new ArrayList<Produit>(panier.getProduits()));
		panierDao.save(copiePanier);
		historique.setPanier(copiePanier);
		// ainsi que la date à la quelle le panier à été validé
		historique.setDate(new Date());
		// et le client à qui appartient le panier
		historique.setClient(client);
		historiqueDao.save(historique);
		
		// puis je remet mon panier vide
		panier.getProduits().clear();
	}

}
