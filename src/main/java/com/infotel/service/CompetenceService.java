package com.infotel.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.infotel.entity.Competence;
import com.infotel.entity.Dispositif;
import com.infotel.entity.Dispositifhascompetence;
import com.infotel.entity.Domaine;
import com.infotel.entity.Equipe;
import com.infotel.entity.Niveau;
import com.infotel.entity.Organisme;
import com.infotel.entity.Regle;
import com.infotel.entity.Ressource;
import com.infotel.entity.Ressourcehascompetence;
import com.infotel.repository.CompetenceRepository;

@Service
public class CompetenceService {
	
	private final CompetenceRepository compRep;
	private final DomaineService domaineService;
	private final RegleService regleService;
	private final RessourcehascompetenceService rcService;
	private final DispositifService dispService;
	private final DispositifhascompetenceService dcService;
	
	public CompetenceService(CompetenceRepository compRep,@Lazy DomaineService domaineService, RegleService regleService,
			RessourcehascompetenceService rcService,@Lazy DispositifService dispService,
			@Lazy DispositifhascompetenceService dcService) {
		this.compRep=compRep;this.domaineService=domaineService;this.regleService=regleService;this.rcService=rcService;
		this.dispService=dispService;this.dcService=dcService;
	}
	
	public void clear() {
		compRep.deleteAll();
	}
	
	public void create(Competence comp) {
		compRep.save(comp);
		Domaine domaine = comp.getDomaine();
		List<Competence> competences = domaine.getCompetences();
		competences.add(comp);
		domaine.setCompetences(competences);
		domaineService.update(domaine.getId(), domaine);
	}
	
	public ArrayList<Competence> getAll(){
		return compRep.findAll();
	}
	
	public Competence getById(int id)  {
		return compRep.findByid(id);
	}
	
	public Competence update(int id,Competence comp)  {
		Competence d = compRep.findByid(id);
		if(d==null)
			return null;
		else {
			d.setDomaine(comp.getDomaine());
			d.setRegles(comp.getRegles());
			d.setNom(comp.getNom());
			d.setRessourcehascompetences(comp.getRessourcehascompetences());
			Competence f = compRep.save(d);
			return f;
		}
	}
	
	public void delete(int id)  {
		Competence d = compRep.findByid(id);
		if(d!=null)
			compRep.delete(d);
	}
	
	public List<Competence> getByDomaine(String nom) {
		Domaine domaine = domaineService.getByNom(nom);
		return domaine.getCompetences();
	}
	
	public Competence getByNom(String nom) {
		return compRep.findBynom(nom);
	}
	
	public List<Competence> getByRessource(String nom,String prenom, String equipe) {
		Ressource r = rcService.getRessourceService().getByNomAndPrenomAndEquipe(nom, prenom,equipe);
		if(r==null)
			return new ArrayList<>();
		List<Competence> list = new ArrayList<>();
		for(Ressourcehascompetence rc : r.getRessourcehascompetences()) {
			list.add(rc.getCompetence());
		}
		return list;
	}

	public List<Competence> getByRessourceAndNiveau(String nom,String prenom,String equipe,int valeur,String orgNom) {
		Ressource r = rcService.getRessourceService().getByNomAndPrenomAndEquipe(nom, prenom,equipe);
		if(r==null)
			return null;
		Organisme org = rcService.getNiveauService().getOrganismeService().getByNom(orgNom);
		if(org==null)
			return null;
		Niveau n = org.getNiveaus().get(valeur);
		if(n==null)
			return null;
		List<Competence> competences = new ArrayList<>();
		for(Ressourcehascompetence rc : r.getRessourcehascompetences()) {
			if(rc.getNiveau().getValeur()==n.getId() && rc.getNiveau().getOrganisme().getOrganisme().equals(org.getOrganisme())) {
				competences.add(rc.getCompetence());
			}
		}
		return competences;
	}

	public List<Competence> getByEquipeAndNiveau(String nom,int valeur,String orgNom) {
		Equipe e = regleService.getEquipeService().getByNom(nom);
		if(e==null)
			return new ArrayList<>();
		Organisme org = regleService.getNiveauService().getOrganismeService().getByNom(orgNom);
		if(org==null)
			return new ArrayList<>();
		Niveau n = org.getNiveaus().get(valeur);
		if(n==null)
			return new ArrayList<>();
		List<Competence> list = new ArrayList<>();
		for(Regle r : regleService.getByEquipeAndNiveau(e, n)) {
			list.add(r.getCompetence());
		}
		return list;
	}
	
	public List<Competence> getByEquipe(String nom) {
		Equipe e = regleService.getEquipeService().getByNom(nom);
		if(e==null)
			return new ArrayList<>();
		List<Competence> list = new ArrayList<>();
		for(Regle r : e.getRegles()) {
			list.add(r.getCompetence());
		}
		return list;
	}
	
	public List<Competence> getByDispositif(String nom){
		Dispositif d = dispService.getByNom(nom);
		if(d==null)
			return new ArrayList<>();
		List<Dispositifhascompetence> dcs = dcService.getAll();
		List<Competence> competences = new ArrayList<>();
		for(Dispositifhascompetence dc: dcs) {
			competences.add(compRep.findByid(dc.getId().getIdcompetence()));
		}
		return competences;
	}

}
