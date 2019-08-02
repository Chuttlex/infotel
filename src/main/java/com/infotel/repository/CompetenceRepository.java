package com.infotel.repository;

import java.util.ArrayList;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.infotel.entity.Competence;
import com.infotel.entity.Dispositif;
import com.infotel.entity.Domaine;

@Repository
public interface CompetenceRepository extends CrudRepository<Competence, Integer> {
	ArrayList<Competence> findAll();
	ArrayList<Competence> findBydomaine(Domaine domaine);
	Competence findBynom(String nom);
	Competence findByid(int id);
}
