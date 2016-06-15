package com.ecommerce.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;

import com.ecommerce.model.HistoriqueClient;
import com.googlecode.genericdao.dao.hibernate.GenericDAO;

/**
 * Gestion des DAO pour la classe HistoriqueClient
 * @author Mathias PLATEAU, morgan nouët
 * 
 */

public interface HistoriqueClientDao extends GenericDAO<HistoriqueClient, Integer>{
	
	public Session getSession();
	public List<HistoriqueClient> chercherCommandesClient(int identifiant);
	

}
