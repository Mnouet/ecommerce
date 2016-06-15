package com.ecommerce.dao;

import com.ecommerce.model.Client;
import com.googlecode.genericdao.dao.hibernate.GenericDAO;

/**
 * Gestion des DAO pour la classe Client
 * @author Mathias PLATEAU
 * 
 */

public interface ClientDao extends GenericDAO<Client, Integer>  {
	
	public Client findClient(String email, String mdp);
	
	public Client findClientByEmail(String email);

	public Client findVerifyClientByEmail(String email, int identifiant);

}
