package com.infotel.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.infotel.dto.EquipeDTO;

import java.util.ArrayList;
import java.util.List;


/**
 * The persistent class for the equipe database table.
 * 
 */
@Entity
@Table(name="equipe")
@NamedQuery(name="Equipe.findAll", query="SELECT e FROM Equipe e")
public class Equipe implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(nullable=false, length=45)
	private String nom;

	@Column(nullable=false)
	private int rescible;

	//bi-directional many-to-one association to Dispositif
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="iddispositif", nullable=false)
	private Dispositif dispositif;

	//bi-directional many-to-one association to Regle
	@OneToMany(mappedBy="equipe",cascade = CascadeType.ALL)
	private List<Regle> regles = new ArrayList<>();

	//bi-directional many-to-one association to Ressource
	@OneToMany(mappedBy="equipe",cascade = CascadeType.ALL)
	private List<Ressource> ressources = new ArrayList<>();

	public Equipe() {
	}

	public Equipe(String nom, int i, Dispositif dispositif) {
		// TODO Auto-generated constructor stub
		this.nom=nom;this.rescible=i;this.dispositif=dispositif;
	}

	public Equipe(String nom, int rescible) {
		// TODO Auto-generated constructor stub
		this.nom=nom;this.rescible=rescible;
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

	public int getRescible() {
		return this.rescible;
	}

	public void setRescible(int rescible) {
		this.rescible = rescible;
	}

	public Dispositif getDispositif() {
		return this.dispositif;
	}

	public void setDispositif(Dispositif dispositif) {
		this.dispositif = dispositif;
	}

	public List<Regle> getRegles() {
		return this.regles;
	}

	public void setRegles(List<Regle> regles) {
		this.regles = regles;
	}

	public Regle addRegle(Regle regle) {
		getRegles().add(regle);
		regle.setEquipe(this);

		return regle;
	}

	public Regle removeRegle(Regle regle) {
		getRegles().remove(regle);
		regle.setEquipe(null);

		return regle;
	}

	public List<Ressource> getRessources() {
		return this.ressources;
	}

	public void setRessources(List<Ressource> ressources) {
		this.ressources = ressources;
	}

	public Ressource addRessource(Ressource ressource) {
		getRessources().add(ressource);
		ressource.setEquipe(this);

		return ressource;
	}

	public Ressource removeRessource(Ressource ressource) {
		getRessources().remove(ressource);
		ressource.setEquipe(null);

		return ressource;
	}

	@Override
	public String toString() {
		String text = "Equipe [id=" + id + ", nom=" + nom + ", rescible=" + rescible + ", dispositif=" + dispositif.getNom()+ ", regles=";
		for(Regle r : regles) {
			text+="Regle #"+r.getId()+" sur "+r.getCompetence().getNom()+" d'un niveau:"+r.getNiveau().getValeur()
					+" sur "+r.getPourcentage()+" de l'equipe, pour minimum:"+r.getNombre()+" personnes dans l'equipe"
					+",on parle d'une moyenne:"+r.getMoyenne()+"\n";
		}
		text+="l'equipe est composee de: ";
		for(Ressource r: ressources) {
			text+=r.getNom()+" "+r.getPrenom()+", ref:"+r.getReferenceclient()+"\n";
		}
		 return text + "]";
	}

	public EquipeDTO toDTO() {
		EquipeDTO e = new EquipeDTO(nom,rescible,dispositif.getNom());
		e.setId(id);
		return e;
	}
}