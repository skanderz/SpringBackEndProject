package tn.spring.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.spring.entities.Participation;

@Repository
public interface ParticipationRep extends CrudRepository<Participation, Integer>{

}
