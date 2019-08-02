package com.infotel.repository;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.infotel.entity.Competence;
import com.infotel.entity.Dispositif;
import com.infotel.entity.Organisme;

@Repository
public interface DispositifRepository extends CrudRepository<Dispositif,Integer>{
	Dispositif findBynom(String nom);
	ArrayList<Dispositif> findAll();
	Dispositif findByid(int id);
	ArrayList<Dispositif> findByOrganisme(Organisme org);
}
