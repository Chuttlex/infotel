package com.infotel.repository;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.infotel.entity.Historiqueres;
import com.infotel.entity.Ressource;

@Repository
public interface HistoriqueresRepository extends CrudRepository<Historiqueres, Integer> {
	Historiqueres findByressource(Ressource ressource);
	ArrayList<Historiqueres> findAll();
	Historiqueres findByid(int id);
}
