package com.infotel.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.infotel.entity.Dispositif;
import com.infotel.entity.Niveau;
import com.infotel.entity.Organisme;
import com.infotel.repository.OrganismeRepository;
import com.infotel.service.DispositifService;
import com.infotel.service.NiveauService;

@Service
public class OrganismeService {
	
	private final OrganismeRepository orgRep;
	private final DispositifService dispService;
	private final NiveauService niveauService;
	
	public OrganismeService(OrganismeRepository orgRep, DispositifService dispService, NiveauService niveauService) {
		this.orgRep=orgRep;this.dispService=dispService;this.niveauService=niveauService;
	}
	
	public void clear() {
		orgRep.deleteAll();
	}
	
	public void create(Organisme organisme) {
		orgRep.save(organisme);
	}
	
	public ArrayList<Organisme> getAll(){
		return orgRep.findAll();
	}
	
	public Organisme getById(int id) {
		return orgRep.findByid(id);
	}
	
	public Organisme getByNom(String nom) {
		return orgRep.findByorganisme(nom);
	}

	public List<Organisme> getByNiveau(int niveau) {
		List<Niveau> niveaux = niveauService.getByValeur(niveau);
		if(niveaux==null)
			return new ArrayList<>();
		List<Organisme> organismes=new ArrayList<>();
		for(Niveau n : niveaux) {
			organismes.add(orgRep.findByorganisme(n.getOrganisme().getOrganisme()));
		}
		return organismes;
	}
	
	public Organisme update(int id,Organisme org)  {
		Organisme d = orgRep.findByid(id);
		d.setDescription(org.getDescription());
		d.setDispositifs(org.getDispositifs());
		d.setOrganisme(org.getOrganisme());
		Organisme f = orgRep.save(d);
		return f;
	}
	
	public void delete(int id) {
		Organisme d = orgRep.findByid(id);
		if(d!=null)
			orgRep.delete(d);
	}

}
