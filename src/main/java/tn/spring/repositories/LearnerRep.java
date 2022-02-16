package tn.spring.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.spring.entities.Learner;

@Repository
public interface LearnerRep extends CrudRepository<Learner, Integer> {

}
