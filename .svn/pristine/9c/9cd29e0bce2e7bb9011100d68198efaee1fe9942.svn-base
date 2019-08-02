package com.infotel.repository;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.infotel.entity.Competence;
import com.infotel.entity.Dispositif;
import com.infotel.entity.Dispositifhascompetence;
import com.infotel.entity.DispositifhascompetencePK;

@Repository
public interface DispositifhascompetenceRepository extends CrudRepository<Dispositifhascompetence, Integer> {
	Dispositifhascompetence findById(DispositifhascompetencePK id);
	ArrayList<Dispositifhascompetence> findAll();
	ArrayList<Dispositifhascompetence> findByDispositif(Dispositif dispositif);
	ArrayList<Dispositifhascompetence> findByCompetence(Competence competence);
	Dispositifhascompetence findByDispositifAndCompetence(Dispositif dispositif, Competence competence);
}
