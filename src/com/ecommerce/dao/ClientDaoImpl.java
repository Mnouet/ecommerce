package com.ecommerce.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ecommerce.model.Client;
import com.ecommerce.model.Produit;
import com.googlecode.genericdao.dao.hibernate.GenericDAOImpl;

/**
 * Gestion de l'implementation des DAO pour la classe Client
 * 
 * @author Mathias PLATEAU
 * 
 */

@Repository
public class ClientDaoImpl extends GenericDAOImpl<Client, Integer> implements
		ClientDao {

	/**
	 * Requête hibernate pour vérifier si un email client existe déjà en bdd
	 * 
	 * @author Plateau Mathias
	 * @param String
	 *            email
	 * @return client
	 */
	
	public Client findClientByEmail(String email)
	{
		return (Client) getSession().createCriteria(Client.class)
				.add(Restrictions.eq("email", email)).uniqueResult();
		
	}
	
	/**
	 * Requête hibernate pour vérifier si un email client existe déjà en bdd quand l'utilisateur souhaite modifier ses infos
	 * 
	 * @author Plateau Mathias
	 * @param String
	 *            email
	 * @return client
	 */
	
	public Client findVerifyClientByEmail(String email, int id)
	{
		return (Client) getSession().createCriteria(Client.class)
				.add(Restrictions.eq("email", email))
		.add(Restrictions.eq("id", id)).uniqueResult();
		
	}
	
	/**
	 * Requête criterion hibernate pour trouver un client grâce à son login et
	 * mot de passe
	 * 
	 * @author Morgan Nouët
	 * @param String
	 *            email, String mdp
	 * @return client
	 */
	public Client findClient(String email, String mdp) {

		Client client = (Client) getSession().createCriteria(Client.class)
				.add(Restrictions.eq("email", email))
				.add(Restrictions.eq("mdp", mdp)).uniqueResult();

		return client;
	}

	@Autowired
	@Override
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}
}
