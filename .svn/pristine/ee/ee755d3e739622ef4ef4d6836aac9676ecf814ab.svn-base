package com.infotel.repository;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.infotel.entity.Domaine;

@Repository
public interface DomaineRepository extends CrudRepository<Domaine, Integer> {
	ArrayList<Domaine> findAll();
	Domaine findByid(int id);
	Domaine findByvaleur(String val);
}
