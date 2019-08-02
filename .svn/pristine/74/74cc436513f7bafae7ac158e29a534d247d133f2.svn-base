package com.infotel.dto;

import com.infotel.entity.Ressource;

public class RessourceDTO {
	private int id;
	private String nom;
	private String prenom;
	private int referenceClient;
	private String equipe;
	private String dispositif;
	private String organisme;
	
	public RessourceDTO() {
		this.nom="";this.prenom="";this.referenceClient=0;this.equipe="";this.dispositif="";this.organisme="";
	}
	
	public RessourceDTO(String nom, String prenom, int referenceClient, String equipe) {
		this.nom = nom;
		this.prenom = prenom;
		this.referenceClient = referenceClient;
		this.equipe = equipe;
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

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public int getReferenceClient() {
		return referenceClient;
	}

	public void setReferenceClient(int referenceClient) {
		this.referenceClient = referenceClient;
	}

	public String getEquipe() {
		return equipe;
	}

	public void setEquipe(String equipe) {
		this.equipe = equipe;
	}
	
	public String getDispositif() {
		return dispositif;
	}

	public void setDispositif(String dispositif) {
		this.dispositif = dispositif;
	}

	public String getOrganisme() {
		return organisme;
	}

	public void setOrganisme(String organisme) {
		this.organisme = organisme;
	}

	public Ressource toEntity() {
		Ressource r = new Ressource(nom, prenom, referenceClient);
		r.setId(id);
		return r;
	}
}
