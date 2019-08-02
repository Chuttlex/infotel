package com.infotel.dto;

import com.infotel.entity.Domaine;

public class DomaineDTO {
	private int id;
	private String valeur;
	
	public DomaineDTO(String valeur) {
		this.valeur = valeur;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getValeur() {
		return valeur;
	}

	public void setValeur(String valeur) {
		this.valeur = valeur;
	}

	public Domaine toEntity() {
		Domaine domaine = new Domaine(this.valeur);
		domaine.setId(id);
		return domaine;
	}
}
