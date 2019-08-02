package com.infotel.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

import com.infotel.dto.RessourcehascompetenceDTO;
import com.infotel.entity.Ressourcehascompetence;
import com.infotel.service.RessourcehascompetenceService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/infotel/ressourcehascompetence")
public class DataGetRessourcehascompetenceController {
	
	private final Logger log = LoggerFactory.getLogger(DataCreateController.class);
	private final RessourcehascompetenceService rcService;
	
	public DataGetRessourcehascompetenceController(RessourcehascompetenceService rcService) {
		this.rcService=rcService;
	}
	
	@GetMapping("/ByRessource={nom}&{prenom}&{enom}")
	public ResponseEntity<?> getByRessource(@PathVariable("nom") String nom,@PathVariable("prenom") String prenom,
			@PathVariable("enom") String enom){
		HttpHeaders headers = new HttpHeaders();
		//headers.add("Access-Control-Allow-Origin", "*");
		headers.add("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
		headers.add("Access-Control-Allow-Headers", "X-Requested-With,content-type");
		headers.add("Access-Control-Allow-Credentials", "true");
		List<Ressourcehascompetence> rcs = rcService.getByRessource(nom, prenom, enom);
		List<RessourcehascompetenceDTO> rcsDTO = new ArrayList<>();
		for(Ressourcehascompetence rc : rcs) {
			rcsDTO.add(rc.toDTO());
		}
		return new ResponseEntity<>(rcsDTO,headers,HttpStatus.OK);
	}
	
	@GetMapping("/ByCompetence={nom}")
	public ResponseEntity<?> getByCompetence(@PathVariable("nom") String nom){
		HttpHeaders headers = new HttpHeaders();
		//headers.add("Access-Control-Allow-Origin", "*");
		headers.add("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
		headers.add("Access-Control-Allow-Headers", "X-Requested-With,content-type");
		headers.add("Access-Control-Allow-Credentials", "true");
		List<Ressourcehascompetence> rcs = rcService.getByCompetence(nom);
		List<RessourcehascompetenceDTO> rcsDTO = new ArrayList<>();
		for(Ressourcehascompetence rc : rcs) {
			rcsDTO.add(rc.toDTO());
		}
		return new ResponseEntity<>(rcsDTO,headers,HttpStatus.OK);
	}
	
	@GetMapping("/ByNiveau={niveau}&{orgnom}")
	public ResponseEntity<?> getByNiveau(@PathVariable("niveau") int valeur, @PathVariable("orgnom") String orgnom){
		HttpHeaders headers = new HttpHeaders();
		//headers.add("Access-Control-Allow-Origin", "*");
		headers.add("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
		headers.add("Access-Control-Allow-Headers", "X-Requested-With,content-type");
		headers.add("Access-Control-Allow-Credentials", "true");
		List<Ressourcehascompetence> rcs = rcService.getByNiveau(valeur,orgnom);
		List<RessourcehascompetenceDTO> rcsDTO = new ArrayList<>();
		for(Ressourcehascompetence rc : rcs) {
			rcsDTO.add(rc.toDTO());
		}
		return new ResponseEntity<>(rcsDTO,headers,HttpStatus.OK);
	}
	
	@GetMapping("/ByRessourceAndCompetence={nom}&{prenom}&{enom}&{cnom}")
	public ResponseEntity<?> getByRessourceAndCompetence(@PathVariable("nom") String nom,@PathVariable("prenom") String prenom,
			@PathVariable("enom") String enom,@PathVariable("cnom") String cnom){
		HttpHeaders headers = new HttpHeaders();
		//headers.add("Access-Control-Allow-Origin", "*");
		headers.add("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
		headers.add("Access-Control-Allow-Headers", "X-Requested-With,content-type");
		headers.add("Access-Control-Allow-Credentials", "true");
		List<Ressourcehascompetence> rcs = rcService.getByRessourceAndCompetence(nom,prenom,enom,cnom);
		List<RessourcehascompetenceDTO> rcsDTO = new ArrayList<>();
		for(Ressourcehascompetence rc : rcs) {
			rcsDTO.add(rc.toDTO());
		}
		return new ResponseEntity<>(rcsDTO,headers,HttpStatus.OK);
	}
	
	@GetMapping("/ByDateEvol={date}")
	public ResponseEntity<?> getByDateEvol(@PathVariable("date") Date date){
		HttpHeaders headers = new HttpHeaders();
		//headers.add("Access-Control-Allow-Origin", "*");
		headers.add("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
		headers.add("Access-Control-Allow-Headers", "X-Requested-With,content-type");
		headers.add("Access-Control-Allow-Credentials", "true");
		List<Ressourcehascompetence> rcs = rcService.getByDateEvol(date);
		List<RessourcehascompetenceDTO> rcsDTO = new ArrayList<>();
		for(Ressourcehascompetence rc : rcs) {
			rcsDTO.add(rc.toDTO());
		}
		return new ResponseEntity<>(rcsDTO,headers,HttpStatus.OK);
	}
	
	@GetMapping("/ByRessourceAndDateEvol={nom}&{prenom}&{enom}&{date}")
	public ResponseEntity<?> getByRessourceAndDateEvol(@PathVariable("nom") String nom,@PathVariable("prenom") String prenom,
			@PathVariable("enom") String enom,@PathVariable("date") Date date){
		HttpHeaders headers = new HttpHeaders();
		//headers.add("Access-Control-Allow-Origin", "*");
		headers.add("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
		headers.add("Access-Control-Allow-Headers", "X-Requested-With,content-type");
		headers.add("Access-Control-Allow-Credentials", "true");
		List<Ressourcehascompetence> rcs = rcService.getByRessourceAndDateEvol(nom,prenom,enom,date);
		List<RessourcehascompetenceDTO> rcsDTO = new ArrayList<>();
		for(Ressourcehascompetence rc : rcs) {
			rcsDTO.add(rc.toDTO());
		}
		return new ResponseEntity<>(rcsDTO,headers,HttpStatus.OK);
	}
	
	@GetMapping("/ByCompetenceAndDateEvol={nom}&{date}")
	public ResponseEntity<?> getByCompetenceAndDateEvol(@PathVariable("nom") String nom,@PathVariable("date") Date date){
		HttpHeaders headers = new HttpHeaders();
		//headers.add("Access-Control-Allow-Origin", "*");
		headers.add("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
		headers.add("Access-Control-Allow-Headers", "X-Requested-With,content-type");
		headers.add("Access-Control-Allow-Credentials", "true");
		List<Ressourcehascompetence> rcs = rcService.getByCompetenceAndDateEvol(nom,date);
		List<RessourcehascompetenceDTO> rcsDTO = new ArrayList<>();
		for(Ressourcehascompetence rc : rcs) {
			rcsDTO.add(rc.toDTO());
		}
		return new ResponseEntity<>(rcsDTO,headers,HttpStatus.OK);
	}
	
	@GetMapping("/ByRessourceAndCompetenceAndDateEvol={nom}&{prenom}&{enom}&{cnom}&{date}")
	public ResponseEntity<?> getByRessourceAndCompetenceAndDateEvol(@PathVariable("nom") String nom,@PathVariable("prenom") String prenom,
			@PathVariable("enom") String enom,@PathVariable("cnom") String cnom,@PathVariable("date") Date date){
		HttpHeaders headers = new HttpHeaders();
		//headers.add("Access-Control-Allow-Origin", "*");
		headers.add("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
		headers.add("Access-Control-Allow-Headers", "X-Requested-With,content-type");
		headers.add("Access-Control-Allow-Credentials", "true");
		List<Ressourcehascompetence> rcs = rcService.getByRessourceAndCompetenceAndDateEvol(nom,prenom,enom,cnom,date);
		List<RessourcehascompetenceDTO> rcsDTO = new ArrayList<>();
		for(Ressourcehascompetence rc : rcs) {
			rcsDTO.add(rc.toDTO());
		}
		return new ResponseEntity<>(rcsDTO,headers,HttpStatus.OK);
	}
}
