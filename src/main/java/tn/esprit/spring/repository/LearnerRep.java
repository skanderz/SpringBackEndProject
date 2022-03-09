package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Learner;


@Repository
public interface LearnerRep extends CrudRepository<Learner, Integer> ,JpaRepository<Learner, Integer> {

}
