package com.infotel.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.infotel.dto.RessourceDTO;

import java.util.ArrayList;
import java.util.List;


/**
 * The persistent class for the ressource database table.
 * 
 */
@Entity
@Table(name="ressource")
@NamedQuery(name="Ressource.findAll", query="SELECT r FROM Ressource r")
public class Ressource implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(nullable=false, length=45)
	private String nom;

	@Column(nullable=false, length=45)
	private String prenom;

	@Column(nullable=false)
	private int referenceclient;

	//bi-directional many-to-one association to Historiquere
	@OneToOne(mappedBy="ressource",cascade = CascadeType.ALL)
	private Historiqueres historiqueres;

	//bi-directional many-to-one association to Equipe
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idequipe", nullable=true)
	private Equipe equipe;

	//bi-directional many-to-one association to Ressourcehascompetence
	@OneToMany(mappedBy="ressource",cascade = CascadeType.ALL)
	private List<Ressourcehascompetence> ressourcehascompetences= new ArrayList<>();

	public Ressource() {
	}

	public Ressource(String nom, String prenom, int i, Equipe equipe) {
		// TODO Auto-generated constructor stub
		this.nom=nom;this.prenom=prenom;this.referenceclient=i;this.equipe=equipe;
	}

	public Ressource(String nom, String prenom, int referenceClient) {
		// TODO Auto-generated constructor stub
		this.nom=nom;this.prenom=prenom;this.referenceclient=referenceClient;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public int getReferenceclient() {
		return this.referenceclient;
	}

	public void setReferenceclient(int referenceclient) {
		this.referenceclient = referenceclient;
	}

	public Historiqueres getHistoriqueres() {
		return this.historiqueres;
	}

	public void setHistoriqueres(Historiqueres historiqueres) {
		this.historiqueres = historiqueres;
	}

	public Equipe getEquipe() {
		return this.equipe;
	}

	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
	}

	public List<Ressourcehascompetence> getRessourcehascompetences() {
		return this.ressourcehascompetences;
	}

	public void setRessourcehascompetences(List<Ressourcehascompetence> ressourcehascompetences) {
		this.ressourcehascompetences = ressourcehascompetences;
	}

	public Ressourcehascompetence addRessourcehascompetence(Ressourcehascompetence ressourcehascompetence) {
		getRessourcehascompetences().add(ressourcehascompetence);
		ressourcehascompetence.setRessource(this);

		return ressourcehascompetence;
	}

	public Ressourcehascompetence removeRessourcehascompetence(Ressourcehascompetence ressourcehascompetence) {
		getRessourcehascompetences().remove(ressourcehascompetence);
		ressourcehascompetence.setRessource(null);

		return ressourcehascompetence;
	}

	@Override
	public String toString() {
		String text = "Ressource [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", referenceclient=" + referenceclient
				+ ", historiqueres=" + historiqueres.infos() + ", equipe=" + equipe.getNom() + ", ressourcehascompetences=";
		for(Ressourcehascompetence rc : ressourcehascompetences) {
			text+=rc.getCompetence().getNom()+" ,niveau= "+rc.getNiveau().getValeur()+" en date du: "+rc.getDateevolcomp()+"\n";
		}
		return text + "]";
	}

	public RessourceDTO toDTO() {
		RessourceDTO r = new RessourceDTO(nom, prenom, referenceclient, equipe.getNom());
		r.setId(id);
		return r;
	}
}