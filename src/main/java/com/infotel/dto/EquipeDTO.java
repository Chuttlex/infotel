package com.infotel.dto;

import com.infotel.entity.Equipe;

public class EquipeDTO {
	private int id;
	private String nom;
	private int rescible;
	private String dispositif;
	
	public EquipeDTO() {
		this.nom="";this.rescible=0;this.dispositif="";
	}
	
	public EquipeDTO(String nom, int rescible, String dispositif) {
		this.nom = nom;
		this.rescible = rescible;
		this.dispositif = dispositif;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getRescible() {
		return rescible;
	}

	public void setRescible(int rescible) {
		this.rescible = rescible;
	}

	public String getDispositif() {
		return dispositif;
	}

	public void setDispositif(String dispositif) {
		this.dispositif = dispositif;
	}

	public Equipe toEntity() {
		Equipe e = new Equipe(this.nom,this.rescible);
		e.setId(id);
		return e;
	}
}
