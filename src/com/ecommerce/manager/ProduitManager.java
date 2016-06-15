package com.ecommerce.manager;

import com.ecommerce.model.Produit;

public class ProduitManager {
	
	/**
	 * Décremente de N le stock d'un produit
	 * @author morgan nouët
	 * @param obj
	 * @param nbStockEnMoins
	 */
	public void enleverStock(Produit obj,int nbStockEnMoins)
	{
		obj.setStock(obj.getStock()-nbStockEnMoins);
	}

}
