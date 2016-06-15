package com.ecommerce.dto;

import java.util.Date;

import com.ecommerce.model.Client;
import com.ecommerce.model.HistoriqueClient;


public class HistoriqueClientDTO {

	private int identifiant;
	private Date date;
	private PanierDTO panier;
	private Client client;
	
	public HistoriqueClientDTO(HistoriqueClient historique)
	{
		this.identifiant=historique.getIdentifiant();
		this.date=historique.getDate();
		this.panier= new PanierDTO(historique.getPanier());
		this.client=historique.getClient();
	}
	
	public int getIdentifiant() {
		return identifiant;
	}
	public void setIdentifiant(int identifiant) {
		this.identifiant = identifiant;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	public PanierDTO getPanier() {
		return panier;
	}

	public void setPanier(PanierDTO panier) {
		this.panier = panier;
	}

	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	
	

}
