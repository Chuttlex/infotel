package com.infotel.controller;

import java.util.ArrayList;
import java.util.List;


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

import com.infotel.dto.RegleDTO;
import com.infotel.entity.Regle;
import com.infotel.service.RegleService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/infotel/regle")
public class DataGetRegleController {
	
	private final Logger log = LoggerFactory.getLogger(DataCreateController.class);
	private final RegleService regleService;
	
	public DataGetRegleController(RegleService regleService) {
		this.regleService=regleService;
	}
	
	@GetMapping("/ByEquipeAndCompetence={enom}&{nom}")
	public ResponseEntity<?> getByEquipeAndCompetence(@PathVariable("enom") String nom, @PathVariable("nom") String cnom){
		HttpHeaders headers = new HttpHeaders();
		//headers.add("Access-Control-Allow-Origin", "*");
		headers.add("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
		headers.add("Access-Control-Allow-Headers", "X-Requested-With,content-type");
		headers.add("Access-Control-Allow-Credentials", "true");
		List<Regle> regles = regleService.getByEquipeAndCompetence(nom, cnom);
		List<RegleDTO> reglesDTO = new ArrayList<>();
		for(Regle r : regles) {
			reglesDTO.add(r.toDTO());
		}
		return new ResponseEntity<>(reglesDTO,headers,HttpStatus.OK);
	}
	
	@GetMapping("/ByEquipe={nom}")
	public ResponseEntity<?> getByEquipe(@PathVariable("nom") String nom){
		HttpHeaders headers = new HttpHeaders();
		//headers.add("Access-Control-Allow-Origin", "*");
		headers.add("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
		headers.add("Access-Control-Allow-Headers", "X-Requested-With,content-type");
		headers.add("Access-Control-Allow-Credentials", "true");
		List<Regle> regles = regleService.getByEquipe(nom);
		List<RegleDTO> reglesDTO = new ArrayList<>();
		for(Regle r : regles) {
			reglesDTO.add(r.toDTO());
		}
		return new ResponseEntity<>(reglesDTO,headers,HttpStatus.OK);
	}
	
	@GetMapping("/ByCompetenceAndNiveau={nom}&{niveau}&{orgnom}")
	public ResponseEntity<?> getByCompetenceAndNiveau(@PathVariable("nom") String cnom, @PathVariable("niveau") int valeur,
			@PathVariable("orgnom") String orgnom){
		HttpHeaders headers = new HttpHeaders();
		//headers.add("Access-Control-Allow-Origin", "*");
		headers.add("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
		headers.add("Access-Control-Allow-Headers", "X-Requested-With,content-type");
		headers.add("Access-Control-Allow-Credentials", "true");
		List<Regle> regles = regleService.getByCompetenceAndNiveau(cnom,valeur,orgnom);
		List<RegleDTO> reglesDTO = new ArrayList<>();
		for(Regle r : regles) {
			reglesDTO.add(r.toDTO());
		}
		return new ResponseEntity<>(reglesDTO,headers,HttpStatus.OK);
	}
	
	@GetMapping("/ByDispositif={nom}")
	public ResponseEntity<?> getByDispositif(@PathVariable("nom") String nom){
		HttpHeaders headers = new HttpHeaders();
		//headers.add("Access-Control-Allow-Origin", "*");
		headers.add("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
		headers.add("Access-Control-Allow-Headers", "X-Requested-With,content-type");
		headers.add("Access-Control-Allow-Credentials", "true");
		List<Regle> regles = regleService.getByDispositif(nom);
		List<RegleDTO> reglesDTO = new ArrayList<>();
		for(Regle r : regles) {
			reglesDTO.add(r.toDTO());
		}
		return new ResponseEntity<>(reglesDTO,headers,HttpStatus.OK);
	}
	
	@GetMapping("/ByOrganisme={nom}")
	public ResponseEntity<?> getByOrganisme(@PathVariable("nom") String nom){
		HttpHeaders headers = new HttpHeaders();
		//headers.add("Access-Control-Allow-Origin", "*");
		headers.add("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
		headers.add("Access-Control-Allow-Headers", "X-Requested-With,content-type");
		headers.add("Access-Control-Allow-Credentials", "true");
		List<Regle> regles = regleService.getByOrganisme(nom);
		List<RegleDTO> reglesDTO = new ArrayList<>();
		for(Regle r : regles) {
			reglesDTO.add(r.toDTO());
		}
		return new ResponseEntity<>(reglesDTO,headers,HttpStatus.OK);
	}
	
	@GetMapping("/ByEquipeAndNiveau={enom}&{niveau}&{orgnom}")
	public ResponseEntity<?> getByEquipeAndNiveau(@PathVariable("enom") String nom, @PathVariable("niveau") int valeur,
			@PathVariable("orgnom") String orgnom){
		HttpHeaders headers = new HttpHeaders();
		//headers.add("Access-Control-Allow-Origin", "*");
		headers.add("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
		headers.add("Access-Control-Allow-Headers", "X-Requested-With,content-type");
		headers.add("Access-Control-Allow-Credentials", "true");
		List<Regle> regles = regleService.getByEquipeAndNiveau(nom,valeur,orgnom);
		List<RegleDTO> reglesDTO = new ArrayList<>();
		for(Regle r : regles) {
			reglesDTO.add(r.toDTO());
		}
		return new ResponseEntity<>(reglesDTO,headers,HttpStatus.OK);
	}
	
	@GetMapping("/ByEquipeAndCompetenceAndNiveau={enom}&{nom}&{niveau}&{orgnom}")
	public ResponseEntity<?> getByEquipeAndCompetenceAndNiveau(@PathVariable("enom") String nom, @PathVariable("nom") String cnom
			, @PathVariable("niveau") int valeur,@PathVariable("orgnom") String orgnom){
		HttpHeaders headers = new HttpHeaders();
		//headers.add("Access-Control-Allow-Origin", "*");
		headers.add("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
		headers.add("Access-Control-Allow-Headers", "X-Requested-With,content-type");
		headers.add("Access-Control-Allow-Credentials", "true");
		Regle regle = regleService.getByEquipeAndCompetenceAndNiveau(nom,cnom,valeur,orgnom);
		return new ResponseEntity<>(regle.toDTO(),headers,HttpStatus.OK);
	}
	
	@GetMapping("/ByNiveau={niveau}&{orgnom}")
	public ResponseEntity<?> getByNiveau(@PathVariable("niveau") int valeur, @PathVariable("orgnom") String orgnom){
		HttpHeaders headers = new HttpHeaders();
		//headers.add("Access-Control-Allow-Origin", "*");
		headers.add("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
		headers.add("Access-Control-Allow-Headers", "X-Requested-With,content-type");
		headers.add("Access-Control-Allow-Credentials", "true");
		List<Regle> regles = regleService.getByNiveau(valeur,orgnom);
		List<RegleDTO> reglesDTO = new ArrayList<>();
		for(Regle r : regles) {
			reglesDTO.add(r.toDTO());
		}
		return new ResponseEntity<>(reglesDTO,headers,HttpStatus.OK);
	}
	
	@GetMapping("/ByPourcentage={pourcentage}")
	public ResponseEntity<?> getByPourcentage(@PathVariable("pourcentage") double pourcentage){
		HttpHeaders headers = new HttpHeaders();
		//headers.add("Access-Control-Allow-Origin", "*");
		headers.add("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
		headers.add("Access-Control-Allow-Headers", "X-Requested-With,content-type");
		headers.add("Access-Control-Allow-Credentials", "true");
		List<Regle> regles = regleService.getByPourcentage(pourcentage);
		List<RegleDTO> reglesDTO = new ArrayList<>();
		for(Regle r : regles) {
			reglesDTO.add(r.toDTO());
		}
		return new ResponseEntity<>(reglesDTO,headers,HttpStatus.OK);
	}
	
	@GetMapping("/ByPourcentageAndNombre={pourcentage}&{nombre}")
	public ResponseEntity<?> getByPourcentageAndNombre(@PathVariable("pourcentage") double pourcentage, @PathVariable("nombre") int nombre){
		HttpHeaders headers = new HttpHeaders();
		//headers.add("Access-Control-Allow-Origin", "*");
		headers.add("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
		headers.add("Access-Control-Allow-Headers", "X-Requested-With,content-type");
		headers.add("Access-Control-Allow-Credentials", "true");
		List<Regle> regles = regleService.getByPourcentageAndNombre(pourcentage,nombre);
		List<RegleDTO> reglesDTO = new ArrayList<>();
		for(Regle r : regles) {
			reglesDTO.add(r.toDTO());
		}
		return new ResponseEntity<>(reglesDTO,headers,HttpStatus.OK);
	}
	
	@GetMapping("/ByCompetenceAndPourcentage={nom}&{pourcentage}")
	public ResponseEntity<?> getByCompetenceAndPourcentage(@PathVariable("nom") String cnom,@PathVariable("pourcentage") double pourcentage){
		HttpHeaders headers = new HttpHeaders();
		//headers.add("Access-Control-Allow-Origin", "*");
		headers.add("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
		headers.add("Access-Control-Allow-Headers", "X-Requested-With,content-type");
		headers.add("Access-Control-Allow-Credentials", "true");
		List<Regle> regles = regleService.getByCompetenceAndPourcentage(cnom,pourcentage);
		List<RegleDTO> reglesDTO = new ArrayList<>();
		for(Regle r : regles) {
			reglesDTO.add(r.toDTO());
		}
		return new ResponseEntity<>(reglesDTO,headers,HttpStatus.OK);
	}
	
	@GetMapping("/ByCompetenceAndNiveauAndPourcentage={nom}&{niveau}&{orgnom}&{pourcentage}")
	public ResponseEntity<?> getByCompetenceAndNiveauAndPourcentage(@PathVariable("nom") String cnom, @PathVariable("niveau") int valeur,
			@PathVariable("orgnom") String orgnom,@PathVariable("pourcentage") double pourcentage){
		HttpHeaders headers = new HttpHeaders();
		//headers.add("Access-Control-Allow-Origin", "*");
		headers.add("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
		headers.add("Access-Control-Allow-Headers", "X-Requested-With,content-type");
		headers.add("Access-Control-Allow-Credentials", "true");
		List<Regle> regles = regleService.getByCompetenceAndNiveauAndPourcentage(cnom,valeur,orgnom,pourcentage);
		List<RegleDTO> reglesDTO = new ArrayList<>();
		for(Regle r : regles) {
			reglesDTO.add(r.toDTO());
		}
		return new ResponseEntity<>(reglesDTO,headers,HttpStatus.OK);
	}
	
	@GetMapping("/ByEquipeAndPourcentage={nom}&{pourcentage}")
	public ResponseEntity<?> getByEquipeAndPourcentage(@PathVariable("nom") String nom,@PathVariable("pourcentage") double pourcentage){
		HttpHeaders headers = new HttpHeaders();
		//headers.add("Access-Control-Allow-Origin", "*");
		headers.add("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
		headers.add("Access-Control-Allow-Headers", "X-Requested-With,content-type");
		headers.add("Access-Control-Allow-Credentials", "true");
		List<Regle> regles = regleService.getByEquipeAndPourcentage(nom,pourcentage);
		List<RegleDTO> reglesDTO = new ArrayList<>();
		for(Regle r : regles) {
			reglesDTO.add(r.toDTO());
		}
		return new ResponseEntity<>(reglesDTO,headers,HttpStatus.OK);
	}
	
	@GetMapping("/ByNombre={nombre}")
	public ResponseEntity<?> getByNombre(@PathVariable("nombre") int nombre){
		HttpHeaders headers = new HttpHeaders();
		//headers.add("Access-Control-Allow-Origin", "*");
		headers.add("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
		headers.add("Access-Control-Allow-Headers", "X-Requested-With,content-type");
		headers.add("Access-Control-Allow-Credentials", "true");
		List<Regle> regles = regleService.getByNombre(nombre);
		List<RegleDTO> reglesDTO = new ArrayList<>();
		for(Regle r : regles) {
			reglesDTO.add(r.toDTO());
		}
		return new ResponseEntity<>(reglesDTO,headers,HttpStatus.OK);
	}
	
	@GetMapping("/ByCompetenceAndNombre={nom}&{nombre}")
	public ResponseEntity<?> getByCompetenceAndNombre(@PathVariable("nom") String nom,@PathVariable("nombre") int nombre){
		HttpHeaders headers = new HttpHeaders();
		//headers.add("Access-Control-Allow-Origin", "*");
		headers.add("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
		headers.add("Access-Control-Allow-Headers", "X-Requested-With,content-type");
		headers.add("Access-Control-Allow-Credentials", "true");
		List<Regle> regles = regleService.getByCompetenceAndNombre(nom,nombre);
		List<RegleDTO> reglesDTO = new ArrayList<>();
		for(Regle r : regles) {
			reglesDTO.add(r.toDTO());
		}
		return new ResponseEntity<>(reglesDTO,headers,HttpStatus.OK);
	}
	
	@GetMapping("/ByEquipeAndNombre={nom}&{nombre}")
	public ResponseEntity<?> getByEquipeAndNombre(@PathVariable("nom") String nom,@PathVariable("nombre") int nombre){
		HttpHeaders headers = new HttpHeaders();
		//headers.add("Access-Control-Allow-Origin", "*");
		headers.add("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
		headers.add("Access-Control-Allow-Headers", "X-Requested-With,content-type");
		headers.add("Access-Control-Allow-Credentials", "true");
		List<Regle> regles = regleService.getByEquipeAndNombre(nom,nombre);
		List<RegleDTO> reglesDTO = new ArrayList<>();
		for(Regle r : regles) {
			reglesDTO.add(r.toDTO());
		}
		return new ResponseEntity<>(reglesDTO,headers,HttpStatus.OK);
	}
	
	@GetMapping("/ByCompetenceAndNiveauAndNombre={nom}&{niveau}&{orgnom}&{nombre}")
	public ResponseEntity<?> getByCompetenceAndNiveauAndNombre(@PathVariable("nom") String nom,@PathVariable("niveau") int valeur,
			@PathVariable("orgnom") String orgnom,@PathVariable("nombre") int nombre){
		HttpHeaders headers = new HttpHeaders();
		//headers.add("Access-Control-Allow-Origin", "*");
		headers.add("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
		headers.add("Access-Control-Allow-Headers", "X-Requested-With,content-type");
		headers.add("Access-Control-Allow-Credentials", "true");
		List<Regle> regles = regleService.getByCompetenceAndNiveauAndNombre(nom,valeur,orgnom,nombre);
		List<RegleDTO> reglesDTO = new ArrayList<>();
		for(Regle r : regles) {
			reglesDTO.add(r.toDTO());
		}
		return new ResponseEntity<>(reglesDTO,headers,HttpStatus.OK);
	}
	
	@GetMapping("/ByCompetenceAndEquipeAndNombre={cnom}&{enom}&{nombre}")
	public ResponseEntity<?> getByCompetenceAndEquipeAndNombre(@PathVariable("cnom") String cnom,@PathVariable("enom") String enom
			,@PathVariable("nombre") int nombre){
		HttpHeaders headers = new HttpHeaders();
		//headers.add("Access-Control-Allow-Origin", "*");
		headers.add("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
		headers.add("Access-Control-Allow-Headers", "X-Requested-With,content-type");
		headers.add("Access-Control-Allow-Credentials", "true");
		List<Regle> regles = regleService.getByCompetenceAndEquipeAndNombre(cnom,enom,nombre);
		List<RegleDTO> reglesDTO = new ArrayList<>();
		for(Regle r : regles) {
			reglesDTO.add(r.toDTO());
		}
		return new ResponseEntity<>(reglesDTO,headers,HttpStatus.OK);
	}
	
	@GetMapping("/ByMoyenne={moyenne}")
	public ResponseEntity<?> getByMoyenne(@PathVariable("moyenne") boolean moyenne){
		HttpHeaders headers = new HttpHeaders();
		//headers.add("Access-Control-Allow-Origin", "*");
		headers.add("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
		headers.add("Access-Control-Allow-Headers", "X-Requested-With,content-type");
		headers.add("Access-Control-Allow-Credentials", "true");
		List<Regle> regles = regleService.getByMoyenne(moyenne);
		List<RegleDTO> reglesDTO = new ArrayList<>();
		for(Regle r : regles) {
			reglesDTO.add(r.toDTO());
		}
		return new ResponseEntity<>(reglesDTO,headers,HttpStatus.OK);
	}
	
	@GetMapping("/ByCompetenceAndMoyenne={nom}&{moyenne}")
	public ResponseEntity<?> getByCompetenceAndMoyenne(@PathVariable("nom") String cnom,@PathVariable("moyenne") boolean moyenne){
		HttpHeaders headers = new HttpHeaders();
		//headers.add("Access-Control-Allow-Origin", "*");
		headers.add("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
		headers.add("Access-Control-Allow-Headers", "X-Requested-With,content-type");
		headers.add("Access-Control-Allow-Credentials", "true");
		List<Regle> regles = regleService.getByCompetenceAndMoyenne(cnom,moyenne);
		List<RegleDTO> reglesDTO = new ArrayList<>();
		for(Regle r : regles) {
			reglesDTO.add(r.toDTO());
		}
		return new ResponseEntity<>(reglesDTO,headers,HttpStatus.OK);
	}
	
	@GetMapping("/ByEquipeAndMoyenne={nom}&{moyenne}")
	public ResponseEntity<?> getByEquipeAndMoyenne(@PathVariable("nom") String nom,@PathVariable("moyenne") boolean moyenne){
		HttpHeaders headers = new HttpHeaders();
		//headers.add("Access-Control-Allow-Origin", "*");
		headers.add("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
		headers.add("Access-Control-Allow-Headers", "X-Requested-With,content-type");
		headers.add("Access-Control-Allow-Credentials", "true");
		List<Regle> regles = regleService.getByEquipeAndMoyenne(nom,moyenne);
		List<RegleDTO> reglesDTO = new ArrayList<>();
		for(Regle r : regles) {
			reglesDTO.add(r.toDTO());
		}
		return new ResponseEntity<>(reglesDTO,headers,HttpStatus.OK);
	}
	
	@GetMapping("/ByCompetenceAndEquipeAndMoyenne={cnom}&{enom}&{moyenne}")
	public ResponseEntity<?> getByCompetenceAndEquipeAndMoyenne(@PathVariable("cnom") String cnom, @PathVariable("enom") String enom,
			@PathVariable("moyenne") boolean moyenne){
		HttpHeaders headers = new HttpHeaders();
		//headers.add("Access-Control-Allow-Origin", "*");
		headers.add("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
		headers.add("Access-Control-Allow-Headers", "X-Requested-With,content-type");
		headers.add("Access-Control-Allow-Credentials", "true");
		List<Regle> regles = regleService.getByCompetenceAndEquipeAndMoyenne(cnom,enom,moyenne);
		List<RegleDTO> reglesDTO = new ArrayList<>();
		for(Regle r : regles) {
			reglesDTO.add(r.toDTO());
		}
		return new ResponseEntity<>(reglesDTO,headers,HttpStatus.OK);
	}

}
