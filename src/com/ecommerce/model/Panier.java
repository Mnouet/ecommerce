package com.ecommerce.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Entity
@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Panier {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int identifiant;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "panier_produit", joinColumns = @JoinColumn(name = "panier_id"), inverseJoinColumns = @JoinColumn(name = "produit_id"))
	private List<Produit> produits = new ArrayList<Produit>();

	public Panier() {

	}

	public List<Produit> getProduits() {
		return produits;
	}

	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}

	public int getIdentifiant() {
		return identifiant;
	}

	public void setIdentifiant(int identifiant) {
		this.identifiant = identifiant;
	}

}
