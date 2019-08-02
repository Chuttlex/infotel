package com.infotel.repository;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.infotel.entity.Organisme;
import com.infotel.entity.Niveau;

@Repository
public interface NiveauRepository extends CrudRepository<Niveau, Integer> {
	ArrayList<Niveau> findByorganisme(Organisme organisme);
	ArrayList<Niveau> findByvaleur(int niveau);
	ArrayList<Niveau> findAll();
	Niveau findByid(int id);
}
