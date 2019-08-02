package com.infotel.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infotel.service.OrganismeService;
import com.infotel.entity.DispositifhascompetencePK;
import com.infotel.entity.Niveau;
import com.infotel.entity.RessourcehascompetencePK;
import com.infotel.service.AutoCompleteService;
import com.infotel.service.CompetenceService;
import com.infotel.service.DispositifService;
import com.infotel.service.DispositifhascompetenceService;
import com.infotel.service.DomaineService;
import com.infotel.service.EquipeService;
import com.infotel.service.HistoriqueresService;
import com.infotel.service.NiveauService;
import com.infotel.service.RegleService;
import com.infotel.service.RessourceService;
import com.infotel.service.RessourcehascompetenceService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/infotel")
public class DataDeleteController {
	private final Logger log = LoggerFactory.getLogger(DataCreateController.class);
	private final DispositifService dispositifService;
	private final OrganismeService organismeService;
	private final EquipeService equipeService;
	private final NiveauService niveauService;
	private final RessourceService resService;
	private final HistoriqueresService histService;
	private final CompetenceService compService;
	private final RegleService regleService;
	private final RessourcehascompetenceService rcService;
	private final DispositifhascompetenceService dcService;
	private final AutoCompleteService acService;
	
	public DataDeleteController(DispositifService dispositifService, OrganismeService orgService,EquipeService equipeService,
			NiveauService niveauService, RessourceService resService, HistoriqueresService histService, DomaineService domaineService,
			CompetenceService compService, RegleService regleService, RessourcehascompetenceService rcService,
			DispositifhascompetenceService dcService, AutoCompleteService acService) {
		this.dispositifService=dispositifService;this.organismeService=orgService;this.equipeService=equipeService;
		this.niveauService=niveauService;this.resService=resService;this.histService=histService;
		this.compService=compService;this.regleService=regleService;this.rcService=rcService;
		this.dcService=dcService;this.acService=acService;
	}
	
	@DeleteMapping("/deleteDispositif={id}")
	public ResponseEntity<?> deleteDispositif(@Valid @PathVariable("id") int id){
		HttpHeaders headers = new HttpHeaders();
		//headers.add("Access-Control-Allow-Origin", "*");
		headers.add("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
		headers.add("Access-Control-Allow-Headers", "X-Requested-With,content-type");
		headers.add("Access-Control-Allow-Credentials", "true");
		dispositifService.delete(id);
		return new ResponseEntity<>(headers,HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/deleteOrganisme={id}")
	public ResponseEntity<?> deleteOrganisme(@Valid @PathVariable("id") int id){
		HttpHeaders headers = new HttpHeaders();
		//headers.add("Access-Control-Allow-Origin", "*");
		headers.add("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
		headers.add("Access-Control-Allow-Headers", "X-Requested-With,content-type");
		headers.add("Access-Control-Allow-Credentials", "true");
		organismeService.delete(id);
		return new ResponseEntity<>(headers,HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/deleteEquipe={id}")
	public ResponseEntity<?> deleteEquipe(@Valid @PathVariable("id") int id){
		HttpHeaders headers = new HttpHeaders();
		//headers.add("Access-Control-Allow-Origin", "*");
		headers.add("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
		headers.add("Access-Control-Allow-Headers", "X-Requested-With,content-type");
		headers.add("Access-Control-Allow-Credentials", "true");
		equipeService.delete(id);
		return new ResponseEntity<>(headers,HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/deleteNiveau={id}")
	public ResponseEntity<?> deleteNiveau(@Valid @PathVariable("id") int id){
		HttpHeaders headers = new HttpHeaders();
		//headers.add("Access-Control-Allow-Origin", "*");
		headers.add("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
		headers.add("Access-Control-Allow-Headers", "X-Requested-With,content-type");
		headers.add("Access-Control-Allow-Credentials", "true");
		niveauService.delete(id);
		return new ResponseEntity<>(headers,HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/deleteNiveaux={org}")
	public ResponseEntity<?> deleteNiveaux(@Valid @PathVariable("org") String org){
		HttpHeaders headers = new HttpHeaders();
		//headers.add("Access-Control-Allow-Origin", "*");
		headers.add("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
		headers.add("Access-Control-Allow-Headers", "X-Requested-With,content-type");
		headers.add("Access-Control-Allow-Credentials", "true");
		List<Niveau> niveaux = this.niveauService.getByOrganisme(org);
		for(Niveau n : niveaux) {
			this.niveauService.delete(n.getId());
		}
		return new ResponseEntity<>(headers,HttpStatus.ACCEPTED);
	} 
	
	@DeleteMapping("/deleteRessource={id}")
	public ResponseEntity<?> deleteRessource(@Valid @PathVariable("id") int id){
		HttpHeaders headers = new HttpHeaders();
		//headers.add("Access-Control-Allow-Origin", "*");
		headers.add("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
		headers.add("Access-Control-Allow-Headers", "X-Requested-With,content-type");
		headers.add("Access-Control-Allow-Credentials", "true");
		resService.delete(id);
		return new ResponseEntity<>(headers,HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/deleteHistorique={id}")
	public ResponseEntity<?> deleteHistorique(@Valid @PathVariable("id") int id){
		HttpHeaders headers = new HttpHeaders();
		//headers.add("Access-Control-Allow-Origin", "*");
		headers.add("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
		headers.add("Access-Control-Allow-Headers", "X-Requested-With,content-type");
		headers.add("Access-Control-Allow-Credentials", "true");
		histService.delete(id);
		return new ResponseEntity<>(headers,HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/deleteCompetence={id}")
	public ResponseEntity<?> deleteCompetence(@Valid @PathVariable("id") int id){
		HttpHeaders headers = new HttpHeaders();
		//headers.add("Access-Control-Allow-Origin", "*");
		headers.add("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
		headers.add("Access-Control-Allow-Headers", "X-Requested-With,content-type");
		headers.add("Access-Control-Allow-Credentials", "true");
		compService.delete(id);
		return new ResponseEntity<>(headers,HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/deleteRegle={id}")
	public ResponseEntity<?> deleteRegle(@Valid @PathVariable("id") int id){
		HttpHeaders headers = new HttpHeaders();
		//headers.add("Access-Control-Allow-Origin", "*");
		headers.add("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
		headers.add("Access-Control-Allow-Headers", "X-Requested-With,content-type");
		headers.add("Access-Control-Allow-Credentials", "true");
		regleService.delete(id);
		return new ResponseEntity<>(headers,HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/deleteRessourcehascompetence={idr}&{idc}")
	public ResponseEntity<?> deleteRessourcehascompetence(@Valid @PathVariable("idr") int idr, @Valid @PathVariable("idc") int idc){
		HttpHeaders headers = new HttpHeaders();
		//headers.add("Access-Control-Allow-Origin", "*");
		headers.add("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
		headers.add("Access-Control-Allow-Headers", "X-Requested-With,content-type");
		headers.add("Access-Control-Allow-Credentials", "true");
		RessourcehascompetencePK id = new RessourcehascompetencePK(idr, idc);
		rcService.delete(id);
		return new ResponseEntity<>(headers,HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/deleteDispositifhascompetence={idd}&{idc}")
	public ResponseEntity<?> deleteDispositifhascompetence(@Valid @PathVariable("idd") int idd, @Valid @PathVariable("idc") int idc){
		HttpHeaders headers = new HttpHeaders();
		//headers.add("Access-Control-Allow-Origin", "*");
		headers.add("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
		headers.add("Access-Control-Allow-Headers", "X-Requested-With,content-type");
		headers.add("Access-Control-Allow-Credentials", "true");
		DispositifhascompetencePK id = new DispositifhascompetencePK(idd, idc);
		dcService.delete(id);
		return new ResponseEntity<>(headers,HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/deleteAutoComplete={id}")
	public ResponseEntity<?> deleteDispositifhascompetence(@Valid @PathVariable("id") int id){
		HttpHeaders headers = new HttpHeaders();
		//headers.add("Access-Control-Allow-Origin", "*");
		headers.add("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
		headers.add("Access-Control-Allow-Headers", "X-Requested-With,content-type");
		headers.add("Access-Control-Allow-Credentials", "true");
		acService.delete(id);
		return new ResponseEntity<>(headers,HttpStatus.ACCEPTED);
	}

}
