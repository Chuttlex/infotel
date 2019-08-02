package com.infotel.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infotel.dto.RessourceDTO;
import com.infotel.entity.*;
import com.infotel.service.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/infotel")
public class DataGetByIdController {
	
	private final Logger log = LoggerFactory.getLogger(DataCreateController.class);
	private final DispositifService dispositifService;
	private final OrganismeService organismeService;
	private final EquipeService equipeService;
	private final NiveauService niveauService;
	private final RessourceService resService;
	private final HistoriqueresService histService;
	private final DomaineService domaineService;
	private final CompetenceService compService;
	private final RegleService regleService;
	private final RessourcehascompetenceService rcService;
	private final DispositifhascompetenceService dcService;
	
	public DataGetByIdController(DispositifService dispositifService, OrganismeService orgService,EquipeService equipeService,
			NiveauService niveauService, RessourceService resService, HistoriqueresService histService, DomaineService domaineService,
			CompetenceService compService, RegleService regleService, RessourcehascompetenceService rcService,
			DispositifhascompetenceService dcService) {
		this.dispositifService=dispositifService;this.organismeService=orgService;this.equipeService=equipeService;
		this.niveauService=niveauService;this.resService=resService;this.histService=histService;this.domaineService=domaineService;
		this.compService=compService;this.regleService=regleService;this.rcService=rcService;this.dcService=dcService;
	}
	
	@GetMapping("/getDispositifById={id}")
	public ResponseEntity<?> getDispositifById(@PathVariable("id") int id){
		HttpHeaders headers = new HttpHeaders();
		//headers.add("Access-Control-Allow-Origin", "*");
		headers.add("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
		headers.add("Access-Control-Allow-Headers", "X-Requested-With,content-type");
		headers.add("Access-Control-Allow-Credentials", "true");
		Dispositif dispositif = dispositifService.getById(id);
		return new ResponseEntity<>(dispositif.toDTO(),headers,HttpStatus.OK);
	}
	
	@GetMapping("/getOrganismeById={id}")
	public ResponseEntity<?> getOrganismeById(@PathVariable("id") int id){
		HttpHeaders headers = new HttpHeaders();
		//headers.add("Access-Control-Allow-Origin", "*");
		headers.add("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
		headers.add("Access-Control-Allow-Headers", "X-Requested-With,content-type");
		headers.add("Access-Control-Allow-Credentials", "true");
		Organisme organisme = organismeService.getById(id);
		return new ResponseEntity<>(organisme.toDTO(),headers,HttpStatus.OK);
	}
	
	@GetMapping("/getEquipeById={id}")
	public ResponseEntity<?> getEquipeById(@PathVariable("id") int id){
		HttpHeaders headers = new HttpHeaders();
		//headers.add("Access-Control-Allow-Origin", "*");
		headers.add("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
		headers.add("Access-Control-Allow-Headers", "X-Requested-With,content-type");
		headers.add("Access-Control-Allow-Credentials", "true");
		Equipe equipe = equipeService.getById(id);
		return new ResponseEntity<>(equipe.toDTO(),headers,HttpStatus.OK);
	}
	
	@GetMapping("/getNiveauById={id}")
	public ResponseEntity<?> getNiveauById(@PathVariable("id") int id){
		HttpHeaders headers = new HttpHeaders();
		//headers.add("Access-Control-Allow-Origin", "*");
		headers.add("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
		headers.add("Access-Control-Allow-Headers", "X-Requested-With,content-type");
		headers.add("Access-Control-Allow-Credentials", "true");
		Niveau niveau = niveauService.getById(id);
		return new ResponseEntity<>(niveau.toDTO(),headers,HttpStatus.OK);
	}
	
	@GetMapping("/getRessourceById={id}")
	public ResponseEntity<?> getRessourceById(@PathVariable("id") int id){
		HttpHeaders headers = new HttpHeaders();
		//headers.add("Access-Control-Allow-Origin", "*");
		headers.add("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
		headers.add("Access-Control-Allow-Headers", "X-Requested-With,content-type");
		headers.add("Access-Control-Allow-Credentials", "true");
		Ressource ressource = resService.getById(id);
		RessourceDTO dto = ressource.toDTO();
		dto.setDispositif(ressource.getEquipe().getDispositif().getNom());
		dto.setOrganisme(ressource.getEquipe().getDispositif().getOrganisme().getOrganisme());
		return new ResponseEntity<>(dto,headers,HttpStatus.OK);
	}
	
	@GetMapping("/getHistoriqueById={id}")
	public ResponseEntity<?> getHistoriqueById(@PathVariable("id") int id){
		HttpHeaders headers = new HttpHeaders();
		//headers.add("Access-Control-Allow-Origin", "*");
		headers.add("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
		headers.add("Access-Control-Allow-Headers", "X-Requested-With,content-type");
		headers.add("Access-Control-Allow-Credentials", "true");
		Historiqueres hist = histService.getById(id);
		return new ResponseEntity<>(hist.toDTO(),headers,HttpStatus.OK);
	}
	
	@GetMapping("/getDomaineById={id}")
	public ResponseEntity<?> getDomaineById(@PathVariable("id") int id){
		HttpHeaders headers = new HttpHeaders();
		//headers.add("Access-Control-Allow-Origin", "*");
		headers.add("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
		headers.add("Access-Control-Allow-Headers", "X-Requested-With,content-type");
		headers.add("Access-Control-Allow-Credentials", "true");
		Domaine domaine = domaineService.getById(id);
		return new ResponseEntity<>(domaine.toDTO(),headers,HttpStatus.OK);
	}
	
	@GetMapping("/getCompetenceById={id}")
	public ResponseEntity<?> getCompetenceById(@PathVariable("id") int id){
		HttpHeaders headers = new HttpHeaders();
		//headers.add("Access-Control-Allow-Origin", "*");
		headers.add("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
		headers.add("Access-Control-Allow-Headers", "X-Requested-With,content-type");
		headers.add("Access-Control-Allow-Credentials", "true");
		Competence competence = compService.getById(id);
		return new ResponseEntity<>(competence.toDTO(),headers,HttpStatus.OK);
	}
	
	@GetMapping("/getRegleById={id}")
	public ResponseEntity<?> getRegleById(@PathVariable("id") int id){
		HttpHeaders headers = new HttpHeaders();
		//headers.add("Access-Control-Allow-Origin", "*");
		headers.add("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
		headers.add("Access-Control-Allow-Headers", "X-Requested-With,content-type");
		headers.add("Access-Control-Allow-Credentials", "true");
		Regle regle = regleService.getById(id);
		return new ResponseEntity<>(regle.toDTO(),headers,HttpStatus.OK);
	}
	
	@GetMapping("/getRessourcehascompetenceById={idr}&{idc}")
	public ResponseEntity<?> getRessourcehascompetenceById(@PathVariable("idr") int idr, @PathVariable("idc") int idc){
		HttpHeaders headers = new HttpHeaders();
		//headers.add("Access-Control-Allow-Origin", "*");
		headers.add("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
		headers.add("Access-Control-Allow-Headers", "X-Requested-With,content-type");
		headers.add("Access-Control-Allow-Credentials", "true");
		RessourcehascompetencePK id = new RessourcehascompetencePK(idr, idc);
		Ressourcehascompetence rc = rcService.getById(id);
		return new ResponseEntity<>(rc.toDTO(),headers,HttpStatus.OK);
	}
	
	@GetMapping("/getDispositifhascompetenceById={idd}&{idc}")
	public ResponseEntity<?> getDispositifhascompetenceById(@PathVariable("idd") int idd, @PathVariable("idc") int idc){
		HttpHeaders headers = new HttpHeaders();
		//headers.add("Access-Control-Allow-Origin", "*");
		headers.add("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
		headers.add("Access-Control-Allow-Headers", "X-Requested-With,content-type");
		headers.add("Access-Control-Allow-Credentials", "true");
		DispositifhascompetencePK id = new DispositifhascompetencePK(idd, idc);
		Dispositifhascompetence dc = dcService.getById(id);
		return new ResponseEntity<>(dc.toDTO(),headers,HttpStatus.OK);
	}
}
