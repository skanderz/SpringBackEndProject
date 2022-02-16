package tn.spring.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.spring.entities.Question;

@Repository
public interface QuestionRep extends CrudRepository<Question, Integer>{

}
