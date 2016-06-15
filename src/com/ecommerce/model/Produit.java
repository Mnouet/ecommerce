package com.ecommerce.model;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
@Entity
public class Produit {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int identifiant;
private String nom;
private String marque;
private float prix;
private int stock;
private String couleur;

//@ManyToMany(mappedBy="produits")
//private List<Panier> paniers = new ArrayList<Panier>();

@ManyToOne
private Categorie categorie;


	public Produit() {
	// TODO Auto-generated constructor stub
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

	public int getIdentifiant() {
		return identifiant;
	}

	public void setIdentifiant(int identifiant) {
		this.identifiant = identifiant;
	}
	//surcharge d'opérateur ==
	@Override
	public boolean equals(Object obj) {
		
	if(obj instanceof Produit)
	{
	  if(((Produit) obj).getIdentifiant()==this.getIdentifiant())
		  return true;
	  else
		  return false;
	}
	return false;

	} 	

}
