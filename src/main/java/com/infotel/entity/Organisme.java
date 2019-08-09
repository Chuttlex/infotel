package com.infotel.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.infotel.dto.OrganismeDTO;

import java.util.ArrayList;
import java.util.List;


/**
 * The persistent class for the organisme database table.
 * 
 */
@Entity
@Table(name="organisme")
@NamedQuery(name="Organisme.findAll", query="SELECT o FROM Organisme o")
public class Organisme implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(length=255)
	private String description;

	@Column(nullable=false, length=45)
	private String organisme;

	//bi-directional many-to-one association to Niveau
	@OneToMany(mappedBy="organisme", cascade = CascadeType.ALL)
	private List<Niveau> niveaus= new ArrayList<>();

	//bi-directional many-to-one association to Dispositif
	//old @OneToOne(fetch=FetchType.LAZY, cascade = CascadeType.ALL)
	//old @JoinColumn(name="iddispositif", nullable=true,referencedColumnName="id")
	@OneToMany(mappedBy="organisme", cascade = CascadeType.ALL)
	private List<Dispositif> dispositifs;

	public Organisme() {
	}

	/*old public Organisme(String nom, String desc , Dispositif dispositif) {
		// TODO Auto-generated constructor stub
		this.organisme=nom;this.description=desc;this.dispositif=dispositif;
	}*/

	public Organisme(String organisme, String description) {
		// TODO Auto-generated constructor stub
		this.organisme=organisme;this.description=description;
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

	public String getOrganisme() {
		return this.organisme;
	}

	public void setOrganisme(String organisme) {
		this.organisme = organisme;
	}

	public List<Niveau> getNiveaus() {
		return this.niveaus;
	}

	public void setNiveaus(List<Niveau> niveaus) {
		this.niveaus = niveaus;
	}

	public Niveau addNiveaus(Niveau niveaus) {
		getNiveaus().add(niveaus);
		niveaus.setOrganisme(this);
		return niveaus;
	}

	public Niveau removeNiveaus(Niveau niveaus) {
		getNiveaus().remove(niveaus);
		niveaus.setOrganisme(new Organisme());
		return niveaus;
	}

	public List<Dispositif> getDispositifs() {
		return this.dispositifs;
	}

	public void setDispositifs(List<Dispositif> dispositifs) {
		this.dispositifs = dispositifs;
	}
	
	public Dispositif addDispositif(Dispositif dispositif) {
		this.dispositifs.add(dispositif);
		dispositif.setOrganisme(this);
		return dispositif;
	}
	
	public Dispositif removeDispositif(Dispositif dispositif) {
		this.dispositifs.remove(dispositif);
		dispositif.setOrganisme(new Organisme());
		return dispositif;
	}

	@Override
	public String toString() {
		String text = "Organisme [id=" + id + ", nom=" + organisme + ", description=" + description + ", niveaux=\n"; 
		for(Niveau n : niveaus) {
			text+="Niveau "+n.getValeur()+" définit: "+n.getDescription()+"\n";
		}
		for(Dispositif d : dispositifs) {
			text+="Dispositif"+d.getNom();
		}
		return text + "]";
	}

	public OrganismeDTO toDTO() {
		OrganismeDTO org = new OrganismeDTO(this.getOrganisme(),this.getDescription());
		org.setId(this.getId());
		return org;
	}
}