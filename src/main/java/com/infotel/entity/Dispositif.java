package com.infotel.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.infotel.dto.DispositifDTO;
import com.infotel.entity.Organisme;

import java.util.ArrayList;
import java.util.List;


/**
 * The persistent class for the dispositif database table.
 * 
 */
@Entity
@Table(name="dispositif")
@NamedQuery(name="Dispositif.findAll", query="SELECT d FROM Dispositif d")
public class Dispositif implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(length=45)
	private String nom;
	
	@Column(length=255)
	private String description;

	//bi-directional many-to-one association to Equipe
	@OneToMany(mappedBy="dispositif",cascade = CascadeType.ALL)
	private List<Equipe> equipes= new ArrayList<>();

	//bi-directional many-to-one association to Organisme
	//old @OneToOne(mappedBy="dispositif")
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idorganisme", nullable=true,referencedColumnName="id")
	private Organisme organisme;
	
	@OneToMany(mappedBy="dispositif",cascade = CascadeType.ALL)
	private List<Dispositifhascompetence> dispositifhascompetences = new ArrayList<>();

	public Dispositif() {
		this.nom="";this.description="";
	}

	public Dispositif(String string) {
		// TODO Auto-generated constructor stub
		this.nom=string;
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

	public List<Equipe> getEquipes() {
		return this.equipes;
	}

	public void setEquipes(List<Equipe> equipes) {
		this.equipes = equipes;
	}

	public Equipe addEquipe(Equipe equipe) {
		getEquipes().add(equipe);
		equipe.setDispositif(this);

		return equipe;
	}

	public Equipe removeEquipe(Equipe equipe) {
		getEquipes().remove(equipe);
		equipe.setDispositif(null);

		return equipe;
	}

	public Organisme getOrganisme() {
		return this.organisme;
	}

	public void setOrganisme(Organisme organismes) {
		this.organisme = organismes;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Dispositifhascompetence> getDispositifhascompetences() {
		return dispositifhascompetences;
	}

	public void setDispositifhascompetences(List<Dispositifhascompetence> dispositifhascompetences) {
		this.dispositifhascompetences = dispositifhascompetences;
	}

	@Override
	public String toString() {
		String text = "Dispositif [id=" + id + ", nom=" + nom + ", description=" + description + ", equipes=";
		for(Equipe e : equipes) {
			text+=e.getNom()+"\n";
		}
		text+="dispositifhascompetences=";
		for(Dispositifhascompetence c : dispositifhascompetences) {
			text+=c.toString()+"\n";
		}
		return text + ", organisme=" + organisme.getOrganisme() + "]";
	}
	
	public DispositifDTO toDTO() {
		DispositifDTO disp = new DispositifDTO(this.nom,this.description);
		if(this.organisme!=null)
			disp.setOrganisme(this.organisme.getOrganisme());
		disp.setId(id);
		return disp;
	}

}