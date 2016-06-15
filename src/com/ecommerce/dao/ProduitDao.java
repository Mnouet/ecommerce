package com.ecommerce.dao;

import java.util.List;

import com.ecommerce.model.Produit;
import com.googlecode.genericdao.dao.hibernate.GenericDAO;

/**
 * Gestion des DAO pour la classe Produit
 * @author Mathias PLATEAU
 * 
 */

public interface ProduitDao extends GenericDAO<Produit, Integer> {
	
	public List <Produit> findProduitParCategorie(int identifiantCategorie);

}
