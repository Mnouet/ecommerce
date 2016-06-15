package com.ecommerce.dto;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.ecommerce.model.Panier;
import com.ecommerce.model.Produit;

public class PanierDTO {
	
	private int identifiant;
	private List<ProduitDTO> produits;
	private float coutTotal;
	
	public float getCoutTotal() {
		return coutTotal;
	}


	public void setCoutTotal(float coutTotal) {
		this.coutTotal = coutTotal;
	}


	public PanierDTO(Panier panier)
	{
		this.identifiant=panier.getIdentifiant();
		this.produits= new ArrayList<ProduitDTO>();
		 Iterator<Produit> itr = panier.getProduits().iterator();
		while (itr.hasNext())
		{
			ProduitDTO produitDTO = new ProduitDTO(itr.next());
			produits.add(produitDTO);
		}
	}


	public int getIdentifiant() {
		return identifiant;
	}

	public void setIdentifiant(int identifiant) {
		this.identifiant = identifiant;
	}


	public List<ProduitDTO> getProduits() {
		return produits;
	}


	public void setProduits(List<ProduitDTO> produits) {
		this.produits = produits;
	}

	

}
