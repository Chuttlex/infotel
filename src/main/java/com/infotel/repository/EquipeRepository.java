package com.infotel.repository;

import java.util.ArrayList;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.infotel.entity.Dispositif;
import com.infotel.entity.Equipe;

@Repository
public interface EquipeRepository extends CrudRepository<Equipe, Integer> {
	Equipe findBynom(String nom);
	ArrayList<Equipe> findBydispositif(Dispositif dispositif);
	ArrayList<Equipe> findByrescible(int nombre);
	Equipe findByid(int id);
	ArrayList<Equipe> findAll();
}
