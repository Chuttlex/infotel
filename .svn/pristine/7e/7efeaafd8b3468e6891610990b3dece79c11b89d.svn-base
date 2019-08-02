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

import com.infotel.entity.Historiqueres;
import com.infotel.service.HistoriqueresService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/infotel/historique")
public class DataGetHistoriqueController {
	
	private final Logger log = LoggerFactory.getLogger(DataCreateController.class);
	private final HistoriqueresService histService;
	
	public DataGetHistoriqueController(HistoriqueresService histService) {
		this.histService=histService;
	}
	
	@GetMapping("/ByRessource={nom}&{prenom}&{enom}")
public ResponseEntity<?> getByRessource(@PathVariable("nom") String nom, @PathVariable("prenom") String prenom,
		@PathVariable("enom") String enom){
		Historiqueres hist = histService.getByRessource(nom, prenom, enom);
		HttpHeaders headers = new HttpHeaders();
		//headers.add("Access-Control-Allow-Origin", "*");
		headers.add("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
		headers.add("Access-Control-Allow-Headers", "X-Requested-With,content-type");
		headers.add("Access-Control-Allow-Credentials", "true");
		return new ResponseEntity<>(hist.toDTO(),headers,HttpStatus.OK);
	}

}
