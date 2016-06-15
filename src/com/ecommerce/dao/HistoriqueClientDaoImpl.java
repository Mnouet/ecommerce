package com.ecommerce.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ecommerce.model.HistoriqueClient;
import com.ecommerce.model.Produit;
import com.googlecode.genericdao.dao.hibernate.GenericDAOImpl;

import java.util.Date;
import java.util.List;

/**
 * Gestion de l'implementation des DAO pour la classe HistoriqueClient
 * 
 * @author Mathias PLATEAU, morgan nouët
 * 
 */

@Repository
public class HistoriqueClientDaoImpl extends
		GenericDAOImpl<HistoriqueClient, Integer> implements
		HistoriqueClientDao {

	public Session getSession() {

		return super.getSession();
	}

	@Autowired
	@Override
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}
	/**
	 * Requête hibernate pour récupérer l'historique d'un client
	 * @author morgan nouët
	 * @param int identifiantClient
	 * @return List<HistoriqueClient>
	 */
	@SuppressWarnings("unchecked")
	public List<HistoriqueClient> chercherCommandesClient(int identifiantClient)
	{ 
		List<HistoriqueClient> historiquesClient = (List<HistoriqueClient>)getSession().createCriteria(HistoriqueClient.class)
				.add(Restrictions.eq("client.identifiant", identifiantClient))
				.list();
		return historiquesClient;
	}
		
}
