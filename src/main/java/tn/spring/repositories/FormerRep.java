package tn.spring.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.spring.entities.Former;

@Repository
public interface FormerRep extends CrudRepository<Former, Integer> {

}
