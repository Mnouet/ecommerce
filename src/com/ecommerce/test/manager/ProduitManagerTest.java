package com.ecommerce.test.manager;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ecommerce.manager.ProduitManager;
import com.ecommerce.model.Categorie;
import com.ecommerce.model.Produit;

public class ProduitManagerTest {

	@Test
	public void testEnleverStock() {
		
		Produit pantalonAdidas = new Produit();
		Categorie pantalon = new Categorie();
		ProduitManager produitManager = new ProduitManager();
		
		
		//initialisation de ma categorie pantalon
		
		pantalon.setIdentifiant(1);
		pantalon.setNom("pantalon");
		
		//initialisation du produit pantalon adidias
		
		pantalonAdidas.setIdentifiant(1);
		pantalonAdidas.setCategorie(pantalon);
		pantalonAdidas.setCouleur("noir");
		pantalonAdidas.setMarque("adidas");
		pantalonAdidas.setNom("pantalonAdidas");
		pantalonAdidas.setPrix(54.5f);
		pantalonAdidas.setStock(300);
		
		//test de ma méthode enlever des stock
		produitManager.enleverStock(pantalonAdidas, 200);
		assertEquals(100,pantalonAdidas.getStock());
		
		assertNotEquals(50,pantalonAdidas.getStock());
	}

}
