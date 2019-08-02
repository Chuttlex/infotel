package com.infotel.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infotel.dto.CompetenceDTO;
import com.infotel.entity.Competence;
import com.infotel.service.CompetenceService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/infotel/competence")
public class DataGetCompetenceController {
	
	private final Logger log = LoggerFactory.getLogger(DataCreateController.class);
	private final CompetenceService compService;
	
	public DataGetCompetenceController(CompetenceService compService) {
		this.compService=compService;
	}
	
	@GetMapping("/ByDomaine")
	public ResponseEntity<?> getByDomaine(@RequestBody String nom){
		HttpHeaders headers = new HttpHeaders();
		//headers.add("Access-Control-Allow-Origin", "*");
		headers.add("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
		headers.add("Access-Control-Allow-Headers", "X-Requested-With,content-type");
		headers.add("Access-Control-Allow-Credentials", "true");
		List<Competence> competences = compService.getByDomaine(nom);
		List<CompetenceDTO> competencesDTO = new ArrayList<>();
		for(Competence c : competences) {
			competencesDTO.add(c.toDTO());
		}
		return new ResponseEntity<>(competencesDTO,headers,HttpStatus.OK);
	}
	
	@GetMapping("/ByNom={nom}")
	public ResponseEntity<?> getByNom(@PathVariable("nom") String nom){
		HttpHeaders headers = new HttpHeaders();
		//headers.add("Access-Control-Allow-Origin", "*");
		headers.add("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
		headers.add("Access-Control-Allow-Headers", "X-Requested-With,content-type");
		headers.add("Access-Control-Allow-Credentials", "true");
		Competence competence = compService.getByNom(nom);
		return new ResponseEntity<>(competence.toDTO(),headers,HttpStatus.OK);
	}
	
	@GetMapping("/ByEquipe={nom}")
	public ResponseEntity<?> getByEquipe(@PathVariable("nom") String nom){
		HttpHeaders headers = new HttpHeaders();
		//headers.add("Access-Control-Allow-Origin", "*");
		headers.add("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
		headers.add("Access-Control-Allow-Headers", "X-Requested-With,content-type");
		headers.add("Access-Control-Allow-Credentials", "true");
		List<Competence> competences = compService.getByEquipe(nom);
		List<CompetenceDTO> competencesDTO = new ArrayList<>();
		for(Competence c : competences) {
			competencesDTO.add(c.toDTO());
		}
		return new ResponseEntity<>(competencesDTO,headers,HttpStatus.OK);
	}
	
	@GetMapping("/ByRessource={nom}&{prenom}&{enom}")
	public ResponseEntity<?> getByRessource(@PathVariable("nom") String nom, @PathVariable("prenom") String prenom,
			@PathVariable("enom") String enom){
		HttpHeaders headers = new HttpHeaders();
		//headers.add("Access-Control-Allow-Origin", "*");
		headers.add("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
		headers.add("Access-Control-Allow-Headers", "X-Requested-With,content-type");
		headers.add("Access-Control-Allow-Credentials", "true");
		List<Competence> competences = compService.getByRessource(nom,prenom,enom);
		List<CompetenceDTO> competencesDTO = new ArrayList<>();
		for(Competence c : competences) {
			competencesDTO.add(c.toDTO());
		}
		return new ResponseEntity<>(competencesDTO,headers,HttpStatus.OK);
	}
	
	@GetMapping("/ByRessourceAndNiveau={nom}&{prenom}&{enom}&{niveau}&{orgnom}")
	public ResponseEntity<?> getByRessourceAndNiveau(@PathVariable("nom") String nom, @PathVariable("prenom") String prenom,
			@PathVariable("enom") String enom,@PathVariable("niveau") int valeur, @PathVariable("orgnom") String orgnom){
		HttpHeaders headers = new HttpHeaders();
		//headers.add("Access-Control-Allow-Origin", "*");
		headers.add("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
		headers.add("Access-Control-Allow-Headers", "X-Requested-With,content-type");
		headers.add("Access-Control-Allow-Credentials", "true");
		List<Competence> competences = compService.getByRessourceAndNiveau(nom,prenom,enom,valeur,orgnom);
		List<CompetenceDTO> competencesDTO = new ArrayList<>();
		for(Competence c : competences) {
			competencesDTO.add(c.toDTO());
		}
		return new ResponseEntity<>(competencesDTO,headers,HttpStatus.OK);
	}
	
	@GetMapping("/ByEquipeAndNiveau={nom}&{niveau}&{orgnom}")
	public ResponseEntity<?> getByEquipeAndNiveau(@Valid @PathVariable("nom") String nom,@Valid @PathVariable("niveaux")
	int valeur,	@Valid @PathVariable("orgnom") String orgnom){
		HttpHeaders headers = new HttpHeaders();
		//headers.add("Access-Control-Allow-Origin", "*");
		headers.add("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
		headers.add("Access-Control-Allow-Headers", "X-Requested-With,content-type");
		headers.add("Access-Control-Allow-Credentials", "true");
		List<Competence> competences = compService.getByEquipeAndNiveau(nom,valeur,orgnom);
		List<CompetenceDTO> competencesDTO = new ArrayList<>();
		for(Competence c : competences) {
			competencesDTO.add(c.toDTO());
		}
		return new ResponseEntity<>(competencesDTO,headers,HttpStatus.OK);
	}
	
	@GetMapping("/ByDispositif={nom}")
	public ResponseEntity<?> getByDispositif(@Valid @PathVariable("nom") String nom){
		HttpHeaders headers = new HttpHeaders();
		//headers.add("Access-Control-Allow-Origin", "*");
		headers.add("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
		headers.add("Access-Control-Allow-Headers", "X-Requested-With,content-type");
		headers.add("Access-Control-Allow-Credentials", "true");
		List<Competence> competences = compService.getByDispositif(nom);
		List<CompetenceDTO> competencesDTO = new ArrayList<>();
		for(Competence c : competences) {
			competencesDTO.add(c.toDTO());
		}
		return new ResponseEntity<>(competencesDTO,headers,HttpStatus.OK);
	}

}
