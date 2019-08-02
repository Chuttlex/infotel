package com.infotel.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.infotel.entity.Organisme;
import com.infotel.service.OrganismeService;
import com.infotel.entity.Competence;
import com.infotel.entity.Equipe;
import com.infotel.entity.Niveau;
import com.infotel.entity.Regle;
import com.infotel.entity.Ressource;
import com.infotel.entity.Ressourcehascompetence;
import com.infotel.repository.NiveauRepository;

@Service
public class NiveauService {
	
	private final NiveauRepository niveauRep;
	private final OrganismeService orgService;
	private final RegleService regleService;
	private final RessourcehascompetenceService rcService;
	
	public NiveauService(NiveauRepository niveauRep,@Lazy OrganismeService orgService,RegleService regleService,
			RessourcehascompetenceService rcService) {
		this.niveauRep=niveauRep;this.orgService=orgService;this.regleService=regleService;this.rcService=rcService;
	}
	
	public void clear() {
		niveauRep.deleteAll();
	}
	
	public void create(Niveau n) {
		Organisme org = n.getOrganisme();
		n.setOrganisme(org);
		niveauRep.save(n);
	}
	
	public ArrayList<Niveau> getAll(){
		return niveauRep.findAll();
	}
	
	public Niveau getById(int id)  {
		return niveauRep.findByid(id);
	}
	
	public Niveau update(int id,Niveau niveau)  {
		Niveau d = niveauRep.findByid(id);
		if(d==null)
			return null;
		else {
			d.setDescription(niveau.getDescription());
			d.setOrganisme(niveau.getOrganisme());
			d.setRegles(niveau.getRegles());
			d.setRessourcehascompetences(niveau.getRessourcehascompetences());
			d.setValeur(niveau.getValeur());
			Niveau f = niveauRep.save(d);
			return f;
		}
	}
	
	public void delete(int id)  {
		Niveau d = niveauRep.findByid(id);
		if(d!=null)
			niveauRep.delete(d);
	}
	
	public List<Niveau> getByOrganisme(String nom)  {
		Organisme org = orgService.getByNom(nom);
		if(org==null)
			return new ArrayList<>();
		List<Niveau> list = new ArrayList<>();
		for(Niveau n : niveauRep.findByorganisme(org)) {
			list.add(n);
		}
		return list;
	}
	
	public List<Niveau> getByValeur(int valeur){
		ArrayList<Niveau> list = new ArrayList<>();
		for(Niveau n : niveauRep.findByvaleur(valeur)) {
			list.add(n);
		}
		return list;
	}
	
	public List<Niveau> getByRessourceAndCompetence(String nom,String prenom,String equipe,String cnom)  {
		Ressource r = rcService.getRessourceByNomAndPrenomAndEquipe(nom, prenom,equipe);
		if(r==null)
			return new ArrayList<>();
		Competence c = rcService.getCompetenceByNom(cnom);
		if(c==null)
			return new ArrayList<>();
		List<Niveau> list = new ArrayList<>();
		for(Ressourcehascompetence rc : rcService.getByRessourceAndCompetence(r, c)) {
			list.add(rc.getNiveau());
		}
		return list;
	}
	
	public List<Niveau> getByEquipeAndCompetence(String nom,String cnom)  {
		Equipe e = regleService.getEquipeByNom(nom);
		if(e==null)
			return new ArrayList<>();
		Competence c = regleService.getCompetenceByNom(cnom);
		if(c==null)
			return new ArrayList<>();
		List<Niveau> list = new ArrayList<>();
		for(Regle r : regleService.getByEquipeAndCompetence(e, c)) {
			list.add(r.getNiveau());
		}
		return list;
	}
	
	public List<Niveau> getByEquipe(String nom){
		Equipe e = regleService.getEquipeByNom(nom);
		if(e==null)
			return new ArrayList<>();
		List<Niveau> list = new ArrayList<>();
		for(Regle r : regleService.getByEquipe(e)) {
			list.add(r.getNiveau());
		}
		return list;
	}

	public OrganismeService getOrganismeService() {
		return this.orgService;
	}

}
