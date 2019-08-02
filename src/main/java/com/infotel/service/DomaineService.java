package com.infotel.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.infotel.entity.Domaine;
import com.infotel.repository.DomaineRepository;

@Service
public class DomaineService {
	
	private final DomaineRepository domaineRep;
	private final CompetenceService compService;
	
	public DomaineService(DomaineRepository domaineRep, CompetenceService compService) {
		this.domaineRep=domaineRep;this.compService=compService;
	}
	
	public void initialize(){
		this.clear();
		Domaine d=new Domaine("Technique");
		this.create(d);
		Domaine d2 = new Domaine("Fonctionnel");
		Domaine d3 = new Domaine("Exploitation");
		this.create(d2);
		this.create(d3);
	}
	
	public void clear() {
		this.domaineRep.deleteAll();
	}
	
	public void create(Domaine domaine) {
		this.domaineRep.save(domaine);
	}
	
	public ArrayList<Domaine> getAll(){
		return this.domaineRep.findAll();
	}
	
	public Domaine getById(int id)  {
		return this.domaineRep.findByid(id);
	}
	
	public Domaine update(int id,Domaine domaine)  {
		Domaine d = domaineRep.findByid(id);
		if(d==null)
			return null;
		else {
			d.setCompetences(domaine.getCompetences());
			d.setValeur(domaine.getValeur());
			Domaine f = domaineRep.save(d);
			return f;
		}
	}
	
	public void delete(int id)  {
		Domaine d = domaineRep.findByid(id);
		if(d!=null)
			domaineRep.delete(d);
	}
	
	public Domaine getByNom(String nom) {
		return domaineRep.findByvaleur(nom);
	}
	
	public Domaine getByCompetence(String nom) {
		return compService.getByNom(nom).getDomaine();
	}

}
