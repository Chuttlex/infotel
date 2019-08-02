package com.infotel.dto;

import java.util.Date;

import com.infotel.entity.Historiqueres;
import com.infotel.entity.Ressource;

public class HistoriqueDTO {
	private int id;
	private Date dateentree;
	private Date datesortie;
	private boolean actif;
	private boolean actifasbackup;
	private String rnom;
	private String rprenom;
	private String equipe;
	
	public HistoriqueDTO() {
		this.dateentree=new Date();this.datesortie=new Date();this.actif=false;this.actifasbackup=false;
		this.rnom="";this.rprenom="";this.setEquipe("");
	}

	public HistoriqueDTO(Date dateentree, Date datesortie, boolean actif, boolean actifasbackup, String rnom,
			String rprenom, String equipe) {
		this.dateentree = dateentree;
		this.datesortie = datesortie;
		this.actif = actif;
		this.actifasbackup = actifasbackup;
		this.rnom = rnom;
		this.rprenom = rprenom;
		this.setEquipe(equipe);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDateentree() {
		return dateentree;
	}

	public void setDateentree(Date dateentree) {
		this.dateentree = dateentree;
	}

	public Date getDatesortie() {
		return datesortie;
	}

	public void setDatesortie(Date datesortie) {
		this.datesortie = datesortie;
	}

	public boolean isActif() {
		return actif;
	}

	public void setActif(boolean actif) {
		this.actif = actif;
	}

	public boolean isActifasbackup() {
		return actifasbackup;
	}

	public void setActifasbackup(boolean actifasbackup) {
		this.actifasbackup = actifasbackup;
	}

	public String getRnom() {
		return rnom;
	}

	public void setRnom(String rnom) {
		this.rnom = rnom;
	}

	public String getRprenom() {
		return rprenom;
	}

	public void setRprenom(String rprenom) {
		this.rprenom = rprenom;
	}

	public String getEquipe() {
		return equipe;
	}

	public void setEquipe(String equipe) {
		this.equipe = equipe;
	}

	public Historiqueres toEntity(Ressource r) {
		Historiqueres hist = new Historiqueres(dateentree, datesortie, actif, actifasbackup, r);
		hist.setId(id);
		return hist;
	}
}
