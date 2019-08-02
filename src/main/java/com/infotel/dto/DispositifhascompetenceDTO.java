package com.infotel.dto;

import com.infotel.entity.Dispositifhascompetence;
import com.infotel.entity.DispositifhascompetencePK;

public class DispositifhascompetenceDTO {
	private int idd;
	private int idc;
	private String dispositif;
	private String competence;
	
	public DispositifhascompetenceDTO() {
		this.dispositif="";
		this.competence="";
	}

	public DispositifhascompetenceDTO(int idd, int idc) {
		this.idd = idd;
		this.idc = idc;
		this.competence="";
		this.dispositif="";
	}
	
	public DispositifhascompetenceDTO(String dnom, String cnom) {
		this.competence=cnom;
		this.dispositif=dnom;
	}

	public DispositifhascompetenceDTO(int idd, int idc, String dispositif, String competence) {
		this.idd = idd;
		this.idc = idc;
		this.dispositif = dispositif;
		this.competence = competence;
	}

	public int getIdd() {
		return idd;
	}

	public void setIdd(int idd) {
		this.idd = idd;
	}

	public int getIdc() {
		return idc;
	}

	public void setIdc(int idc) {
		this.idc = idc;
	}
	
	public String getDispositif() {
		return dispositif;
	}

	public void setDispositif(String dispositif) {
		this.dispositif = dispositif;
	}

	public String getCompetence() {
		return competence;
	}

	public void setCompetence(String competence) {
		this.competence = competence;
	}

	public Dispositifhascompetence toEntity() {
		Dispositifhascompetence dc = new Dispositifhascompetence();
		dc.setId(new DispositifhascompetencePK(idd,idc));
		return dc;
	}

}
