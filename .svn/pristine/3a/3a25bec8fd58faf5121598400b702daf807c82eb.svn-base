package com.infotel.dto;

import com.infotel.entity.Regle;

public class RegleDTO {
	private int id;
	private String cnom;
	private String enom;
	private int niveau;
	private String organisme;
	private int nombre;
	private double pourcentage;
	private boolean moyenne;
	
	public RegleDTO() {
		this.cnom="";this.enom="";this.niveau=0;this.organisme="";this.nombre=0;this.pourcentage=0;this.moyenne=false;
	}
	
	public RegleDTO(String cnom, String enom, int niveau, String organisme, int nombre, double pourcentage,
			boolean moyenne) {
		this.cnom = cnom;
		this.enom = enom;
		this.niveau = niveau;
		this.organisme = organisme;
		this.nombre = nombre;
		this.pourcentage = pourcentage;
		this.moyenne = moyenne;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCnom() {
		return cnom;
	}

	public void setCnom(String cnom) {
		this.cnom = cnom;
	}

	public String getEnom() {
		return enom;
	}

	public void setEnom(String enom) {
		this.enom = enom;
	}

	public int getNiveau() {
		return niveau;
	}

	public void setNiveau(int niveau) {
		this.niveau = niveau;
	}

	public String getOrganisme() {
		return organisme;
	}

	public void setOrganisme(String organisme) {
		this.organisme = organisme;
	}

	public int getNombre() {
		return nombre;
	}

	public void setNombre(int nombre) {
		this.nombre = nombre;
	}

	public double getPourcentage() {
		return pourcentage;
	}

	public void setPourcentage(double pourcentage) {
		this.pourcentage = pourcentage;
	}

	public boolean isMoyenne() {
		return moyenne;
	}

	public void setMoyenne(boolean moyenne) {
		this.moyenne = moyenne;
	}

	public Regle toEntity() {
		Regle regle = new Regle(nombre, pourcentage, moyenne);
		regle.setId(id);
		return regle;
	}
}
