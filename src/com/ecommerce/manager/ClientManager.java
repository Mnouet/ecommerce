package com.ecommerce.manager;

import org.springframework.stereotype.Component;

import com.ecommerce.model.Client;

@Component
public class ClientManager {

	// test commitd

	/* Verfication des champs du formulaire */

	/**
	 * ValidationNom est la méthode qui permet de valider une saisie de nom par
	 * l'utilisateur
	 * 
	 * @author mathias
	 * @param nom
	 *            le nom que l'utilisateur à rentrer dans le formulaire
	 */

	public void validationNom(String nom) throws Exception {
		if (nom != null && nom.length() < 3) {
			throw new Exception(
					"Le nom d'utilisateur doit contenir au moins 5 caractères.");
		}
	}

	/**
	 * ValidationPrenom est la méthode qui permet de valider une saisie de
	 * prenom par l'utilisateur
	 * 
	 * @author mathias
	 * @param prenom
	 *            le prenom que l'utilisateur à rentrer dans le formulaire
	 */

	public void validationPrenom(String nom) throws Exception {
		if (nom != null && nom.length() < 3) {
			throw new Exception(
					"Le prenom d'utilisateur doit contenir au moins 5 caractères.");
		}
	}

	/**
	 * ValidationMail est la méthode qui permet de valider une saisie de l'email
	 * par l'utilisateur
	 * 
	 * @author mathias
	 * @param email
	 *            l'email que l'utilisateur à rentrer dans le formulaire
	 */

	public void validationEmail(String email) throws Exception {
		if (email != null) {
			if (!email.matches("([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)")) {
				throw new Exception("Merci de saisir une adresse mail valide.");
			}
		} else {
			throw new Exception("Merci de saisir une adresse mail.");
		}
	}

	/**
	 * ValidationMotsDePasse est la méthode qui permet de valider une saisie de
	 * mot de passe par l'utilisateur
	 * 
	 * @author mathias
	 * @param motDePasse
	 *            le mot de passe que l'utilisateur à rentrer dans le formulaire
	 * @param confirmation
	 *            le 2eme mot de passe que l'utilisateur à rentrer dans le
	 *            formulaire
	 */

	public void validationMotsDePasse(String motDePasse, String confirmation)
			throws Exception {
		if (motDePasse != null && confirmation != null) {
			if (!motDePasse.equals(confirmation)) {
				throw new Exception(
						"Les mots de passe entrés sont différents, merci de les saisir à nouveau.");
			} else if (motDePasse.length() < 5) {
				throw new Exception(
						"Les mots de passe doivent contenir au moins 5 caractères.");
			}
		} else {
			throw new Exception(
					"Merci de saisir et confirmer votre mot de passe.");
		}
	}

	/**
	 * ValidationAdresse est la méthode qui permet de valider une saisie de
	 * l'adresse par l'utilisateur
	 * 
	 * @author mathias
	 * @param adresse
	 *            l'adresse que l'utilisateur à rentrer dans le formulaire
	 */

	public void validationAdresse(String adresse) throws Exception {
		if (adresse != null) {
			if (adresse.length() < 10) {
				throw new Exception(
						"L'adresse de livraison doit contenir au moins 10 caractères.");
			}
		} else {
			throw new Exception("Merci d'entrer une adresse de livraison.");
		}
	}


	/**
	 * creerClient est la méthode qui permet de creer un client
	 * 
	 * @author mathias
	 * @return client
	 * @throws Exception 
	 */


	public Client creerClient(String prenom, String nom, String motDePasse,
			String confirmation, String adresse, String email) throws Exception {
		validationNom(nom);
		validationPrenom(prenom);
		validationAdresse(adresse);
		validationEmail(email);
		validationMotsDePasse(motDePasse, confirmation);
		
		Client client = new Client();
		client.setPrenom(prenom);
		client.setNom(nom);
		client.setMdp(motDePasse);
		client.setEmail(email);
		client.setAdresse(adresse);
		return client;
	}
	
	public Client modifierClient(String prenom, String nom, String motDePasse,
			String confirmation, String adresse, String email, Client client) throws Exception {
		validationNom(nom);
		validationPrenom(prenom);
		validationAdresse(adresse);
		validationEmail(email);
		validationMotsDePasse(motDePasse, confirmation);
		
		client.setPrenom(prenom);
		client.setNom(nom);
		client.setMdp(motDePasse);
		client.setEmail(email);
		client.setAdresse(adresse);
		return client;
	}


}