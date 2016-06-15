package com.ecommerce.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ecommerce.model.Categorie;
import com.googlecode.genericdao.dao.hibernate.GenericDAOImpl;

/**
 * Gestion de l'implementation des DAO pour la classe Categorie
 * 
 * @author Mathias PLATEAU
 * 
 */

@Repository
public class CategorieDaoImpl extends GenericDAOImpl<Categorie, Integer>
		implements CategorieDao {

	@Autowired
	@Override
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

}
