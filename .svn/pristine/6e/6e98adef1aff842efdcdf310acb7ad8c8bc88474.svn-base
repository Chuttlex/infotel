package com.infotel.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.infotel.dto.CompetenceDTO;

import java.util.ArrayList;
import java.util.List;


/**
 * The persistent class for the competence database table.
 * 
 */
@Entity
@Table(name="competence")
@NamedQuery(name="Competence.findAll", query="SELECT c FROM Competence c")
public class Competence implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(nullable=false, length=45)
	private String nom;

	//bi-directional many-to-one association to Domaine
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="iddomaine", nullable=false)
	private Domaine domaine;

	//bi-directional many-to-one association to Regle
	@OneToMany(mappedBy="competence",cascade = CascadeType.ALL)
	private List<Regle> regles= new ArrayList<>();

	//bi-directional many-to-one association to Ressourcehascompetence
	@OneToMany(mappedBy="competence",cascade = CascadeType.ALL)
	private List<Ressourcehascompetence> ressourcehascompetences = new ArrayList<>();
	
	//bi-directional many-to-one association to Dispositif
	@OneToMany(mappedBy="competence",cascade = CascadeType.ALL)
	private List<Dispositifhascompetence> dispositifhascompetences = new ArrayList<>();

	public Competence() {
	}

	public Competence(String string, Domaine domaine) {
		// TODO Auto-generated constructor stub
		this.nom=string;this.domaine=domaine;
	}

	public Competence(String nom) {
		// TODO Auto-generated constructor stub
		this.nom=nom;
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

	public Domaine getDomaine() {
		return this.domaine;
	}

	public void setDomaine(Domaine domaine) {
		this.domaine = domaine;
	}

	public List<Regle> getRegles() {
		return this.regles;
	}

	public void setRegles(List<Regle> regles) {
		this.regles = regles;
	}

	public Regle addRegle(Regle regle) {
		getRegles().add(regle);
		regle.setCompetence(this);

		return regle;
	}

	public Regle removeRegle(Regle regle) {
		getRegles().remove(regle);
		regle.setCompetence(null);

		return regle;
	}

	public List<Ressourcehascompetence> getRessourcehascompetences() {
		return this.ressourcehascompetences;
	}

	public void setRessourcehascompetences(List<Ressourcehascompetence> ressourcehascompetences) {
		this.ressourcehascompetences = ressourcehascompetences;
	}

	public Ressourcehascompetence addRessourcehascompetence(Ressourcehascompetence ressourcehascompetence) {
		getRessourcehascompetences().add(ressourcehascompetence);
		ressourcehascompetence.setCompetence(this);

		return ressourcehascompetence;
	}

	public Ressourcehascompetence removeRessourcehascompetence(Ressourcehascompetence ressourcehascompetence) {
		getRessourcehascompetences().remove(ressourcehascompetence);
		ressourcehascompetence.setCompetence(null);

		return ressourcehascompetence;
	}

	public List<Dispositifhascompetence> getDispositifhascompetences() {
		return dispositifhascompetences;
	}

	public void setDispositifhascompetences(List<Dispositifhascompetence> dispositifhascompetences) {
		this.dispositifhascompetences = dispositifhascompetences;
	}

	@Override
	public String toString() {
		String text = "Competence [id=" + id + ", nom=" + nom + ", domaine=" + domaine.getId()+" "+domaine.getValeur() + ", regles=" + regles
				+"dispositif="+ ", ressourcehascompetences=";
		for(Ressourcehascompetence rc : ressourcehascompetences) {
			text+=rc.getRessource().getNom()+" "+rc.getRessource().getPrenom()+" ,niveau= "+rc.getNiveau().getValeur()+" en date du: "+rc.getDateevolcomp()+"\n";
		}
		return text+"]";
	}
	
	public CompetenceDTO toDTO() {
		CompetenceDTO comp = new CompetenceDTO(this.nom,this.domaine.getValeur());
		comp.setId(id);
		return comp;
	}

}