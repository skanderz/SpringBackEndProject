package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Question;


@Repository
public interface QuestionRep extends CrudRepository<Question, Integer>, JpaRepository<Question, Integer>{

}
