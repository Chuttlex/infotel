package com.infotel.dto;

import com.infotel.entity.Niveau;
import com.infotel.entity.Organisme;

public class NiveauDTO {
	private int id;
	private int valeur;
	private String description;
	private String organisme;
	
	public NiveauDTO() {
		this.valeur=0;this.description="";this.organisme="";
	}
	
	public NiveauDTO(int valeur, String description, String organisme) {
		this.valeur = valeur;
		this.description = description;
		this.organisme = organisme;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getValeur() {
		return valeur;
	}

	public void setValeur(int valeur) {
		this.valeur = valeur;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getOrganisme() {
		return organisme;
	}

	public void setOrganisme(String organisme) {
		this.organisme = organisme;
	};

	public Niveau toEntity(Organisme org) {
		Niveau n = new Niveau(valeur, description, org);
		n.setId(id);
		return n;
	}
}
