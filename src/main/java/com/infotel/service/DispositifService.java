package com.infotel.service;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.infotel.entity.Dispositif;
import com.infotel.entity.Organisme;
import com.infotel.repository.DispositifRepository;

@Service
public class DispositifService {
	
	private final Logger log = LoggerFactory.getLogger(DispositifService.class);
	
	// Définition des repository
		private final DispositifRepository dispRep;
		private final OrganismeService orgService;
		
		public DispositifService(DispositifRepository dispRep, @Lazy OrganismeService orgService) {
			this.dispRep=dispRep;this.orgService=orgService;
		}
		
		public Dispositif create(Dispositif disp) {
			return dispRep.save(disp);
		}

		public ArrayList<Dispositif> getAll(){
			return dispRep.findAll();
		}

		public Dispositif getById(int id)  {
			return dispRep.findByid(id);
		}
		
		public ArrayList<Dispositif> getByOrganisme(String nom){
			Organisme org = orgService.getByNom(nom);
			if(org==null)
				return new ArrayList<>();
			return this.dispRep.findByOrganisme(org);
		}

		public Dispositif update(int id,Dispositif disp)  {
			Dispositif d = dispRep.findByid(id);
			if(d==null)
				return null;
			else {
				d.setEquipes(disp.getEquipes());
				d.setNom(disp.getNom());
				d.setOrganisme(disp.getOrganisme());
				Dispositif f = dispRep.save(d);
				return f;
			}
		}
		
		public void delete(int id)  {
			Dispositif d = dispRep.findByid(id);
			if(d!=null)
				 dispRep.delete(d);
		}

		public Dispositif getByNom(String nom) {
			return dispRep.findBynom(nom);
		}

		public void clear() {
			dispRep.deleteAll();		
		}
	}

