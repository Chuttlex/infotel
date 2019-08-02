package com.infotel.repository;

import java.util.ArrayList;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.infotel.entity.AutoComplete;

@Repository
public interface AutoCompleteRepository extends CrudRepository<AutoComplete, Integer> {
	ArrayList<AutoComplete> findAll();
	AutoComplete findByValue(String val);
	AutoComplete findByid(int id);
}
