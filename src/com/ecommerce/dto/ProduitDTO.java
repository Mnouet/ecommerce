package com.ecommerce.dto;

import com.ecommerce.model.Categorie;
import com.ecommerce.model.Produit;

public class ProduitDTO {

	private int identifiant;
	private String nom;
	private String marque;
	private float prix;
	private int stock;
	private String couleur;
	private Categorie categorie;

	public ProduitDTO(Produit produit) {
		this.identifiant = produit.getIdentifiant();
		this.nom = produit.getNom();
		this.marque = produit.getMarque();
		this.prix = produit.getPrix();
		this.stock = produit.getStock();
		this.couleur = produit.getCouleur();
		this.categorie = produit.getCategorie();
	}

	public int getIdentifiant() {
		return identifiant;
	}

	public void setIdentifiant(int identifiant) {
		this.identifiant = identifiant;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public float getPrix() {
		return prix;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getCouleur() {
		return couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	// surcharge d'opérateur ==
	@Override
	public boolean equals(Object obj) {

		if (obj instanceof ProduitDTO) {
			if (((ProduitDTO) obj).getIdentifiant() == this.getIdentifiant())
				return true;
			else
				return false;
		}
		return false;

	}

}
