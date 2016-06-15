package com.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ecommerce.dao.ClientDaoImpl;
import com.ecommerce.model.Client;
import com.ecommerce.model.ClientSession;

@RequestMapping(value="/login")

@Transactional
@Controller
public class LoginController {
	
	@Autowired
	ClientDaoImpl clientDao;
	@Autowired
	Client client;
	@Autowired
	ClientSession clientSession;
	
	@RequestMapping(value="/connexion", method=RequestMethod.POST)
	public ModelAndView connexion(@RequestParam("email") String email, @RequestParam("mdp") String mdp, Model model)
	{
		client = clientDao.findClient(email, mdp);
		int validationConnexion;
		if(client!=null)
		{
			clientSession.setIdentifiant(client.getIdentifiant());
			clientSession.setNom(client.getNom());
			clientSession.setPrenom(client.getPrenom());	
			clientSession.setAdresse(client.getAdresse());	
			clientSession.setEmail(client.getEmail());	
			validationConnexion=1;
		}else{
			validationConnexion=0;
		}
		model.addAttribute("validationConnexion", validationConnexion);
		return new ModelAndView("redirect:/");
	}
	
	@RequestMapping(value="/deconnexion")
	public ModelAndView deconnexion()
	{
		clientSession.setIdentifiant(null);
		
		return new ModelAndView("redirect:/");
	}
	
	
}
