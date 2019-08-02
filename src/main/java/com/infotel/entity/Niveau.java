package com.infotel.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.infotel.dto.NiveauDTO;

import java.util.ArrayList;
import java.util.List;


/**
 * The persistent class for the niveau database table.
 * 
 */
@Entity
@Table(name="niveau")
@NamedQuery(name="Niveau.findAll", query="SELECT n FROM Niveau n")
public class Niveau implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(length=255)
	private String description;

	@Column(nullable=false)
	private int valeur;

	//bi-directional many-to-one association to Organisme
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idorganisme", nullable=false)
	private Organisme organisme;

	//bi-directional many-to-one association to Regle
	@OneToMany(mappedBy="niveau",cascade = CascadeType.ALL)
	private List<Regle> regles= new ArrayList<>();

	//bi-directional many-to-one association to Ressourcehascompetence
	@OneToMany(mappedBy="niveau",cascade = CascadeType.ALL)
	private List<Ressourcehascompetence> ressourcehascompetences= new ArrayList<>();

	public Niveau() {
	}

	public Niveau(int i, String string, Organisme org) {
		// TODO Auto-generated constructor stub
		this.valeur=i;this.description=string;this.organisme=org;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getValeur() {
		return this.valeur;
	}

	public void setValeur(int valeur) {
		this.valeur = valeur;
	}

	public Organisme getOrganisme() {
		return this.organisme;
	}

	public void setOrganisme(Organisme organisme) {
		this.organisme = organisme;
	}

	public List<Regle> getRegles() {
		return this.regles;
	}

	public void setRegles(List<Regle> regles) {
		this.regles = regles;
	}

	public Regle addRegle(Regle regle) {
		getRegles().add(regle);
		regle.setNiveau(this);

		return regle;
	}

	public Regle removeRegle(Regle regle) {
		getRegles().remove(regle);
		regle.setNiveau(null);

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
		ressourcehascompetence.setNiveau(this);

		return ressourcehascompetence;
	}

	public Ressourcehascompetence removeRessourcehascompetence(Ressourcehascompetence ressourcehascompetence) {
		getRessourcehascompetences().remove(ressourcehascompetence);
		ressourcehascompetence.setNiveau(null);

		return ressourcehascompetence;
	}

	@Override
	public String toString() {
		String text =  "Niveau [id=" + id + ", description=" + description + ", valeur=" + valeur + ", organisme=" + organisme
				+ ", regles=";
		for(Regle r : regles) {
			text+="Regle #"+r.getId()+" sur "+r.getCompetence().getNom()+" d'un niveau:"+r.getNiveau().getValeur()
					+" sur "+r.getPourcentage()+" de l'equipe, pour minimum:"+r.getNombre()+" personnes dans l'equipe"
					+",on parle d'une moyenne:"+r.getMoyenne()+"\n";
		}
		text+=", ressourcehascompetences=";
		for(Ressourcehascompetence rc : ressourcehascompetences) {
			text+=rc.getRessource().getNom()+" "+rc.getRessource().getPrenom()+" ,niveau= "+rc.getNiveau().getValeur()+" en date du: "+rc.getDateevolcomp()+"\n";
		}
		return text + "]";
	}

	public NiveauDTO toDTO() {
		NiveauDTO n = new NiveauDTO(valeur, description, getOrganisme().getOrganisme());
		n.setId(id);
		return n;
	}
}