package com.infotel.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.infotel.entity.Competence;
import com.infotel.entity.Dispositif;
import com.infotel.entity.Equipe;
import com.infotel.entity.Niveau;
import com.infotel.entity.Organisme;
import com.infotel.entity.Regle;
import com.infotel.entity.Ressource;
import com.infotel.repository.EquipeRepository;

@Service
public class EquipeService {
	
	private final EquipeRepository equipeRep;
	private final DispositifService dispService;
	private final RessourceService resService;
	private final RegleService regleService;
	
	public EquipeService(EquipeRepository equipeRep, DispositifService dispService, RessourceService resService, RegleService regleService) {
		this.equipeRep=equipeRep;this.dispService=dispService;this.resService=resService;this.regleService=regleService;
	}
	
	public void clear() {
		equipeRep.deleteAll();
	}
	
	public void create(Equipe equipe) {
		Dispositif disp = equipe.getDispositif();
		equipeRep.save(equipe);
		List<Equipe> equipes=disp.getEquipes();
		equipes.add(equipe);
		disp.setEquipes(equipes);
		dispService.update(disp.getId(), disp);
	}
	
	public Equipe update(int id,Equipe equipe)  {
		Equipe d = equipeRep.findByid(id);
		if(d==null)
			return null;
		else {
			d.setDispositif(equipe.getDispositif());
			d.setNom(equipe.getNom());
			d.setRegles(equipe.getRegles());
			d.setRescible(equipe.getRescible());
			d.setRessources(equipe.getRessources());
			Equipe f = equipeRep.save(d);
			return f;
		}
	}
	
	public void delete(int id)  {
		Equipe d = equipeRep.findByid(id);
		if(d!=null)
			equipeRep.delete(d);
	}
	
	public List<Equipe> getByDispositif(String nom) {
		Dispositif d = dispService.getByNom(nom);
		if(d==null)
			return new ArrayList<>();
		return equipeRep.findBydispositif(d);
	}

	/*public Equipe getByRessource(String nom,String prenom)  {
		Ressource r = resService.getByNomAndPrenom(nom, prenom);
		if(r==null)
			return null;
		return r.getEquipe();
	}*/
	
	public Equipe getByRessource(int id) {
		Ressource r = resService.getById(id);
		if(r==null)
			return null;
		return r.getEquipe();
	}
	
	public Equipe getById(int id)  {
		Equipe d = equipeRep.findByid(id);
		if(d==null)
			return null;
		else {
			return d;
		}
	}
	
	public ArrayList<Equipe> getAll(){
		return equipeRep.findAll();
	}

	public Equipe getByNom(String nom) {
		return equipeRep.findBynom(nom);
	}
	
	public List<Equipe> getByCompetence(String cnom){
		Competence comp = regleService.getCompetenceByNom(cnom);
		if(comp==null)
			return new ArrayList<>();
		List<Equipe> equipes = new ArrayList<>();
		for(Regle r : regleService.getByCompetence(comp)){
			equipes.add(r.getEquipe());
		}
		return equipes;
	}
	
	public List<Equipe> getByNiveau(String orgnom,int niveau){
		Organisme org = regleService.getNiveauService().getOrganismeService().getByNom(orgnom);
		if(org==null)
			return new ArrayList<>();
		Niveau n = org.getNiveaus().get(niveau);
		List<Equipe> equipes = new ArrayList<>();
		for(Regle r : regleService.getByNiveau(n)){
			equipes.add(r.getEquipe());
		}
		return equipes;
	}
	
	public List<Equipe> getByCompetenceAndNiveau(String cnom, String orgnom, int niveau){
		Organisme org = regleService.getNiveauService().getOrganismeService().getByNom(orgnom);
		if(org==null)
			return new ArrayList<>();
		Niveau n = org.getNiveaus().get(niveau);
		Competence comp = regleService.getCompetenceByNom(cnom);
		if(comp==null)
			return new ArrayList<>();
		List<Equipe> equipes = new ArrayList<>();
		for(Regle r : regleService.getByCompetenceAndNiveau(comp,n)){
			equipes.add(r.getEquipe());
		}
		return equipes;
	}
	
	public List<Equipe> getByOrganisme(String orgnom){
		Organisme org = regleService.getNiveauService().getOrganismeService().getByNom(orgnom);
		if(org==null)
			return new ArrayList<>();
		List<Equipe> equipes = new ArrayList<>();
		for(Niveau n : org.getNiveaus()) {
			for(Regle r : n.getRegles()) {
				equipes.add(r.getEquipe());
			}			
		}
		return equipes;
	}

}
