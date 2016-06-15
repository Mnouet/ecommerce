package com.ecommerce.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class HistoriqueClient {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int identifiant;
	private Date date;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Panier panier;
	
	@ManyToOne
	private Client client;
	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public HistoriqueClient()
	{
		
	}

	public int getIdentifiant() {
		return identifiant;
	}

	public Panier getPanier() {
		return panier;
	}

	public void setPanier(Panier panier) {
		this.panier = panier;
	}

	public void setIdentifiant(int identifiant) {
		this.identifiant = identifiant;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	

}
