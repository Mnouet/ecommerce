package com.ecommerce.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ecommerce.model.Produit;
import com.googlecode.genericdao.dao.hibernate.GenericDAOImpl;

/**
 * Gestion de l'implementation des DAO pour la classe Produit
 * 
 * @author Mathias PLATEAU, morgan nouët
 * 
 */

@Repository
public class ProduitDaoImpl extends GenericDAOImpl<Produit, Integer> implements
		ProduitDao {

	@Autowired
	@Override
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}
	
	/**
	 * Retourne une liste de Produit par rapport à une catégorie
	 * @author morgan nouët
	 * @param 
	 */
	@SuppressWarnings("unchecked")
	public List <Produit> findProduitParCategorie(int identifiant)
	{
		List <Produit> produits;
	 produits = (List<Produit>) getSession().createCriteria(Produit.class)
				.add(Restrictions.eq("categorie.identifiant", identifiant))
				.list();
			

		return produits;
	}

}
