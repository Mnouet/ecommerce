package com.ecommerce.test.manager;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import com.ecommerce.manager.PanierManager;
import com.ecommerce.model.Categorie;
import com.ecommerce.model.Panier;
import com.ecommerce.model.Produit;

public class PanierManagerTest {

	@Test
	public void testAjouterProduitPanier() {
		
		PanierManager panierManager = new PanierManager();
		Panier panier = new Panier();
		Produit produitPantalon = new Produit();
		Produit produitChemise = new Produit();
		Categorie pantalon = new Categorie();
		Categorie chemise = new Categorie();
		
		panier.setIdentifiant(1);
		
		//initialisation du produit pantalon levis
		
		produitPantalon.setIdentifiant(1);
		produitPantalon.setCategorie(pantalon);
		produitPantalon.setCouleur("bleu");
		produitPantalon.setMarque("Levis");
		produitPantalon.setNom("pantalonLevis");
		produitPantalon.setPrix(54.5f);
		produitPantalon.setStock(600);
		
		//initialisation du produit chemise Giorgio armani
		produitChemise.setIdentifiant(2);
		produitChemise.setCategorie(chemise);
		produitChemise.setCouleur("blanche");
		produitChemise.setMarque("Giorgio armani");
		produitChemise.setNom("Chemise Giorgio armani");
		produitChemise.setPrix(79.5f);
		produitChemise.setStock(800);
		
		//test de ma méthode ajouter un produit à un Panier
		panierManager.ajouterProduit(produitPantalon, panier);
		panierManager.ajouterProduit(produitChemise, panier);
		
		ArrayList <Produit> testProduits = new ArrayList<Produit>();
		testProduits.add(produitPantalon);
		testProduits.add(produitChemise);
		
		
		assertArrayEquals(testProduits.toArray(), panier.getProduits().toArray());

	}
@Test	
public void testEnleverProduitPanier() {
		
		PanierManager panierManager = new PanierManager();
		Panier panier = new Panier();
		Produit produitPantalon = new Produit();
		Produit produitChemise = new Produit();
		Categorie pantalon = new Categorie();
		Categorie chemise = new Categorie();
		
		panier.setIdentifiant(1);
		
		//initialisation du produit pantalon levis
		
		produitPantalon.setIdentifiant(1);
		produitPantalon.setCategorie(pantalon);
		produitPantalon.setCouleur("bleu");
		produitPantalon.setMarque("Levis");
		produitPantalon.setNom("pantalonLevis");
		produitPantalon.setPrix(54.5f);
		produitPantalon.setStock(600);
		
		//initialisation du produit chemise Giorgio armani
		produitChemise.setIdentifiant(2);
		produitChemise.setCategorie(chemise);
		produitChemise.setCouleur("blanche");
		produitChemise.setMarque("Giorgio armani");
		produitChemise.setNom("Chemise Giorgio armani");
		produitChemise.setPrix(79.5f);
		produitChemise.setStock(800);
		
		//j'ajoute des produits au Panier
		panierManager.ajouterProduit(produitPantalon, panier);
		panierManager.ajouterProduit(produitChemise, panier);
		
		//je supprime le produit pantalon
		panierManager.supprimerProduit(produitPantalon, panier);
		
		//initialisation de mon tableau de test
		ArrayList <Produit> testProduits = new ArrayList<Produit>();
		testProduits.add(produitChemise);
		
		//je compare mes deux tableau
		assertArrayEquals(testProduits.toArray(), panier.getProduits().toArray());

	}

@Test
public void testcalculerTotalPanier() {
	PanierManager panierManager = new PanierManager();
	Panier panier = new Panier();
	Produit produitPantalon = new Produit();
	Produit produitChemise = new Produit();
	Categorie pantalon = new Categorie();
	Categorie chemise = new Categorie();
	
	//initialisation du produit pantalon levis
	
			produitPantalon.setIdentifiant(1);
			produitPantalon.setCategorie(pantalon);
			produitPantalon.setCouleur("bleu");
			produitPantalon.setMarque("Levis");
			produitPantalon.setNom("pantalonLevis");
			produitPantalon.setPrix(54.5f);
			produitPantalon.setStock(600);
			
			//initialisation du produit chemise Giorgio armani
			produitChemise.setIdentifiant(2);
			produitChemise.setCategorie(chemise);
			produitChemise.setCouleur("blanche");
			produitChemise.setMarque("Giorgio armani");
			produitChemise.setNom("Chemise Giorgio armani");
			produitChemise.setPrix(79.5f);
			produitChemise.setStock(800);
			
			//j'ajoute des produits au Panier
			panierManager.ajouterProduit(produitPantalon, panier);
			panierManager.ajouterProduit(produitChemise, panier);
			assertEquals(134, panierManager.coutTotal(panier), 0.001);
	
	
}
}


