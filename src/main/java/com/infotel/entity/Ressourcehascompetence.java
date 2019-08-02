package com.infotel.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.infotel.dto.RessourcehascompetenceDTO;

import java.util.Date;


/**
 * The persistent class for the ressourcehascompetence database table.
 * 
 */
@Entity
@Table(name="ressourcehascompetence")
@NamedQuery(name="Ressourcehascompetence.findAll", query="SELECT r FROM Ressourcehascompetence r")
public class Ressourcehascompetence implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private RessourcehascompetencePK id;

	@Temporal(TemporalType.DATE)
	@Column(nullable=true)
	private Date dateevolcomp;

	//bi-directional many-to-one association to Competence
	@ManyToOne(fetch=FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name="idcompetence", nullable=false, insertable=false, updatable=false)
	private Competence competence;

	//bi-directional many-to-one association to Niveau
	@ManyToOne(fetch=FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name="idniveau", nullable=false)
	private Niveau niveau;

	//bi-directional many-to-one association to Ressource
	@ManyToOne(fetch=FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name="idressource", nullable=false, insertable=false, updatable=false)
	private Ressource ressource;

	public Ressourcehascompetence() {
	}

	public Ressourcehascompetence(Ressource r, Competence c, Niveau niveau, Date date) {
		// TODO Auto-generated constructor stub
		this.ressource=r;this.competence=c;this.niveau=niveau;this.dateevolcomp=date;this.id=new RessourcehascompetencePK(r.getId(),c.getId());
	}

	public Ressourcehascompetence(Date dateevolcomp) {
		// TODO Auto-generated constructor stub
		this.dateevolcomp=dateevolcomp;
	}

	public RessourcehascompetencePK getId() {
		return this.id;
	}

	public void setId(RessourcehascompetencePK id) {
		this.id = id;
	}

	public Date getDateevolcomp() {
		return this.dateevolcomp;
	}

	public void setDateevolcomp(Date dateevolcomp) {
		this.dateevolcomp = dateevolcomp;
	}

	public Competence getCompetence() {
		return this.competence;
	}

	public void setCompetence(Competence competence) {
		this.competence = competence;
	}

	public Niveau getNiveau() {
		return this.niveau;
	}

	public void setNiveau(Niveau niveau) {
		this.niveau = niveau;
	}

	public Ressource getRessource() {
		return this.ressource;
	}

	public void setRessource(Ressource ressource) {
		this.ressource = ressource;
	}
	
	@Override
	public String toString() {
		return "Ressourcehascompetence [id=" + id + ", dateevolcomp=" + dateevolcomp + ", competence=" + competence.getNom()
				+ ", niveau=" + niveau.getValeur() + ", ressource=" + ressource.getNom()+" "+ressource.getPrenom()+",ressource ref: "+ressource.getReferenceclient() + "]";
	}

	public RessourcehascompetenceDTO toDTO() {
		RessourcehascompetenceDTO rc = new RessourcehascompetenceDTO(competence.getNom(), ressource.getNom(),
				ressource.getPrenom(), niveau.getValeur(), niveau.getOrganisme().getOrganisme(),
				dateevolcomp, ressource.getEquipe().getNom());
		rc.setIdr(id.getIdressource());
		rc.setIdc(id.getIdcompetence());
		return rc;
	}
}