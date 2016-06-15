package com.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ecommerce.dao.CategorieDao;
import com.ecommerce.dao.ProduitDao;
import com.ecommerce.manager.PanierManager;
import com.ecommerce.model.Categorie;
import com.ecommerce.model.Panier;
import com.ecommerce.model.Produit;

@Transactional
@Controller
public class ProduitController {
	
	@Autowired
	CategorieDao categorieDao;
	@Autowired
	ProduitDao produitDao;
	@Autowired 
	PanierManager panierManager;
	@Autowired
	private Panier panier;
	
	@RequestMapping("/")
	public String accueil(Model model)
	{
		List<Categorie> categories = categorieDao.findAll();
		
		model.addAttribute("categories", categories);
		
		List<Produit> produits = produitDao.findAll();
		
		model.addAttribute("produits", produits);
		
		float coutTotalPanier = panierManager.coutTotal(panier);
		
		model.addAttribute("coutTotalPanier",coutTotalPanier);
		 
		return "accueil";
	}
	@RequestMapping("/categorie/{id}")
	public String filtrerProduit(Model model,@PathVariable("id") int identifiantCategorie)
	{
        List<Categorie> categories = categorieDao.findAll();
		
		model.addAttribute("categories", categories);
		
		List<Produit> produits = produitDao.findProduitParCategorie(identifiantCategorie);
		
		model.addAttribute("produits", produits);
		
		return "accueil";
	}
	
	@RequestMapping("/showProduit/{id}")
	public String filtrerProdui(Model model,@PathVariable("id") int identifiantProduit)
	{
        Produit produit = produitDao.find(identifiantProduit);
        
        model.addAttribute(produit);
	
		
		return "showProduit";
	}
	
	
	
	
}
