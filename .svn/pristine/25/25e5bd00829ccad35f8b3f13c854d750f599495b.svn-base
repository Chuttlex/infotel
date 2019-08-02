package com.infotel.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class DispositifhascompetencePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false, nullable=false)
	private int iddispositif;

	@Column(insertable=false, updatable=false, nullable=false)
	private int idcompetence;

	public DispositifhascompetencePK() {
	}
	public DispositifhascompetencePK(int idd, int idc) {
		this.iddispositif=idd;this.idcompetence=idc;
	}
	public int getiddispositif() {
		return this.iddispositif;
	}
	public void setiddispositif(int iddispositif) {
		this.iddispositif = iddispositif;
	}
	public int getIdcompetence() {
		return this.idcompetence;
	}
	public void setIdcompetence(int idcompetence) {
		this.idcompetence = idcompetence;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof DispositifhascompetencePK)) {
			return false;
		}
		DispositifhascompetencePK castOther = (DispositifhascompetencePK)other;
		return 
			(this.iddispositif == castOther.iddispositif)
			&& (this.idcompetence == castOther.idcompetence);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.iddispositif;
		hash = hash * prime + this.idcompetence;
		
		return hash;
	}
	
	@Override
	public String toString() {
		return "DispositifhascompetencePK [iddispositif=" + iddispositif + ", idcompetence=" + idcompetence + "]";
	}
	
}
