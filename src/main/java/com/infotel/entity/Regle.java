package com.infotel.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.infotel.dto.RegleDTO;


/**
 * The persistent class for the regle database table.
 * 
 */
@Entity
@Table(name="regle")
@NamedQuery(name="Regle.findAll", query="SELECT r FROM Regle r")
public class Regle implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(nullable=false)
	private boolean moyenne;

	@Column(nullable=false)
	private int nombre;

	private double pourcentage;

	//bi-directional many-to-one association to Competence
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idcompetence", nullable=false)
	private Competence competence;

	//bi-directional many-to-one association to Equipe
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idequipe", nullable=false)
	private Equipe equipe;

	//bi-directional many-to-one association to Niveau
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idniveau", nullable=false)
	private Niveau niveau;

	public Regle() {
	}

	public Regle(Equipe equipe, Competence c, Niveau niveau, int i, double d, boolean b) {
		// TODO Auto-generated constructor stub
		this.equipe=equipe;this.competence=c;this.niveau=niveau;this.nombre=i;this.pourcentage=d;this.moyenne=b;
	}

	public Regle(int nombre, double pourcentage, boolean moyenne) {
		// TODO Auto-generated constructor stub
		this.nombre=nombre;this.pourcentage=pourcentage;this.moyenne=moyenne;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean getMoyenne() {
		return this.moyenne;
	}

	public void setMoyenne(boolean moyenne) {
		this.moyenne = moyenne;
	}

	public int getNombre() {
		return this.nombre;
	}

	public void setNombre(int nombre) {
		this.nombre = nombre;
	}

	public double getPourcentage() {
		return this.pourcentage;
	}

	public void setPourcentage(double pourcentage) {
		this.pourcentage = pourcentage;
	}

	public Competence getCompetence() {
		return this.competence;
	}

	public void setCompetence(Competence competence) {
		this.competence = competence;
	}

	public Equipe getEquipe() {
		return this.equipe;
	}

	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
	}

	public Niveau getNiveau() {
		return this.niveau;
	}

	public void setNiveau(Niveau niveau) {
		this.niveau = niveau;
	}

	@Override
	public String toString() {
		return "Regle [id=" + id + ", moyenne=" + moyenne + ", nombre=" + nombre + ", pourcentage=" + pourcentage
				+ ", competence=" + competence.getNom() + ", equipe=" + equipe.getNom() + ", niveau=" + niveau.getValeur() + "]";
	}

	public RegleDTO toDTO() {
		// TODO Auto-generated method stub
		RegleDTO r = new RegleDTO(competence.getNom(), equipe.getNom(), niveau.getValeur(),
				niveau.getOrganisme().getOrganisme(), nombre, pourcentage, moyenne);
		r.setId(id);
		return r;
	}

}