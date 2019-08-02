package com.infotel.repository;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.infotel.entity.Competence;
import com.infotel.entity.Equipe;
import com.infotel.entity.Niveau;
import com.infotel.entity.Regle;

@Repository
public interface RegleRepository extends CrudRepository<Regle, Integer> {
	ArrayList<Regle> findByequipe(Equipe equipe);
	ArrayList<Regle> findBycompetence(Competence competence);
	ArrayList<Regle> findByniveau(Niveau niveau);
	ArrayList<Regle> findByEquipeAndCompetence(Equipe equipe, Competence competence);
	ArrayList<Regle> findByEquipeAndNiveau(Equipe equipe, Niveau niveau);
	ArrayList<Regle> findByNiveauAndCompetence(Niveau niveau, Competence competence);
	Regle findByEquipeAndCompetenceAndNiveau(Equipe equipe, Competence competence, Niveau niveau);
	ArrayList<Regle> findAll();
	Regle findByid(int id);
	ArrayList<Regle> findByPourcentage(double pourcentage);
	ArrayList<Regle> findByMoyenne(boolean moyenne);
	ArrayList<Regle> findByNombre(int nombre);
	ArrayList<Regle> findByPourcentageAndNombre(double pourcentage,int nombre);
	ArrayList<Regle> findByCompetenceAndPourcentage(Competence competence,double pourcentage);
	ArrayList<Regle> findByCompetenceAndNiveauAndPourcentage(Competence competence,Niveau niveau,double pourcentage);
	ArrayList<Regle> findByEquipeAndPourcentage(Equipe equipe,double pourcentage);
	ArrayList<Regle> findByEquipeAndMoyenne(Equipe equipe,boolean moyenne);
	ArrayList<Regle> findByCompetenceAndMoyenne(Competence competence, boolean moyenne);
	ArrayList<Regle> findByCompetenceAndEquipeAndMoyenne(Competence competence,Equipe equipe, boolean moyenne);
	ArrayList<Regle> findByEquipeAndNombre(Equipe equipe,int nombre);
	ArrayList<Regle> findByCompetenceAndNombre(Competence competence, int nombre);
	ArrayList<Regle> findByCompetenceAndNiveauAndNombre(Competence competence,Niveau niveau, int nombre);
	ArrayList<Regle> findByCompetenceAndEquipeAndNombre(Competence competence,Equipe equipe, int nombre);
}
