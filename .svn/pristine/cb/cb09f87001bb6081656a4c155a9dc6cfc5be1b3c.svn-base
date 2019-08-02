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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infotel.dto.DispositifhascompetenceDTO;
import com.infotel.dto.RessourcehascompetenceDTO;
import com.infotel.entity.Dispositifhascompetence;
import com.infotel.entity.Ressourcehascompetence;
import com.infotel.service.DispositifhascompetenceService;
import com.infotel.service.RessourcehascompetenceService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/infotel/dispositifhascompetence")
public class DataGetDispositifhascompetenceController {
	
	private final Logger log = LoggerFactory.getLogger(DataCreateController.class);
	private final DispositifhascompetenceService dcService;
	
	public DataGetDispositifhascompetenceController(DispositifhascompetenceService dcService) {
		this.dcService=dcService;
	}
	
	@GetMapping("/ByDispositif={dispositif}")
	public ResponseEntity<?> getByDispositif(@PathVariable("dispositif") String nom){
		HttpHeaders headers = new HttpHeaders();
		//headers.add("Access-Control-Allow-Origin", "*");
		headers.add("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
		headers.add("Access-Control-Allow-Headers", "X-Requested-With,content-type");
		headers.add("Access-Control-Allow-Credentials", "true");
		List<Dispositifhascompetence> dcs = dcService.getByDispositif(nom);
		List<DispositifhascompetenceDTO> dcsDTO = new ArrayList<>();
		for(Dispositifhascompetence dc : dcs) {
			dcsDTO.add(dc.toDTO());
		}
		return new ResponseEntity<>(dcsDTO,headers,HttpStatus.OK);
	}
	
	@GetMapping("/ByCompetence={competence}")
	public ResponseEntity<?> getByCompetence(@PathVariable("competence") String nom){
		HttpHeaders headers = new HttpHeaders();
		//headers.add("Access-Control-Allow-Origin", "*");
		headers.add("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
		headers.add("Access-Control-Allow-Headers", "X-Requested-With,content-type");
		headers.add("Access-Control-Allow-Credentials", "true");
		List<Dispositifhascompetence> dcs = dcService.getByCompetence(nom);
		List<DispositifhascompetenceDTO> dcsDTO = new ArrayList<>();
		for(Dispositifhascompetence dc : dcs) {
			dcsDTO.add(dc.toDTO());
		}
		return new ResponseEntity<>(dcsDTO,headers,HttpStatus.OK);
	}
	
	@GetMapping("/ByDispositifAndCompetence={dispositif}&{competence}")
	public ResponseEntity<?> getByDispositif(@PathVariable("dispositif") String dnom, @PathVariable("competence") String cnom){
		HttpHeaders headers = new HttpHeaders();
		//headers.add("Access-Control-Allow-Origin", "*");
		headers.add("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
		headers.add("Access-Control-Allow-Headers", "X-Requested-With,content-type");
		headers.add("Access-Control-Allow-Credentials", "true");
		Dispositifhascompetence dc = dcService.getByDispositifAndCompetence(dnom,cnom);
		return new ResponseEntity<>(dc.toDTO(),headers,HttpStatus.OK);
	}

}
