package tn.spring.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.spring.entities.Candidat;



@Repository
public interface CandidatRep extends CrudRepository <Candidat,Integer>{

}
