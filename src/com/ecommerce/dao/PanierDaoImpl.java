package com.ecommerce.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ecommerce.model.Panier;
import com.googlecode.genericdao.dao.hibernate.GenericDAOImpl;

/**
 * Gestion de l'implementation des DAO pour la classe Panier
 * 
 * @author Mathias PLATEAU
 * 
 */

@Repository
public class PanierDaoImpl extends GenericDAOImpl<Panier, Integer> implements
		PanierDao {

	@Autowired
	@Override
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

}
