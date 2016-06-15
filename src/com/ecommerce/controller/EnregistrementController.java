package com.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ecommerce.dao.ClientDao;
import com.ecommerce.manager.ClientManager;
import com.ecommerce.model.Client;
import com.ecommerce.model.ClientSession;
import com.sun.istack.internal.NotNull;


@Transactional
@Controller
public class EnregistrementController {
	@Autowired
	Client client;
	@Autowired
	ClientSession clientSession;
	@Autowired
	ClientDao clientDao;
	@Autowired
	private ClientManager clientManager;
	@RequestMapping(value="/enregistrement", method = RequestMethod.POST)
	public String enregistrerClient(@RequestParam("nom") String nom,@RequestParam("prenom") String prenom,@RequestParam("email") String email, @RequestParam("adresse") String adresse,@RequestParam("mdp") String mdp,@RequestParam("confirmation") String confirmation, Model model) {
		client = null;
		try {
			client=clientManager.creerClient(prenom,nom, mdp, confirmation, adresse, email);
			if(clientDao.findClientByEmail(email)!=null)
				throw new Exception("Cet email est déjà utilisé");
			model.addAttribute("client", client);
			clientDao.save(client);	
			clientSession.setIdentifiant(client.getIdentifiant());
			clientSession.setNom(client.getNom());
			clientSession.setPrenom(client.getPrenom());	
			clientSession.setAdresse(client.getAdresse());	
			clientSession.setEmail(client.getEmail());	
			return "enregistrementValide";
			
		} catch (Exception e) {
			e.getMessage();
			model.addAttribute("clientError",e.getMessage());
			return"enregistrement";
		}
	}
	@RequestMapping(value="/enregistrement", method = RequestMethod.GET)
	public String enregistrementFormulaire()
	{
		return "enregistrement";
	}
	
	@RequestMapping(value="/modifierClient", method = RequestMethod.POST)
	public String modifierClient(@RequestParam("nom") String nom,@RequestParam("prenom") String prenom,@RequestParam("email") String email, @RequestParam("adresse") String adresse,@RequestParam("mdp") String mdp,@RequestParam("confirmation") String confirmation, Model model) {
		try {
			Client client = clientDao.find(clientSession.getIdentifiant());
			Client clientTest = clientDao.findClientByEmail(email);
			if(clientSession.getEmail() != email && clientDao.findClientByEmail(email)!=null && clientSession.getIdentifiant()!=clientTest.getIdentifiant())
			{
				
				throw new Exception("Cet email est déjà utilisé");
			}
				
			client=clientManager.modifierClient(prenom,nom, mdp, confirmation, adresse, email, client);
			model.addAttribute("client", client);
			clientDao.save(client);		
			clientSession.setAdresse(adresse);
			clientSession.setNom(nom);
			clientSession.setEmail(email);
			clientSession.setPrenom(prenom);
			return "enregistrementValide";
			
		} catch (Exception e) {
			e.getMessage();
			model.addAttribute("clientError",e.getMessage());
			return"modifierClient";
		}
	}
	@RequestMapping(value="/modifierClient", method = RequestMethod.GET)
	public String modifierFormulaire()
	{
		return "modifierClient";
	}
	
	}
	
	