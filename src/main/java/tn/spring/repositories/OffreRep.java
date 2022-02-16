package tn.spring.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.spring.entities.Offre;



@Repository
public interface OffreRep extends CrudRepository <Offre,Integer>{

}
