package com.infotel.dto;

import com.infotel.entity.Organisme;

public class OrganismeDTO {
	private int id;
	private String organisme;
	private String description;
	
	public OrganismeDTO() {
		this.organisme="";
		this.description="";
	}
	
	public OrganismeDTO(String organisme, String description) {
		this.organisme = organisme;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOrganisme() {
		return organisme;
	}

	public void setOrganisme(String organisme) {
		this.organisme = organisme;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Organisme toEntity() {
		Organisme org = new Organisme(this.getOrganisme(),this.getDescription());
		org.setId(this.getId());
		return org;
	}

}
