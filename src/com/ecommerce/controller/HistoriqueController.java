package com.ecommerce.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ecommerce.dao.HistoriqueClientDao;
import com.ecommerce.dto.HistoriqueClientDTO;
import com.ecommerce.dto.PanierDTO;
import com.ecommerce.manager.PanierManager;
import com.ecommerce.model.ClientSession;
import com.ecommerce.model.HistoriqueClient;

@Transactional
@Controller
public class HistoriqueController {

	@Autowired
	private HistoriqueClientDao historiqueClientDao;
	@Autowired
	private ClientSession clientSession;
	@Autowired
	private PanierManager panierManager;

	@RequestMapping(value = "/historiqueCommande")
	public String afficherHistoriqueCommande(Model model) {
		List<HistoriqueClient> historiqueClient = historiqueClientDao
				.chercherCommandesClient(clientSession.getIdentifiant());
		List<HistoriqueClientDTO> listeHistoriqueClientDTO = new ArrayList<HistoriqueClientDTO>();

		for (HistoriqueClient h : historiqueClient) {

			HistoriqueClientDTO historiqueClientDTO = new HistoriqueClientDTO(h);
			historiqueClientDTO.getPanier().setCoutTotal(
					panierManager.coutTotal(h.getPanier()));
			listeHistoriqueClientDTO.add(historiqueClientDTO);
		}
		model.addAttribute("listeHistoriqueClientDTO", listeHistoriqueClientDTO);

		return "showHistorique";
	}

}
