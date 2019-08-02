package com.infotel.controller;

import java.util.ArrayList;

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

import com.infotel.dto.DispositifDTO;
import com.infotel.entity.Dispositif;
import com.infotel.service.DispositifService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/infotel/dispositif")
public class DataGetDispositifController {
	
	private final Logger log = LoggerFactory.getLogger(DataCreateController.class);
	private final DispositifService dispService;
	
	public DataGetDispositifController(DispositifService dispService) {
		this.dispService=dispService;
	}
	
	@GetMapping("/ByNom={nom}")
	public ResponseEntity<?> getByNom(@PathVariable("nom") String nom){
		HttpHeaders headers = new HttpHeaders();
		//headers.add("Access-Control-Allow-Origin", "*");
		headers.add("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
		headers.add("Access-Control-Allow-Headers", "X-Requested-With,content-type");
		headers.add("Access-Control-Allow-Credentials", "true");
		Dispositif dispositif = dispService.getByNom(nom);
		return new ResponseEntity<>(dispositif.toDTO(),headers,HttpStatus.OK);
	}
	
	@GetMapping("/ByOrganisme={nom}")
	public ResponseEntity<?> getByOrganisme(@PathVariable("nom") String nom){
		HttpHeaders headers = new HttpHeaders();
		//headers.add("Access-Control-Allow-Origin", "*");
		headers.add("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
		headers.add("Access-Control-Allow-Headers", "X-Requested-With,content-type");
		headers.add("Access-Control-Allow-Credentials", "true");
		ArrayList<Dispositif> dispositifs = dispService.getByOrganisme(nom);
		ArrayList<DispositifDTO> dispositifsDTO = new ArrayList<>();
		for(Dispositif d: dispositifs) {
			dispositifsDTO.add(d.toDTO());
		}
		return new ResponseEntity<>(dispositifsDTO,headers,HttpStatus.OK);
	}

}
