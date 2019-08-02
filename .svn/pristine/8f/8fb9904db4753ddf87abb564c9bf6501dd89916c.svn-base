package com.infotel.repository;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.infotel.entity.Organisme;
import com.infotel.entity.Dispositif;

@Repository
public interface OrganismeRepository extends CrudRepository<Organisme, Integer> {
	Organisme findByorganisme(String organisme);
	Organisme findByid(int id);
	ArrayList<Organisme> findAll();
}
