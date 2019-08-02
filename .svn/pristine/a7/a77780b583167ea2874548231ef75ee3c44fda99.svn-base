package com.infotel.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the competence database table.
 * 
 */
@Entity
@Table(name="autocomplete")
@NamedQuery(name="AutoComplete.findAll", query="SELECT a FROM AutoComplete a")
public class AutoComplete implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;
	
	@Column(nullable=false, length=455)
	private String value;
	
	public AutoComplete() {
		
	}
	
	public AutoComplete(String val) {
		this.value=val;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
