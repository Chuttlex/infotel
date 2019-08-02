package com.infotel.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.infotel.dto.HistoriqueDTO;

import java.util.Date;


/**
 * The persistent class for the historiqueres database table.
 * 
 */
@Entity
@Table(name="historiqueres")
@NamedQuery(name="Historiqueres.findAll", query="SELECT h FROM Historiqueres h")
public class Historiqueres implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

	@Temporal(TemporalType.DATE)
	@Column(nullable=false)
	private Date dateentree;

	@Temporal(TemporalType.DATE)
	private Date datesortie;

	@Column(nullable=false)
	private boolean isactif;

	@Column(nullable=false)
	private boolean isactiveasbackup;

	//bi-directional many-to-one association to Ressource
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idressource", nullable=false,referencedColumnName="id")
	private Ressource ressource;

	public Historiqueres() {
	}

	public Historiqueres(Date date, boolean b, boolean c, Ressource r) {
		// TODO Auto-generated constructor stub
		this.dateentree=date;this.isactif=b;this.isactiveasbackup=c;this.ressource=r;
	}

	public Historiqueres(Date date, Date date2, boolean b, boolean c, Ressource r) {
		// TODO Auto-generated constructor stub
		this.dateentree=date;this.isactif=b;this.isactiveasbackup=c;this.ressource=r;this.datesortie=date2;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDateentree() {
		return this.dateentree;
	}

	public void setDateentree(Date dateentree) {
		this.dateentree = dateentree;
	}

	public Date getDatesortie() {
		return this.datesortie;
	}

	public void setDatesortie(Date datesortie) {
		this.datesortie = datesortie;
	}

	public boolean getIsactif() {
		return this.isactif;
	}

	public void setIsactif(boolean isactif) {
		this.isactif = isactif;
	}

	public boolean getIsactiveasbackup() {
		return this.isactiveasbackup;
	}

	public void setIsactiveasbackup(boolean isactiveasbackup) {
		this.isactiveasbackup = isactiveasbackup;
	}

	public Ressource getRessource() {
		return this.ressource;
	}

	public void setRessource(Ressource ressource) {
		this.ressource = ressource;
	}

	@Override
	public String toString() {
		return "Historiqueres [id=" + id + ", dateentree=" + dateentree + ", datesortie=" + datesortie + ", isactif="
				+ isactif + ", isactiveasbackup=" + isactiveasbackup + ", ressource=" + ressource.getNom()+" "+ressource.getPrenom()+", ref:"+ressource.getReferenceclient() + "]";
	}
	
	public String infos() {
		return "Historiqueres [id=" + id + ", dateentree=" + dateentree + ", datesortie=" + datesortie + ", isactif="
				+ isactif + ", isactiveasbackup=" + isactiveasbackup + "]";
	}

	public HistoriqueDTO toDTO() {
		HistoriqueDTO hist = new HistoriqueDTO(dateentree,datesortie,isactif,isactiveasbackup,
				ressource.getNom(),ressource.getPrenom(),ressource.getEquipe().getNom());
		hist.setId(id);
		return hist;
	}
}