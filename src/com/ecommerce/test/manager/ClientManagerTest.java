package com.ecommerce.test.manager;
import static org.junit.Assert.*;

import org.junit.Test;

import com.ecommerce.manager.ClientManager;
import com.ecommerce.manager.PanierManager;
import com.ecommerce.model.Categorie;
import com.ecommerce.model.Client;
import com.ecommerce.model.Panier;
import com.ecommerce.model.Produit;

/**
 * Test de la création d'un client
 * @author Mathias PLATEAU
 *
 */

public class ClientManagerTest {
	
	@Test
	public void testValidationClient() throws Exception
	{
		
		ClientManager clientManager = new ClientManager();
		Client client= new Client();
		
		client.setIdentifiant(1);
		
		//initialisation du client
		String nom;
		String prenom;
		String mail;
		String mdp;
		String adr;
		//test comit
		client.setNom("Paul");
		client.setPrenom("Jean");
		client.setEmail("jeanpaul@angers.fr");
		client.setMdp("toto1234");
		client.setAdresse("15 rue du champignon 49000 Angers");
		String confirmation= client.getMdp();
		
		nom=client.getNom();
		prenom=client.getPrenom();
		mail=client.getEmail();
		adr=client.getAdresse();
		mdp=client.getMdp();
		
		//Test de la conformité des champsk
		clientManager.validationNom(nom);
		clientManager.validationPrenom(prenom);
		clientManager.validationMotsDePasse(mdp, confirmation);
		clientManager.validationAdresse(adr);
		clientManager.validationEmail(mail);
		
		//tests
		assertEquals("Jean",client.getPrenom());
		assertEquals("Paul",client.getNom());
		assertEquals("jeanpaul@angers.fr", client.getEmail());
		assertEquals("15 rue du champignon 49000 Angers",client.getAdresse());
		assertEquals("toto1234",client.getMdp());
		
		assertNotEquals("ean",client.getPrenom());
		assertNotEquals("Pul",client.getNom());
		assertNotEquals("jenpaul@angers.fr", client.getEmail());
		assertNotEquals("15 ue du champignon 49000 Angers",client.getAdresse());
		assertNotEquals("toto234",client.getMdp());
		
		clientManager.creerClient(nom,prenom, mdp, confirmation, adr, mail);	
		
	}


}
