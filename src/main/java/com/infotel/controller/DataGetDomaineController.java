package com.infotel.controller;

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

import com.infotel.entity.Domaine;
import com.infotel.service.DomaineService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/infotel/domaine")
public class DataGetDomaineController {
	
	private final Logger log = LoggerFactory.getLogger(DataCreateController.class);
	private final DomaineService domaineService;
	
	public DataGetDomaineController(DomaineService domaineService) {
		this.domaineService=domaineService;
	}
	
	@GetMapping("/ByNom={nom}")
	public ResponseEntity<?> getByNom(@PathVariable("nom") String nom){
		HttpHeaders headers = new HttpHeaders();
		//headers.add("Access-Control-Allow-Origin", "*");
		headers.add("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
		headers.add("Access-Control-Allow-Headers", "X-Requested-With,content-type");
		headers.add("Access-Control-Allow-Credentials", "true");
		Domaine domaine = domaineService.getByNom(nom);
		return new ResponseEntity<>(domaine.toDTO(),headers,HttpStatus.OK);
	}

}
