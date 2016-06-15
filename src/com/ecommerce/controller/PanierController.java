package com.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ecommerce.dao.ClientDao;
import com.ecommerce.dao.ProduitDao;
import com.ecommerce.manager.PanierManager;
import com.ecommerce.model.Client;
import com.ecommerce.model.ClientSession;
import com.ecommerce.model.Panier;
import com.ecommerce.model.Produit;

@RequestMapping(value = "/panier")
@Transactional
@Controller
public class PanierController {

	@Autowired
	private Panier panier;

	@Autowired
	private PanierManager panierManager;

	@Autowired
	private ProduitDao produitDao;

	@Autowired
	private ClientDao clientDao;

	@Autowired
	private ClientSession clientSession;

	@RequestMapping(value = "/addProduit/{id}")
	public String ajouterProduit(@PathVariable("id") int idProduit, Model model) {
		Produit produit = produitDao.find(idProduit);
		int messageUtilisateur;
		if (produit != null) {
			panierManager.ajouterProduit(produit, panier);
			messageUtilisateur = 1;
		} else {
			messageUtilisateur = 0;
		}
		model.addAttribute("messageUtilisateur", messageUtilisateur);
		model.addAttribute("produit", produit);
		return "showProduit";
	}

	@RequestMapping(value = "/enleverProduit/{id}")
	public String enleverProduit(@PathVariable("id") int idProduit, Model model) {
		int messageUtilisateur;
		Produit produit = produitDao.find(idProduit);
		
		if (produit != null) {
			panierManager.supprimerProduit(produit, panier);
			messageUtilisateur = 1;
		} else {
			messageUtilisateur = 0;
		}
		
		
		model.addAttribute("messageUtilisateur", messageUtilisateur);
		return "showPanier";
	}

	@RequestMapping(value = "/showPanier")
	public String showPanier(Model model) {
		float coutTotal = panierManager.coutTotal(panier);
		model.addAttribute("coutTotal", coutTotal);
		return "showPanier";
	}

	@RequestMapping(value = "/validationPanier")
	public String validerPanier(Model model) {

		Client client = clientDao.find(clientSession.getIdentifiant());
		try {
			panierManager.validerPanier(panier, client);
			model.addAttribute("etatDeLaTransaction", 1);

		} catch (Exception e) {
			model.addAttribute("etatDeLaTransaction", 0);

			TransactionAspectSupport.currentTransactionStatus()
					.setRollbackOnly();
			System.out.println(e);

		}
		return "showPanier";
	}
}
